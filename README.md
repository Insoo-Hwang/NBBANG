![logo](https://github.com/Insoo-Hwang/NBBANG/assets/70841847/d1eb3ca7-27bd-4631-bebe-49cdea9f2b35)

# NBBANG(N빵)
SpingBoot를 활용한 플랫폼 서비스

## 🖥️ 프로젝트 소개
OTT 계정 공유 또는 모임 금액 분할 관리 서비스를 제공하는 웹 & 안드로이드 앱

### 📆 개발 기간
* SpringBoot & Web : 2023.12.13 ~ 2023.12.20
* Android App : 2023.12.20 ~ 

### ⚙️ 개발 환경
- `Java 17`
- `JDK 17.0.1`
- **IDE** : IntelliJ
- **Framework** : SpringBoot 3.2.0
- **Database** : Postgre
- **ORM** : Hibernate
- **Web** : `HTML` + `JavaScript` + `CSS`
- **Android App** : `Kotlin`

### 🌳 ERD
  ![erd](https://github.com/Insoo-Hwang/NBBANG/assets/70841847/0dc514c3-7665-4507-82a9-65ef0b368cb0)

  ## 📌 주요 기능(Web)
  
  ### 😀 1. 로그인/회원 가입
  #### 회원 가입
  ![image](https://github.com/Insoo-Hwang/NBBANG/assets/70841847/62dfe4cf-2676-40e2-8f7f-26fcd0daa7bd)

  #### 로그인
  ![image](https://github.com/Insoo-Hwang/NBBANG/assets/70841847/8c6eee48-4cbe-444b-9fe8-31fac4d46c8b)

  #### Users DB
  ![image](https://github.com/Insoo-Hwang/NBBANG/assets/70841847/e132e89f-a625-4d89-9c44-d42c2ab3b57d)
  * User 정보 저장

  ### ✊ 2. 메인 화면
  #### 메인 화면
  ![image](https://github.com/Insoo-Hwang/NBBANG/assets/70841847/e050b3e2-07f9-4b9d-abe6-fd45c2c18a85)
  * 로그인 한 회원이 현재 참여 중인 방 목록

  #### User_Room_Relation
  ![image](https://github.com/Insoo-Hwang/NBBANG/assets/70841847/62f8ce7d-f802-46e3-9440-25d6bbb7dbf6)
  * User가 Room에 속한 여부 저장
 
  #### 초대 코드 입력
  ![image](https://github.com/Insoo-Hwang/NBBANG/assets/70841847/5684b3b1-5953-4977-a936-fbec88acd6a6)
  * 방마다 할당 된 초대 코드를 입력하여 직접 방에 접속
 
  #### 새로운 파티 찾아보기
  ![image](https://github.com/Insoo-Hwang/NBBANG/assets/70841847/a2d66a64-8d15-456d-a443-a3d74bc37a90)
  * 공개가 된 방에 직접 접속
 
  ### 🎈 3. N빵 파티(방)
  #### 파티 메인 화면
  ![image](https://github.com/Insoo-Hwang/NBBANG/assets/70841847/5b99b623-f1bd-4965-83ec-0c85ada58db6)

  #### Room DB
  ![image](https://github.com/Insoo-Hwang/NBBANG/assets/70841847/fba2f80f-e077-40f8-87da-107013dee0e5)
  * Room 정보 저장
 
  #### 공개 여부
  ![image](https://github.com/Insoo-Hwang/NBBANG/assets/70841847/35229eeb-133f-4eb1-bb81-cbdeccd9acf6)
  ![image](https://github.com/Insoo-Hwang/NBBANG/assets/70841847/d212f90a-64ff-4fee-836c-b9ac32c1ec00)

  #### 초대 코드
  ![image](https://github.com/Insoo-Hwang/NBBANG/assets/70841847/2435d365-e5e4-42e6-902e-70e319436130)
  * 초대 코드 클릭시 클립 보드에 복사
 
  #### 파티 제목/정보
  ![image](https://github.com/Insoo-Hwang/NBBANG/assets/70841847/6b98ae95-8266-4675-867f-58640e8dca6e)

  #### 파티 참여
  ![image](https://github.com/Insoo-Hwang/NBBANG/assets/70841847/403970df-b430-4b29-adc3-e81f82681390)
  * 기존 미참여시 참여 가능

  ![image](https://github.com/Insoo-Hwang/NBBANG/assets/70841847/6bb0eac5-8af6-4564-b0ca-d92c8cbbc115)
  * 기존 참여시 경고 메시지

  #### 파티 탈퇴
  ![image](https://github.com/Insoo-Hwang/NBBANG/assets/70841847/01a144b3-5e0b-4dfd-a603-1364cf0030cc)
  * 기존 참여시 탈퇴 가능
  * 파티장의 경우 해당 Room과 관련된 User 모두 제거후 파티 제거

  ![image](https://github.com/Insoo-Hwang/NBBANG/assets/70841847/3bc57d4c-15d0-4dc6-bc0d-d666acf7a5e6)
  * 기존 미참여시 경고 메시지

  #### 파티 수정
  ![image](https://github.com/Insoo-Hwang/NBBANG/assets/70841847/24868965-d131-4a55-9b7c-6d820e4edefa)
  ![image](https://github.com/Insoo-Hwang/NBBANG/assets/70841847/4462473c-471b-4158-bd51-9f2abf2c0ff8)
  * 파티를 만든 회원만 파티 수정 가능

  #### 참여 인원
  ![image](https://github.com/Insoo-Hwang/NBBANG/assets/70841847/fb703375-310b-4f7e-ac42-d02fd0a04e93)
  * 현재 파티에 참여하고 있는 전체 인원 조회
 
  #### N빵 목록
  ![image](https://github.com/Insoo-Hwang/NBBANG/assets/70841847/34bff051-e432-43eb-a80c-2c51994abe9a)
  * N빵할 목록 생성(파티장만 가능)

  ![image](https://github.com/Insoo-Hwang/NBBANG/assets/70841847/9825c4af-901d-4ce7-8032-fcb1f2bbf60b)

  ![image](https://github.com/Insoo-Hwang/NBBANG/assets/70841847/db49dfbb-7209-4288-bb0f-b536cc76c8ed)
  ![image](https://github.com/Insoo-Hwang/NBBANG/assets/70841847/4f5495d4-b5a1-4fc1-8503-6d2499e4449f)
  * 해당 N빵에 참여하고 있는 회원만 관련 정보 확인 가능

  #### Schedule DB
  ![image](https://github.com/Insoo-Hwang/NBBANG/assets/70841847/7210b1fa-0708-46e5-96ac-7eae888bb658)
  * N빵에 관한 정보 저장
 
  #### N빵 관리
  ![image](https://github.com/Insoo-Hwang/NBBANG/assets/70841847/f6b8ab81-f759-4d91-9738-7e9c3e1027f6)
  * 파티장만 접속 가능
 
  ![image](https://github.com/Insoo-Hwang/NBBANG/assets/70841847/ca54cd4e-2957-4649-b073-f69f71153fb4)
  * N빵 삭제
  * 해당 Schedule과 관련된 모든 User 삭제
 
  ![image](https://github.com/Insoo-Hwang/NBBANG/assets/70841847/7b9869e2-253f-4141-a00f-fd3c315afd38)
  * N빵 정보 수정

  ![image](https://github.com/Insoo-Hwang/NBBANG/assets/70841847/db9e818a-97f9-40ef-a240-a6eb34897f37)
  * +버튼을 통해 사용자 추가

  ![image](https://github.com/Insoo-Hwang/NBBANG/assets/70841847/177da938-14c0-4e7f-8778-4c9f67821767)
  * 기존 추가시 경고 메시지
 
  ![image](https://github.com/Insoo-Hwang/NBBANG/assets/70841847/d86d1316-5767-4f75-92bf-59615f777e5f)
  * -버튼을 통해 사용자 제거
 
  ![image](https://github.com/Insoo-Hwang/NBBANG/assets/70841847/6c2b1f99-2bda-4ea0-971c-6e43b93fbbc6)
  * 파티장 자기 자신은 제거 불가능
 
  #### User_Schedule_Relation DB
  ![image](https://github.com/Insoo-Hwang/NBBANG/assets/70841847/a42ed619-4d28-46e0-a734-0ca32a4bb49e)
  * User가 Schedule에 속한 여부 저장
 
  #### 한 마디 게시판
  ![image](https://github.com/Insoo-Hwang/NBBANG/assets/70841847/fc1f5250-39f2-45ba-b923-85020c17f88a)
  ![image](https://github.com/Insoo-Hwang/NBBANG/assets/70841847/50d899ec-c515-4773-8176-34ed73e0c0b5)
  * 파티 참여 인원만 게시글 작성 가능
 
  ![image](https://github.com/Insoo-Hwang/NBBANG/assets/70841847/4fccf2c7-0f4e-4050-b902-1e8ef21541bd)
  * 글 삭제는 글을 쓴 본인 또는 파티장만 가능

  #### Article DB
  ![image](https://github.com/Insoo-Hwang/NBBANG/assets/70841847/e8ae0dfe-99ff-4a72-834e-634f8ce5a8ff)
  * 작성한 Article에 관한 정보 저장
