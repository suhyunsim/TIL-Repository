# Spring Rest Docs

## API 문서 관리
### API 문서를 관리하는 방법과 사용 후 느낀 점
#### Postman
* mock server 제공
* 요청, 응답을 확인 할 수 있는 다양한 기능 제공
* 문서화 하기 쉽고 가독성이 높음
* 요청할 수 있는 횟수에 제한이 있음
* mock server가 터질 위험이 있음

#### Swagger
* intellij에 몇 가지 설정이 필요함
* 설정만 하면 바로 자바코드에서 적용할 수 있음
* 자동 문서화
* Cors error 발생 가능

#### Wiki
* Github repository에서 wiki로 작성 가능
* 마크다운 문법 활용 가능
* 변경 사항을 직접 명시해주지 않으면 공유하는 팀원 간 소통에 오류가 있음

-> API 문서 자동화 필요성 느낌, Swagger 외의 자동화 툴 고민

### Spring Rest Docs
* 참고: 
[Spring Rest Docs 적용](https://woowabros.github.io/experience/2018/12/28/spring-rest-docs.html)
[Spring REST Docs에 날개를... (feat: Popup)](https://woowabros.github.io/experience/2020/05/13/rest-docs.html?fbclid=IwAR0yZrgHTOPbhcqmutlv4WDhmg9zCNK777oBtyaKoTQL3YKxURPhFgbibWA)

#### Swagger vs. Spring Rest Docs
* Swagger
    * API 동작 테스트 용도에 특화
    * annotation 추가
    * 동기화 
* Spring Rest Docs
    * 테스트 성공해야 문서 작성이 가능
    * 깔끔한 문서화

### 활용
* Spring
* Gradle
* jUnit4
* MockMvc
    * MockMvc(@WebMvcTest) vs. Rest Assured(@SpringBootTest)
        * 보통 문서를 작성할때 서비스 계층은 Mocking을 하여 작성
        * __Rest Assured__ 는 BDD 스타일로 직관적이지만 별도의 구성없이는 @SpringBootTest 로 수행 -> 전체 컨테스트를 로드하여 빈을 주입하기에 속도가 많이 느림
        * __MockMvc__ 는 @WebMvcTest 로 수행이 가능 -> Controller Layer 만 테스트 하기에 속도가 빠름
* AsciiDoc
    * [Gradle Multi Module에서 Spring Rest Docs 사용하기](https://jojoldu.tistory.com/289)
    * [Spring REST Docs](https://docs.spring.io/spring-restdocs/docs/current/reference/html5/#customizing-requests-and-responses)
    * Markdown vs. AsciiDoc
        * Markdown: slate에 의존해야만 하는 구조, Ruby & Gem, bundler까지 설치
        * UI 불친절
        * 빌드 시간이 오래 걸림 (Ruby 의존성)
        * AsciiDoc: 실제 Spring 프로젝트의 문서로 사용
    