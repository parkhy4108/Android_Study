## < Sticky Intent >
### Sticky Intent 란 무엇인가??
=> 역할 수행 후에도 계속 메모리에 남아있는 Intent !! , sendStickyBraodcast()를 통해 송신되는 특별한 Intent들이다!

### 왜 필요하지??
=> 브로드 캐스트 리시버를 등록한 시점에는 시스템이 어떤 상황인지 확인하기 어렵다. 
   그래서 현재 상태를 가져오는 구문을 따로 추가해야 한다.
   그러나 sticky intent를 사용하면 리시버를 등록하는 순간 Intent가 전달되고 그 Intent 정보를 통해 현재 상태를 알 수 있다.
   
## < Pending Intent >
### Pending Intent는 무엇인가?
=> Notification 푸시 알림 탭할 시 일어날 동작 정의 위해 Pending Intent 사용

+ Intent 보유 클래스
+ 특정 시점 수행
+ 보통 '앱이 구동되지 않고 있을 때' 
+ 다른 프로세스에게 권한을 허가
+ Intent(다른 앱) 마치 본인 앱에서 실행되는 것처럼 
+ 무조건 수행
Usually => Notification, 위젯 런쳐, AlarmManager
