# HashMap과 ArrayMap , SparseMap의 차이는 무엇인가요??
> 안드로이드에서 메모리는 굉장히 중요합니다.
  hashmap은 해쉬 반환 함수로 인해 메모리 낭비가 클 가능성이 높고, 이를 줄이기 위해 Arraymap을 사용할 수 있습니다.
  Arraymap은 데이터의 생성,삭제 시 배열의 크기가 조절되게 구현해 메모리를 줄일 수 있지만 오버헤드의 발생이 생길수 있습니다. 
  또한 hashmap과 arraymap은 제네릭을 사용하여 JVM이 autoboxing하여 추가 메모리를 필요로 합니다. 
  이러한 메모리 사용을 줄이기 위해 Sparsemap은 앞선 두 HashMap, SparseMap 과 다르게 기본형을 사용하여 메모리 사용을 줄입니다.  
  안드로이드 개발자들은 아이템 개수가 1000개 미만, map이 값으로 map을 중첩하여 사용할 때는 arraymap or sparsemap을 사용하라 추천하고,
  그 외에는 hashmap 사용을 추천한다 나와있습니다.
  
## < HashMap >
what is hash map? = collection Framework에 thrgks 구현체 클래스, Map 인터페이스 구현 fun

###특징
1. 데이터 저장 key, value 형태
2. 해싱검색, 대용량 데이터 사용에 적합
3. key 중복 허용 x , value 중복 허용 o
       null 허용 o ,       null 허용 o

문제점  
= 해시 함수 반환 타입 int형이면 2^32 공간 필요 -> 불필요한 메모리 공간 낭비 발생 가능 UP!!

## < ArrayMap >
= 데이터가 많아지면 배열도 커지고, 데이터가 삭제되면 배열도 작아지는 map

###특징
1. 오버헤드가 발생할수 있다.
    ( 오버헤드란 함수를 생성하는데 드는 시간,메모리 = 비용을 말한다.)

## < SparseMap >
= Arraymap과 거의 동일한 구조를 가진 map , But 기본형

왜? 굳이? 기본형??
Hashmap, Arraymap = 제네릭 => JVM autoboxing !!

AutoBoxing은 뭐야?? 
기본형 -> Wrapper 클래스의 객체로 변형
=> 단점! Wrapper 객체 추가 생성 =====> 메모리 자원 사용 ( int = 4byte / Integer = 16 Byte )
이러한 메모리 사용을 줄이고자 Sparsearray는 기본형을 사용!
