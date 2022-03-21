## < Android Jetpack >
뭐야?? => 권장사항 준수, 상용구 코드 제거, 모든 Android version과 device에서 일관되게 작동하는 코드 작성을 돕는 라이브러리 모음!!!
뭐다?? = 개발에 편리한 라이브러리 모음이다.

## Jetpack 구성요소
1. Architecture
  + DataBinding : xml 파일에 Data를 연결해서 사용할 수 있게 해줌 -> findViewById 할 필요없음
  + LifeCycle :  Android Activity 생명주기 관련 유틸리티
  + LiveData : 데이터가 변경될 때 실시간으로 view에 알려줌
  + Navigation : Activity , Fragment 간 이동을 쉽게 도와준다
  + Paging : 대량의 데이터를 관리해주는 유틸리티
  + Room : Database를 보다 쉽게 사용할 수 있게 해줌
  + WorkManager : 백그라운드 작업을 보다 쉽게 도와줌
2. Foundation
  + AppCompat : 하위 안드로이드 앱에서 최근 버전 sdk를 사용할 수 있게 해줌
  + Android KTX : 코틀린 코드를 더욱 간결하게 만들어줌
  + Multidex : dex 관리 관련 유틸리티
3. Behavior
  + Download manager : 큰 파일 다운로드를 service 차원에서 관리하게 도와줌
  + Media & Playback : 미디어 파일 재생 관련 유틸리티
  + Notification : android notification 관련 유틸리티
  + Sharing :  Actionbar에서 데이터를 보다 쉽게 공유할 수 있게 도와준다
4. UI
  + 앱에서의 다양한 애니메이션, 이모지 또는 다양한 플랫폼(TV, Watch) 관련 유틸리티를 사용할 수 있게 해줌
