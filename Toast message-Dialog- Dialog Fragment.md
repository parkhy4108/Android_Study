## < android Toast message >
    = 짧은 메시지 형식으로 사용자에게 알림 전달하는 팝업 , 단순 알림용 메시지
    -> Toast.makeText(context, message, short or Long )
    -> setgravity
    -> setview -> 토스트뷰를 만들어서 커스텀할때

## < Dialog >  = Deprecated -> AlertDialog 
    - 알림 / 경고 용도로 자주 사용하는 팝업창
    - 여러가지 대화 상자 디자인 빌드 가능
    - 현재는 Deprecated -> Dialog Fragment 사용 권장

1. AlertDialog.Builder 객체 생성 ( 제목, 콘텐츠영역, 작업버튼 )
2. button add  -> Positive
               -> Negative
3. 리스트 추가 ( 단일 선택 )
4. 다중 선택 추가

## < Dialog Fragment >
공식문서 = Dialog Fragment 사용 권장  
why? ) Dialog fragment 는 fragment의 생명주기를 활용할 수 있어서.
- Fragment 생명주기를 활용?? 어떤 이점이 있길래??  
- 기존 dialog 사용시에 Activity destroy 되더라도 dialog 존재로 생기는 leaked window crash, IllegelStateException 문제 해결 가능
