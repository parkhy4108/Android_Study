## codelab 에 있는 예제 busschedule 이란 앱으로 room 사용법을 익히자
> 어떻게 사용하는지 천천히 과정을 기억하면서 공부하자.
1. data class 만들어서 Entity 만들기
2. Dao 클래스 만들기
3. Viewmodel 클래스 만들기
4. database 클래스 만들기
5. 리스트 어뎁터 만들기


### 1. Create an entity
    1. com.example.busschedule 패키지 안에 database 패키지를 만든다.
    2. database 패키지 안에 schedule 패키지를 만든다.
    - room 을 사용할때는 먼저 패키지를 분리해서 만든다. ( com.example.busschedule.database.schedule )
    3. schedule 패키지 안에 data class Schedule 만든다.
    4. 그리고 안에 @Entity 해서 안에 Column 들 넣고 만든다.
    
### 2. Define the DAO
    1. 
