## ViewModel과 ROOM을 사용한 간단한 예제

> 예제 안에 어떤것이 있고 내가 모르는게 무엇인지 찾아보며 공부하자.

### 1. 구성
 + package model
    - class Word
    - interface WordDao
    - class WordRepository
    - abstrac class WordRoomDatabase
 + view
    - MainActivity
    - NewWordActivity
    - WordListAdapter
 + viewmodel
    - WordViewModel

#### 1.1 model package
1. Word
```kotlin
@Entity(tableName = "word_table")
class Word(@PrimaryKey @ColumnInfo(name = "word") val word: String)
```
2. WordDao
```kotlin
@Dao
interface WordDao {

    @Query("SELECT * FROM word_table ")
    fun getAlphabetizedWords(): Flow<List<Word>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(word: Word)

    @Query("DELETE FROM word_table")
    suspend fun deleteAll()
}
```
3. WordRepository
```kotlin
class WordRepository(private val wordDao: WordDao) {

    val allWords: Flow<List<Word>> = wordDao.getAlphabetizedWords()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(word: Word) {
        wordDao.insert(word)
    }
}
```

4. WordRoom
```kotlin
@Database(entities = [Word::class], version = 1, exportSchema = false)
abstract class WordRoomDatabase: RoomDatabase() {

    abstract fun wordDao(): WordDao
    private class WordDatabaseCallback(private val scope: CoroutineScope) : RoomDatabase.Callback() {
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let { database -> scope.launch { populateDataBase(database.wordDao()) }
            }
        }
        suspend fun populateDataBase(wordDao: WordDao) {
            wordDao.deleteAll()
            var word = Word("Hello")
            wordDao.insert(word)
            word = Word("World!")
            wordDao.insert(word)
        }
    }
    companion object {
        @Volatile
        private var INSTANCE: WordRoomDatabase? = null

        fun getDatabase(context: Context, scope: CoroutineScope): WordRoomDatabase {
            return INSTANCE?:synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    WordRoomDatabase::class.java,
                    "word_database"
                )
                    .addCallback(WordDatabaseCallback(scope))
                    .build()
                INSTANCE= instance
                instance
            }
        }
    }
}
```
### 1.2 View
1. MainActivity
```kotlin
class MainActivity : AppCompatActivity() {

    private lateinit var resultLauncher: ActivityResultLauncher<Intent>
    private val wordViewModel : WordViewModel by viewModels {
        WordViewModelFactory((application as WordsApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        val adapter = WordListAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        wordViewModel.allWords.observe(this, Observer { words ->
            words.let { adapter.submitList(it) }
        })

        resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if ( it.resultCode == Activity.RESULT_OK){
                val word = Word(it.data?.getStringExtra("word")?:"")
                wordViewModel.insert(word)
            } else {
                Toast.makeText(applicationContext,R.string.empty_not_saved,Toast.LENGTH_LONG).show()
            }
        }

        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener {
            val intent = Intent(this, NewWordActivity::class.java)
            resultLauncher.launch(intent)
        }
    }
}
```

2. NewWordActivity

```kotlin
class NewWordActivity : AppCompatActivity() {

    private lateinit var editWordView : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_word)
        editWordView = findViewById(R.id.edit_word)

        val button = findViewById<Button>(R.id.button_save)
        button.setOnClickListener {
            val replyIntent = Intent()
            if(TextUtils.isEmpty(editWordView.text)) {
                setResult(RESULT_CANCELED, replyIntent)
            } else {
                val word = editWordView.text.toString()
                replyIntent.putExtra("word", word)
                setResult(RESULT_OK, replyIntent)
            }
            finish()
        }
    }
}
```

3. WordListAdapter
```kotlin
class WordListAdapter : ListAdapter<Word, WordListAdapter.WordViewHolder>(WordsComparator())  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        return WordViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current.word)
    }

    class WordViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val wordItemView: TextView = itemView.findViewById(R.id.textView)

        fun bind(text: String?) {
            wordItemView.text = text
        }

        companion object {
            fun create(parent: ViewGroup): WordViewHolder {
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.recyclerview_item, parent, false)
                return WordViewHolder(view)
            }
        }
    }

    class WordsComparator : DiffUtil.ItemCallback<Word>() {
        override fun areItemsTheSame(oldItem: Word, newItem: Word): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Word, newItem: Word): Boolean {
            return oldItem.word == newItem.word
        }
    }
}
```

### 3. ViewModel
```kotlin
class WordViewModel(private val repository: WordRepository) : ViewModel() {
    val allWords: LiveData<List<Word>> = repository.allWords.asLiveData()

    fun insert(word : Word) = viewModelScope.launch {
        repository.insert(word)
    }
}
class WordViewModelFactory(private val repository: WordRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(WordViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return WordViewModel(repository) as T
        }
        throw IllegalArgumentException("UnKnown ViewModel class")
    }
}
```

### 4. application class
```kotlin
class WordsApplication : Application() {
    val applicationScope = CoroutineScope(SupervisorJob())
    private val database by lazy { WordRoomDatabase.getDatabase(this, applicationScope) }
    val repository by lazy { WordRepository(database.wordDao()) }
}
```







