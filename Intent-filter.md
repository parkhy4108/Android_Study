## Intent
1. 명시적 인텐트
2. 암시적 인텐트 => 사용하려면 Intent-filter 적용 

< 왜 사용해? > 
+ 컴포넌트의 명을 정확히 모르기 때문에.
+ 인텐트 객체에 들어있는 여러 정보를 이용하여 호출해야할 컴포넌트의 정보를 알고 가장 적절한 컴포넌트를 찾기위해

< 효과 > 
+ 다른 앱에 내가 할 일을 넘길 수 있다.

< 어디에 선언 ? > 
+ 매니패스트에 선언

< 무엇을? >
1. <action> = 호출 시 수행되는 동작, 상태 지정
2. <data> = 인텐트가 수행될 때 필요한 항목, 타입을 지정하여 일치하는지 확인
3. <category> = 수행할 액션에 대한 추가적인 정보 정의

## 1. action
  intent.action._______ 
  -> MAIN , VIEW , EDIT , DELETE
     DIAL , CALL , SENDTO , ANSWER , DISCONVERED , WEB_SEARCH
## 2. category
  intent.category.LAUNCHER : 앱에 설치된 목록 보여지게
                 .DEFAULT : 암시적 인텐트를 받을수 있게 한다.
                 .BROWSABLE : 웹브라우저 기능 포함, 링크로 연결된 콘텐츠
