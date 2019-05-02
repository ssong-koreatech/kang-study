# 강경태 스터디
## 코틀린, 스프링부트

### 2019 코틀린 나이트 컨퍼런스 내용입니다. 배워야 하는 이유랑 내용이 같아서 공유해요~

#### 자바 개발자 관점의 - 왜 코틀린인가
##### 카카오페이 firm banking gateway developer

#### 왜 코틀린을 선택했는가?

* 객체 생성이 쉬움
* Data class -> Lombok 대체 가능, Entity의 변경이 쉬움 -> val, var는 getter setter(var)와 한 몸
* Kotlin, Java 호환 + Intellij 내에서 코드 변환 가능(완벽하진 않음) -> 진입장벽 낮음
* Null Safety 지원 넉넉
* Godt Jetbrains - IDEA

#### Kotilin features

* JDK 6 이상부터 지원
* NullPointerException 거의 불가능 : 컴파일러 레벨에서 NPE를 막아줌
* null은 ? 키워드, !!키워드를 넣어주지 않으면 컴파일조차 불가능
* 외부파일에서 확장메소드 사용할 때에는, import 필요
* inline함수 지원
* 편의성을 갖춘 확장 함수들
* == : equals
* 삼항 연산자가 없음
* 문법적으로 Singletone 문법 지원
* 연산자 오버로딩 지원( Java에선 제거 )
