### viewmodel
#### Share data between fragments
1. SharedViewModel 만들기
```kotlin
class SharedViewModel : ViewModel() {
    val selected = MutableLiveData<Item>()

    fun select(item: Item) {
        selected.value = item
    }
}
```
2. ListFragment 와 DetailFragment 만들기
  - 각 프래그먼트가 ViewModelProvider 로 가져올 때 동일하게 ShraedViewModel 인스턴스를 공유한다.
  - 서로 알 필요 없고 하나가 사라져도 작동한다.
  - 자체 수명 주기가 있고, 영향이 없다. 
```kotlin
class ListFragment : Fragment() {

    private lateinit var itemSelector: Selector

    // Use the 'by activityViewModels()' Kotlin property delegate
    // from the fragment-ktx artifact
    private val model: SharedViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        itemSelector.setOnClickListener { item ->
            // Update the UI
        }
    }
}

class DetailFragment : Fragment() {

    // Use the 'by activityViewModels()' Kotlin property delegate
    // from the fragment-ktx artifact
    private val model: SharedViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        model.selected.observe(viewLifecycleOwner, Observer<Item> { item ->
            // Update the UI
        })
    }
}
```
      viewmodel을 fragment에서 사용하는건 따로 빼서 다시 알아봐야겠다. 공홈의 예제는 불편한 점이 있다 느껴 다른 블로그 꼭 참조해서 공부하자.

### Replacing Loader view ViewModel
- 로더가 클래스가 하던 일을 Room, LivaData 로 같이 작업하여 대체한다.
![image](https://user-images.githubusercontent.com/84521065/160222894-6a3dbed8-c991-485b-9cdc-ee98ec62513a.png)

### Use coroutines with ViewModel
 - ViewModel includes support for Kotlin coroutines. For more information, see Use Kotlin coroutines with Android Architecture Components.
 뷰모델은 코루틴을 위한 지원이 포함된다고 한다. 자세한 사항은 코루틴을 사용한 앱 아키텍처를 참고하라고 하니 들어가서 공부해보자.
 코루틴은 비동기 작업을 지원하기 위한 것으로 안다. 뷰모델을 코루틴과 사용하면 확실히 복잡해지긴 하겠지만 분리하여 사용하기 때문에 서로 독립적으로 움직일것같다.
 
