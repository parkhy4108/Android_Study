## Activity LifeCycle
![생명주기](https://user-images.githubusercontent.com/84521065/158197826-4eae5330-e05b-4bd1-9a46-65e462c4a1c7.png)
## [ 1 ] onCreate()
+ 프로그램 Activity가 생성할 때 실행되는 것
+ 필수적 콜백. Activity가 생성되면 동작하고 전체 생명주기에서 단 한번만 실행
## [ 2 ] onStart()
+ onCreate와 onRestart이후에 Activity가 시작되면 호출
+ Foreground와 상호작용 할 수 있음
+ 사용자에게 보이기 직전에 실행
+ 화면에 나타남
## [ 3 ] onResume()
+ Activity가 사용자와 상호작용하는 단계
+ 이벤트로 앱에서 포커스가 떠날때까지 머무름
+ 방해되어 일시정지 상태가 되면 onPasue()로 콜백을 호출
+ 일시정지에서 재개되면 다시 onResume() 메서드 호출
## [ 4 ] onPause()
+ 사용자가 Activity를 떠나는 것을 나타내는 첫번째.
+ foreground에 있지 않게 되었다는 것을 나타냄
+ 멀티윈도우에서 UI 관련 리소스와 작업을 완전히 해제하거나 조정할때는 onPause 대신 onStop 을 사용하는 것이 좋다
+ 아주 잠깐 실행되므로 데이터 저장, 네트워크 호출, 데이터 드랜잭션 실행하면 안됨
## [ 5 ] onStop()
+ 앱이 사용자에게 보이지 않는 동안 앱은 필요하지 않은 리소스를 해제하거나 조정
+ CPU를 비교적 많이 소모하는 종료 작업을 실행해야 함
+ 메모리 안에 머물고 있음.
+ 다시 시작되면 onRestart() 호출
+ 종료하면 onDestroy 호출
+ 
