### < MVC >
#### MVC는 무엇일까

=> Model-View-Controller, 애플리케이션을 세가지 역할로 구분한 소프트웨어 디자인 패턴

+ MVC = Movel - View - Controlloer 로 만든 디자인 패턴
  + 디자인 패턴 : 소프트웨어 공학의 소프트웨어 디자인에서 특정 문맥에 공통적으로 발생하는 문제에 대해 재사용 가능한 해결책 ( 같은 문제로 고민하지 않게 형식 템플릿을 만들어둔것 )
    - 소프트웨어 공학 : 소프트웨어의 개발, 운용, 유지보수 등의 생명 주기 전반을 체계적이고 서술적이며 정량적으로 다루는 학문. 공학을 소프트웨어에 적용.
    - 소프트웨어 디자인 : software 해결책을 위한 문제해결과 계획 과정

1. Model : 데이터와 비즈니스 로직을 관리한다.
2. View : 레이아웃과 화면을 처리한다.
3. Controller : 명령을 모델과 뷰 부분으로 라우팅한다.

#### MVC는 왜 쓸까

=> 소프트웨어의 비즈니스 로직과 화면을 구분하는데 중점을 두고 있다.
   이러한 관심사 분리는 더 나은 업무의 분리와 향상된 관리를 제공한다.
   
    왜 비즈니스 로직과 화면을 구분하여 관심사 분리를 할까??? )
      => 관심사 분리를 이용하면 프로그램의 설계, 디플로이, 이용의 일부 관점에서 더
         높은 정도의 자유가 생긴다. 코드의 단순화 및 유지 보수의 더 높은 수준의 
         자유와 독립적인 개발과 업그레이드, 모듈 재사용을 자유가 높아진다. 
         자유도가 높아짐으로써 다른 부분의 세세한 사항을 모르더라도, 또 해당 부분들
         에 상응하는 변경을 취하지 않더라도 하나의 관심사의 코드 부분을 개선하거나 
         수정할 수 있기 때문에.
         
#### MVC는 어떻게 쓸까

=> 쇼핑 리스트 앱을 예로 들어 MVC를 어떻게 쓰는지 알아보자.

- 쇼핑 리스트 앱에는 사야할 각 항목의 이름, 개수, 가격의 목록이 있다.

1. Model : 앱이 포함해야할 데이터가 무엇인지를 정의한다. 데이터의 상태가 변경되면 모델을 뷰에 알리고 가끔 컨트롤러에 알리기도 한다.
- 리스트 항목이 포함해야 하는 데이터- 품목, 가격 등 이미 존재하는 리스트 항목이 무엇인지를 지정
2. View : 앱의 데이터를 보여주는 방식을 정의
- 쇼핑 리스트 앱에서, 뷰는 항목이 사용자에게 보여지는 방식을 정의하며, 표시할 데이터를 모델로부터 받는다.
3. Controller : 앱의 사용자로부터 입력에 대한 응답으로로 모델/뷰를 업데이트하는 로직을 포함한다.
- 쇼핑 리스트는 항목을 추가하거나 제거할 수 있게 해주는 입력 폼과 버튼을 가지고 있다. 이러한 액션들은 모델이 업데이트되는 것이므로 입력이 컨트롤러에게 전송되고, 모델을 적당하게 처리한 다음, 업데이트된 데이터를 뷰로 전송합니다.




