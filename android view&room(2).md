## Viewmodel과 Room을 함께 사용한 MVVM 예제 안에 잘 모르는것 정리.
### 1. suspend & @WorkerThread
```kotlin
// WordDao 클래스 s
interface WordDao 
    suspend fun insert(word: Word)
    suspend fun deleteAll()
    
//WordRepository 클래스
class WordRepository
    suspend fun insert(word: Word)
        wordDao.insert(word)
        
//WordRoomDatabase 클래스
abstract class WordRoomDatabase
    private class WordDatabaseCallback(private val scope: CoroutineScope)
        suspend fun populateDataBase(wordDao : WordDao)
```

      WordDao 는 interface -> suspend fun insert 선언 
      
      WordRepository 는 Repository 에서 Database 와 통신해야 한다. ( repo 말고 다른곳에서 하면 안된다. )
      그러므로 WordDao를 받아서 insert 해야하므로 insert를 구현해줘야한다.
      repository 는 Database 에 insert 할거야 => 근데 이 작업은 비동기로 작업해야돼 왜냐하면 DB랑 작업하는건 메인스레드에서 돌리기 무거워.
      @WorkerThread
      = suspend fun insert(word: Word)
      (suspend 메서드를 쓰려면 suspend 메소드 안에 써줘야한다. = suspend는 suspend로)
      그리고 이 안에 userDao.insert(word) 를 넣어줘야한다. 
      그리고 ViewModel 에서 insert(word: Word) 를 만들고 viewmodelScope로 launch 
      안에 repository.insert(word) 를 불러온다.
      
### 2. UserDao @Insert(onConflit = OnConflictStrategy.IGNORE)
```kotlin
 @Insert(onConflict = OnConflictStrategy.IGNORE)
 suspend fun insert(word: Word)
 onConflict 는 tracsaction 이 충돌이 발생했을때 어떻게 처리할지 지정해준다
 1. ABORT : 트랜잭션 중단 -> 롤백
 2. IGNORE : 무시
 3. REPLACE : 덮어쓰기 말 그대로 교체
 4. ROLLBACK : 이전으로 되돌리기
```
### 3. Flow<>
```kotlin
val allWords: Flow<List<Word>> = wordDao.getAlphabetizedWords()
suspend funtion 을 보완하기 위해 나왔다고 한다.
suspend 는 하나의 결과물을 보내고,
Flow 는 여개 개의 결과를 원하는 형식으로 보내준다.
또 다른 설명을 찾아보니 이런 말이 있었다.
"Coroutine 의 Flow 는 데이터 스트림이며, 코루틴 상에서 리액티브 프로그래밍 지원 하기 위한 구성요소이다."
리액티브 프로그래밍은 데이터가 변경될 때 이벤트를 발생시켜서 데이터를 계속해서 전달하도록 하는 프로그래밍 방식이다.
발행자와 구독자 개념 데이터를 발행하는 발행자 구독자에게 계속 데이터를 전달하는 역할을 함. 이런걸 데이터 스트림이라 한다.
그럼 여기서 왜 LiveData 로 바로 ViewModel 에게 보내주지 않고 리액티브한 코루틴의 데이터 스트림 Flow 를 사용해서 보내줄까??
The list of words is a public property. 
It's initialized by getting the Flow list of words from Room.
you can do this because of how you defined the getAlphabetizedWords method to return Flow in the "Observing database changes" step. 
Room executes all queries on a separate thread.
보자. word들의 리스트는 공개 속성이고, room 에서 Flow 리스트를 가져와 초기화 되어있다고 한다.
사용자가 데이터 베이스의 변화를 감지하는 step에서 flow를 반환하게 getAlphabetizedWords 를 정의하고 룸은 모든 쿼리를 별도의 스레드에서 실행한다.
이게 뭔 개소리야??
Flow를 왜 쓰는데 그래서... 좀 더 찾아보고 다시 와서 적자.
```
     

