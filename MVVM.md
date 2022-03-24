### MVVM
#### *[1] 구성요소*
    1. Model : 데이터 + 데이터 관련 행위( = 데이터 조작 로직 = 비즈니스 로직 )
    2. View : 사용자에게 보여지는 구조, 레이아웃 , 사용자와 상호작용, dataBiding을 통해 ViewModel에게 전달
    3. ViewModel : View의 추상화 형태. View에 보여줘야하는 데이터가 무엇인지와 명령들을 가지고 있다.
                  MVC 의 Controller , MVP 의 Presenter 의 역할을 하는데 
                  차이는 View 가 Observer 로 Binding 되어 Data 갱신을 View 가 자동으로 받아서 사용한다.
