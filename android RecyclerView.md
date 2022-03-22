### RecyclerView
공식문서 참조

> 오늘은 RecyclerView에 대해서 알아보고 간단히 공부하였다. 천천히 뜯어보면서 다시 코드를 복습해보자.

## 1. 구현 과정 
처음에 [Recyclerview 공식문서](https://developer.android.com/guide/topics/ui/layout/recyclerview?hl=ko#key-classes) 를 보고 공부했는데 샘플앱을 보고도 잘몰라 어리둥절하였는데 몇시간의 공부 끝에 얼추 알게 되었다.
먼저, RecyclerView를 사용하기 위해서는 알아야하는게 몇가지 있다.
1. recyclerview를 위한 item이 들어가는.xml
2. Adapter를 만들기
3. ViewHolder를 만들기
4. Data 보관 장소 만들기
5. main에서의 작업 

1번부터 보자.
사실 다 하고 1번에서 문제가 발생했다. 
> 발생한 문제 : 시뮬레이션 했을때 item이 1개만 보여 한참을 얼탔다 
> 알고보니 xml에서 아주 간단하게 문제가 있었다. 뭐 이런걸 몰랐을까 싶다.
> activity_recyclerview.xml 이라 만들고 안에 LinearLayout-> Textview를 넣어뒀었는데 LinearLayout의 height를 match_parent를 해서 하나당 꽉차서 보였다....후...이런 어처구니 없는걸 못봤다는게 더 열심히 해야하는 동기부여가 된다. 덕분에 열심히 공부했다....

2. Adapter 만들기
Recyclerview는 Adapter와 ViewHolder 두가지를 가지고 있다.
ViewHolder는 Recyclerview에 들어갈 각각의 항목의 view의 래퍼이다.
Adapter는 필요에 따라 Viewholder 객체를 만들고 이러한 뷰에 데이터를 설정하기도 한다. 뷰를 데이터에 연결하는 프로세서를 바인딩이라고 한다. 
라고 공홈에는 나와있는뎅

