## Room
### OverView (개요)
    1. 설정
    2. 기본 구성요소
    3. 샘플 구현
* * *
#### 1. 설정
```kotlin
//Groovy
dependencies {
    def room_version = "2.4.2"

    implementation "androidx.room:room-runtime:$room_version"
    annotationProcessor "androidx.room:room-compiler:$room_version"
}
```
* * *
#### 2. 기본 구성 요소 Primary components

          + The database class that holds the database and serves as the main access point 
            for the underlying connection to your app's persisted data.
            = 데이터 베이스 클래스 : 데이터 베이스를 hold 하고 앱의 영구 데이터와 기본적 연결을 위한 메인 access point 로 역할을 한다.
          + Data entities that represent tables in your app's database.
            = 데이터 엔티티 : 앱의 데이터베이스 테이블을 represent하는 데이터 엔티티 있다. = Data value
          + Data access objects (DAOs) that provide methods that your app can use 
            to query, update, insert, and delete data in the database.
            = 데이터 엑세스 오브젝트 ( DAO ) : 앱에서 데이터베이스의 데이터를 quiry, update, insert, delete
            할 수 있게 해주는 메서드를 제공한다. = DB 조작 메서드 제공자
           
* * *
#### 3. 샘플 구현

3.1 ) Data entity

```kotlin
@Entity
data class User (
    @Primarkey val uid : Int ,
    @ColumnInfo(name = "first_name") val firstName : String?
    @ColumnInfo(name = "last_name") val lastName : String?
  )
```
+ User 인스턴스는 user 테이블에 있는 행 하나를 나타낸다.

3.2 ) DAO ( 데이터 엑세스 객체 )

```kotlin
@Dao
interface UserDao {
    @Query( "SELECT * FROM user" )
    fun getAll() : List<User>
    
    @Query( "SELECT * FROM user WHERE first_name LIKE : first AND "
            "last_name LIKE : last LIMIT 1" )
            fun findByName(first : String, last : String ) : User
            
            @Insert
            fun inserAll(varang users : User )
            
            @Delete
            fun delete(user : User )
}
```

3.3 ) Database
```kotlin
@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao() : UserDao
}
```
* * *
### Define data using entities
#### Anatomy of an entity
  -You define each Room entity as a class that is annotated with @Entity
   각 Room entity 를 @Entity 로 annotate 해서 클래스로 정의하라고 ok 확인
```kotlin
@Entity
data class User(
    @PrimaryKey val id: Int,
    val firstName: String?,
    val lastName: String?
)
```

  - By default, Room uses the class name as the database table name. 
    If you want the table to have a different name, set the tableName property of the @Entity annotation.
    디폴트로 , 보통은 각 클래스 이름을 테이블 이름에 맞춰서 사용한단다.
    근데 테이블 이름을 다르게 할거면 @Entiry 달아서 tableName 속성으로 바꾸란다. okay 확인.
    그리고 열도 똑같이 바꾸고 @ColumnInfo 달고 name 속성 쓰란다.
```kotlin
@Entity(tableName = "users")
data class User (
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "first_name") val firstName: String?,
    @ColumnInfo(name = "last_name") val lastName: String?
)
```

 - 기본키는 @PrimaryKey val id: Int
 - 복합키는 @Entity(primaryKeys = ["firstName", "lastName"])
 - @Ignore val picture: Bitmap? 보면 앞에 @Ignore 달았을때는 이 열 무시한단다.
 - 상속할 때 자식이 상속받는거 안쓸거면
```kotlin 
open class User {
    var picture: Bitmap? = null
}

@Entity(ignoredColumns = ["picture"])
data class RemoteUser(
    @PrimaryKey val id: Int,
    val hasVpn: Boolean
) : User()
``` 
@Entity(ignoredColumns = ["picture"]) 이렇게 사용한다.

* * *
## Accessing data using Room DAOs
### Anatomy of a DAO
```kotlin 
@Dao
interface UserDao {
    @Insert
    fun insertAll(vararg users: User)

    @Delete
    fun delete(user: User)

    @Query("SELECT * FROM user")
    fun getAll(): List<User>
}
```

### Convenience methods
- insert
```kotlin
@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUsers(vararg users: User)

    @Insert
    fun insertBothUsers(user1: User, user2: User)

    @Insert
    fun insertUsersAndFriends(user: User, friends: List<User>)
}
```
- Update
```kotlin
@Dao
interface UserDao {
    @Update
    fun updateUsers(vararg users: User)
}
```
- Query
 + SELECT 쿼리를 사용하여 데이터베이스의 User 객체를 모두 반환하는 메서드를 정의합니다. 
```kotlin
@Query("SELECT * FROM user")
fun loadAllUsers(): Array<User>
```

 + 테이블 column 의 하위 컬럼 반환하는 방법 
```kotlin 
data class NameTuple(
    @ColumnInfo(name = "first_name") val firstName: String?,
    @ColumnInfo(name = "last_name") val lastName: String?
)
```

그 다음에
```kotlin 
@Query( "SELECT first_name, last_name FROM user" )
fun loadFullName() : List<NameTuple> 
```
이렇게 하면 first_name 하고 last_name 컬럼의 값을 반환하고 NameTuple 클래스 필드에 매핑 될 수 있다고 한다.

 + 쿼리에 매개변수 전달하는 방법

```kotlin
@Query( "SELECT * FROM user WHERE age > :minAge" )
fun loadAllUsersOlderThan(minAge: Int): Array<User>
```

이렇게도 가능하다고 한다.
```kotlin
@Query("SELECT * FROM user WHERE age BETWEEN :minAge AND :maxAge")
fun loadAllUsersBetweenAges(minAge: Int, maxAge: Int): Array<User>

@Query("SELECT * FROM user WHERE first_name LIKE :search " +
       "OR last_name LIKE :search")
fun findUserWithName(search: String): List<User>
```















