## 먼저 Service가 무엇인가?
+ 앱이 UI 없이 백그라운드에서 특정 시간동안 실행되는 것을 의미한다.
+ 1. foreground service
+ 2. background service
+ ## But API 26, oreo version 부터 제한 걸림
=> Work Manager OR Alarm Manager 사용 
Jetpack 아키텍처 구성요소!!

## 언제 쓰나?
1. Service : UI없이 실행될 수 있지만 매우 길지 않은거. 만약 원한다면 스레드 생성 후 사용 
2. IntentService : 오래걸리지만 메인스레드와 관련이 없는 작업을 할 때 주로 이용. 만약 원한다면 Handler or BroadCast Intent 이용 => 현재는 Deprecated. --> WorkManager or JobIntentService

## 어떻게 사용하나?
1. Service : startService() 메소드에 의해 실행
2. IntentService : onHandlerIntent() 실행

## 위치 
1. Service : 백그라운드 동작, 메인스레드에 포함
2. IntentService : 새로운 스레드에서 동작

## Stop
1. Service : 사용자 몫 , stopSelf() or stopService()
2. IntentService : onHandlerIntent() 동작이 멈추면

## 단점
1. Service : 무거우면 메인스레드에 영향
2. IntentService : 병렬 수행 X , 연속 호출로 순차적 처리
