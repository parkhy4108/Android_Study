## < 앱 크기 줄이기 >
1. Android App Bundle로 앱 업로드하기
2. Android 크기 분석기 사용
3. APK 구조 이해하기
4. 리소스 개수 및 크기 줄이기
5. 네이티브 및 자바 코드 줄이기


### 1. Android Bundle로 앱 업로드 ( 가장 쉽고 권장하는 방법 )
  + App Bundle = 컴파일된 코드와 리소스 포함 APK 생성 및 Google Playstore 서명은 보류
  + Dynamic Delivery = 앱 제공 모델 ( 구글 스토어 )
    App Bundle(150MB 압축 다운로드 크기 제한) 사용 , 사용자 최적 APK 생성 제공
    사용자는 앱 실행 코드와 리소스만 다운로드 하면 됨
### 2. 안드로이드 크기 분석기 사용
  + plugin marketplace에서 다운 
  + 메뉴바 Analyze -> Analyze App Size
### 3. 리소스 개수 및 크기 줄이기 
  1. 사용하지 않는 리소스 삭제 => 정적 코드 분석기 lint 도구( res/폴더의 리소스 감지. 잠재적 사용 X 리소스 발견, 알림 )
  2. android
      buildTypes { 
          release {
              shrinkResources true
              }
          }
      }
  3. 라이브러리에서 리소스 사용 최소화
  4. 특정 밀도만 지원
  5. 리소스 재사용
  6. 코드에서 렌더링
  7. PNG 파일 분석 = aapt 도구 사용 -> 무손실 압축
  8. PNG 및 JPEG 파일 압축 = pngcrush, pngquant , zopflipng
  9. WebP 파일 형식 사용
  10. 벡터 그래픽 사용
  11. 애니메이션 이미지에 벡터 그래픽 사용하기
  
### 4. 네이티브 및 자바 코드 줄이기
  1. 불필요 코드 삭제 => 프로토콜 버퍼 도구
  2. enurmerations 피하기
  3. 네이티브 바이너리 크기 줄이기 
  4. 디버그 기호 삭제
  5. 네이티브 라이브러리 추출 방지 => 출시버전 빌드할 때 android:extracNativeLibs = "false"
 
