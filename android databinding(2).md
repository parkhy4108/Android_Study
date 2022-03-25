### LiveData
#### what is LiveData?
    LiveData 는 관찰 가능한 데이터 홀더 클래스이다.
    
#### LivaData 의 이점
    1. Ensures your UI matches your data state
    => UI가 데이터 상태와 일치하는지 보장, 확실하게 한다.
    2. No memory leaks
    => 메모리 누수 없음
    3. No crashes due to stopped activities
    => 정지된 액티비티로 인한 크래쉬가 발생하지 않는다.
    4. No more manual lifecycle handling
    => 수동으로 라이프 사이클을 다루지 않아도 된다.
    5. Always up to date data
    => 항상 최신 데이터
    6. Proper configuration changes
    => 제대로 된? 적합한? configuration 변경
    설명을 보면 디바이스의 화면전환 같은 걸로 
    configuration 이 change 하는것 때문에
    액티비티나 프래그먼트가 재생성되면, 
    즉시 최신 데이터를 받는다. 
    라고 되어있다.
    7. Sharing resources
    => resource 를 공유한다. 
    이것도 설명을 보면.
    You can extend a LiveData object using the singleton pattern to wrap system services so that they can be shared in your app.
    The LiveData object connects to the system service once, and then any observer that needs the resource can just watch the LiveData object. 
    For more information, see Extend LiveData.
    
    싱글톤 패턴을 사용하는 라이브 데이터 오브젝트를 앱에서 시스템 서비스들이 공유할 수 있도록 시스템 서비스 래핑으로 확장할 수 있다.
    라이브 데이터 오브젝트는 시스템 서비스와 한번 연결하면 resource가 필요한 모든 옵저버가 라이브 데이터 오브젝트를 볼 수 있다.  
    어렵다....
    
자 이제 그럼 어떻게 사용하는지 확인해보자. 
공홈을 보면 이렇게 나와있다.    
    
    Work with LiveData objects Follow these steps to work with LiveData objects: 
      1. Create an instance of LiveData to hold a certain type of data. 
         This is usually done within your ViewModel class. 
      2. Create an Observer object that defines the onChanged() method, which controls what happens 
         when the LiveData object's held data changes. 
         You usually create an Observer object in a UI controller, such as an activity or fragment. 
      3. Attach the Observer object to the LiveData object using the observe() method. 
         The observe() method takes a LifecycleOwner object. 
         This subscribes the Observer object to the LiveData object so that it is notified of changes. 
         You usually attach the Observer object in a UI controller, such as an activity or fragment.





