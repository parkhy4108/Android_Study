## < View >
### View는 무엇인가?
=> 화면 구성의 최소 단위, 위젯 or 컴포넌트

### ViewGroup은 무엇인가?
=> View를 담을 수 있는 Container , View를 상속받는다.
ex ) LinearLayout, RelativeLayout, FrameLayout , ConstrantLayout etc

- LinearLayout 
  + 한뱡향으로 뷰 배치(방향성 = orientation 속성 - horizotal, vertical ) 
- RelativeLayout
  + 각 객체를 기준 상대적위치, toLeftof = @id/A alignparent - Left,Right,TOP etc
- FrameLayout
  + 객체를 만들면 왼쪽 위에 모두 겹쳐진다
  + 상황에 따라 레이아웃 보여줄때 사용
  + 오직 하나의 자식뷰만 가지기를 권고 => 한가지 뷰만 가지고 싶을때!
  + 화면을 여러 모듈 단위로 구성할 수 있도록 만들어줌
  + 화면 크기에 따라 동적 변화가 필요한 UI 구성에 적합한 요소
  + Fragment의 Container로 주로 사용
