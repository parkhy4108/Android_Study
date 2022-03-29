### Scope Function
```kotlin
//Scope Function 이란
// 객체의 컨텍스트 내에서 코드 블록을 실행할 수 있게 하는 함수
val hayoung = Person("hayoung", "InCheon")
println(hayoung)
hayoung.moveTo("Seoul")
println(hayoung)

// 이렇게 적혀있는 코드를
Person("hayoung","InCheon").let {
    println(it)
    it.moveTo("InCheon")
    println(it)
    
// 이렇게 바꿀수있다.
```
    
