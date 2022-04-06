##Permission
```kotlin
<permission android:description="string resource"
            android:icon="drawable resource"
            android:label="string resource"
            android:name="string"
            android:permissionGroup="string"
            android:protectionLevel=["normal" | "dangerous" |
                                     "signature" | ...] />
```

- description : 권한을 설명하기 위해 표시될 문자열 리소스 참조
- icon : 권한을 나타내는 아이콘
- label : 사용자에게 표시될 수 있는 권한 이름
- name : 코드에서 참조하는 권한 이름
- permissionGroup :그룹으로 권한을 설정   
- protectionLevel : 
      권한에 내포된 잠재적 위험을 특성화하고 
      권한을 요청하는 애플리케이션에 권한을 부여할지 여부를 결정할 때 
      시스템에서 따라야 하는 절차를 나타냅니다.
      - normal : 기본값. 설치 시 권한을 요청하는 앱에 자동 부여
      - dangerours : 위험성이 높은 권한. 확인을 요청하거나 자동으로 허용하지 못하게 함.
      - signature : 동일한 인증서 서명인 경우 권한 부여.
      
