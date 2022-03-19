## Android Retrofit
> ###**1. Retrofit 이란 뭐지??**
  - **REST API 통신을 위해 구현된** 가장 많이 사용하는 대표적인 **_라이브러리_**
  - OkHttp 라이브러리 상위 호환
  - AsynkTask 없이 Backgtoud Thread 실행
  
> ###**2. 무얼 알아야 하지**?? 
> > 네트워크를 사용하려면 당연히 뭘 보내고 뭘 받고 어떻게 보낼지 생각해봐야지.
  1. 어디로 = 어떤 주소로 요청을 보내나?  
    - Reauest URL : 이걸 알아야한다
  2. 어떤 형태로 요청을 하나?
    - Json인지 html인지 
  3. 어떤 형태로 응답을 받나?
    - Reauest Method : GET or POST로 받는지 확인
  4. 어떤걸 받아올거야?
    - 필수 Parameter를 알아야한다. ( Postman 사이트에서 하나씩 빼보거나 해봄 알수있다. )

> ###**3. 사용 절차&방법
  1. gradle 추가
  2. AndroidManifest.xml
  3. data class 생성
  4. Interface 정의
  5. Retrofit 객체 생성
  6. HTTP 요청과 응답
  7. 
