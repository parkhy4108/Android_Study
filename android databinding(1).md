### DataBinding
#### 1. 빌드 설정
```kotlin
android {
        ...
        dataBinding {
            enabled = true
        }
    }

```
#### 2. layout 
```kotlin
<?xml version="1.0" encoding="utf-8"?>
    <layout xmlns:android="http://schemas.android.com/apk/res/android">
       <data>
           <variable name="user" type="com.example.User"/>
       </data>
       <LinearLayout
           android:orientation="vertical"
           android:layout_width="match_parent"
           android:layout_height="match_parent">
           <TextView android:layout_width="wrap_content"
               android:layout_height="wrap_content"
               android:text="@{user.firstName}"/>
           <TextView android:layout_width="wrap_content"
               android:layout_height="wrap_content"
               android:text="@{user.lastName}"/>
       </LinearLayout>
    </layout>
```
      코드를 보면 가장 밖에 layout 을 만들고 
      안에 <data><variable ... /></data>을 만든다.
      그 후 <LinearLayout> 안에 <TextView> 를 보면
      text 속성이 android:text="@{user.firstName}"/>
      @{} 구문을 사용하여 설정한다.
      
#### 3. data 객체
```kotlin
data class User(val firstName: String, val lastName: String)
```

#### 4. 데이터 바인딩
```kotlin

    override fun onCreate(savedInstanceState: Bundle?) {
    
        private lateinit var binding : ActivityMainBinding
    
        super.onCreate(savedInstanceState)

        val binding : ActivityMainBinding = DataBindingUtil.setContentView(
                this, R.layout.activity_main)
        
        val binding : ActivityMainBinding = ActivityMainBinding.inflate(get
                LayoutInflater())

        val binding = DataBindingUtil.setContentView(
                this, R.layout.activity_main)
        
        binding.user = User("Test", "User")
    }  
```
    이제 MainActivity에 binding 해주기 위해 클래스를 추가해주는데 
    private lateinit var 를 사용하여 먼저 선언해주고
    onCreate() 안에 DataBindingUtil.setContentView 해줘도 되고,
    아예 val binding : ActivityMainBinding = ActivityMainBinding.
    setContentView 해도 된다.
    또 setContentView 와 LayoutInflater 두 개를 사용할 수 있다.
    
Fragment, ListView, RecyclerView 어댑터 내에서 데이터 바인딩을 쓸거면

```kotlin
    val listItemBinding = ListItemBinding.inflate(layoutInflater, viewGroup, false)
    // or
    val listItemBinding = DataBindingUtil.inflate(layoutInflater, R.layout.list_item, viewGroup, false)
```
를 사용하면 된다.

     
