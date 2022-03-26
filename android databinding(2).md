### DataBinding + ViewModel + LivaData
#### DataBinding
    1. build 설정
    2. layout 설정
    3. MainActivity 설정
#### ViewModel
    1. build 설정
    2. ViewModel 클래스 생성
    3. MainActivity or Fragment 설정
#### LiveData
    1. build 설정
    2. Viewmodel 안에 LivaData 생성
    3. Obsever 연결
    
> build 설정은 넘어가자

#### 1_ ViewModel & DataBinding layout - 자세히는 안적음 
```kotlin
<layout>
    <data>
        <variable
            name="viewModel"
            type="com.xxx.yyy.viewModel" />
    </data>
    <LinearLayout>
        <Button android:onClick="@{()->viewModel.onClickButton()}"/>
    </LinearLayout>
</layout>
```
버튼 안에 onClick="@{()->viewModel.onClickButton()}" 만들어주면
나중에 button 하고 연결에 viewModel 의 onClickButton() 메서드 호출 -> 따로 만들어줘야함

#### 2_ ViewModel & LiveData 
```kotlin
class MyViewModel : ViewModel() {
    private val users: MutableLiveData<List<User>> by lazy {
        MutableLiveData<List<User>>().also {
            loadUsers()
        }
    }

    fun getUsers(): LiveData<List<User>> {
        return users
    }

    private fun loadUsers() {
        // Do an asynchronous operation to fetch users.
    }
    
    fun onClickButton(){
        // click시 할 행동 
    }
}
```

#### 3_ MainActivity
```kotlin
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()
     private lateinit var binding : ActivityMainBinding
     
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.myViewModel = myViewModel
        binding.lifecycleOwner = this
 
        myViewModel.getUsers().observe(this, Observer { User ->
            
        })
 
        btnAdd.setOnClickListener {
            
        }
    }
}
```



