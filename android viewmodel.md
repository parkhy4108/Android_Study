### ViewModel 
#### what is ViewModel
    The ViewModel class is designed to store and manage UI-related data in a lifecycle conscious way. 
    The ViewModel class allows data to survive configuration changes such as screen rotations.
    뷰모델 클래스는 수명주기를 고려한 방식에서 ui 관련 데이터를 저장하고 관리하도록 설계 되었다.
    뷰모델 클래스는 스크린 로테이션 같이 configuration 변경에도 데이터를 유지하도록 한다. 
    
#### Implement a ViewModel
1. Declaring dependencies
```kotlin
dependencies {
          //groovy
          def lifecycle_version = "2.5.0-alpha05"
          def arch_version = "2.1.0"

          // kotlin
          val lifecycle_version = "2.5.0-alpha05"
          val arch_version = "2.1.0"

          // ViewModel
          implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version")
          // ViewModel utilities for Compose
          implementation("androidx.lifecycle:lifecycle-viewmodel-compose:$lifecycle_version")
          // LiveData
          implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version")
          // Saved state module for ViewModel
          implementation("androidx.lifecycle:lifecycle-viewmodel-savedstate:$lifecycle_version")
```
2. ViewModel Class
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
}
```

3. MainActivity 
```kotlin
class MyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        // Create a ViewModel the first time the system calls an activity's onCreate() method.
        // Re-created activities receive the same MyViewModel instance created by the first activity.

        // Use the 'by viewModels()' Kotlin property delegate
        // from the activity-ktx artifact
        val model: MyViewModel by viewModels()
        model.getUsers().observe(this, Observer<List<User>>{ users ->
            // update UI
        })
    }
}
```
