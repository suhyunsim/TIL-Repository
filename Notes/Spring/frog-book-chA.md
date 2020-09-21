# 스프링 MVC를 이용한 게시판 구축

## 구성

- STS 3
  - **Eclipse에서 Spring MVC 프로젝트 생성하는 방법**
    - New → Other → Spring → Spring Legacy Projects
    - Spring MVC Project로 생성
  
- Tomcat v9.0 Server at Localhost
- 인메모리DB: HSQL

    ```xml
    <!-- DB -->
    <!-- https://mvnrepository.com/artifact/org.hsqldb/hsqldb -->
    <dependency>
        <groupId>org.hsqldb</groupId>
        <artifactId>hsqldb</artifactId>
        <version>2.4.1</version>
        <scope>test</scope>
    </dependency>
    ```

- 스프링 프레임워크 데이터베이스 지원 라이브러리 추가: spring-jdbc

    ```xml
    <!-- JDBC -->
    <!-- https://mvnrepository.com/artifact/org.springframework/spring-jdbc -->
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-jdbc</artifactId>
        <version>${org.springframework-version}</version>
    </dependency>
    ```

- VO와 MyBatis를 이용한 DAO 구현
    - mybatis-spring

        ```xml
        <!-- Mybatis -->
        <!-- https://mvnrepository.com/artifact/org.mybatis/mybatis-spring -->
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis-spring</artifactId>
            <version>1.3.2</version>
        </dependency>
        ```

    - mybatis

        ```xml
        <!-- https://mvnrepository.com/artifact/org.mybatis/mybatis -->
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis</artifactId>
            <version>3.5.3</version>
        </dependency>
        ```

    - spring-orm

        ```xml
        <!-- https://mvnrepository.com/artifact/org.springframework/spring-orm -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-orm</artifactId>
            <version>${org.springframework-version}</version>
        </dependency>
        ```
### HSQL 빈으로 등록

- HSQL을 스프링 Application Context가 사용할 수 있도록 빈으로 등록
    - `/src/main/webapp/WEB-INF/spring/root-context.xml`
    - Namespaces
        - [x]  jdbc
    - Source

        ```xml
        <jdbc:embedded-database id="dataSource" type="HSQL">
        		<jdbc:script location="classpath:BoardSchema.sql" />
        		<jdbc:script location="classpath:BoardData.sql" />		
        	</jdbc:embedded-database>
        ```

        - 테이블 스키마를 정의하는 SQL 스크립트와 초기 데이터를 입력하는 SQL 스크립트를 각각 만들어서 추가

### VO와 MyBatis를 이용한 DAO 구현

- VO(Value Object) 데이터베이스의 테이블 구조를 그대로 반영
- MyBatis를 사용하기 위해 MyBatis의 SqlMapClient에 PSA를 적용한 어댑터를 빈으로 등록
    - `/src/main/webapp/WEB-INF/spring/root-context.xml`
    - Source

        ```xml
        <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
        	<property name="dataSource" ref="dataSource"></property>
        	<property name="configuration" value="classpath:sqlmap/config/mybatis-config.xml"></property>
        	<property name="mapperLocations">
        		<list>
        			<value>classpath:sqlmap/sqlmap-board.xml</value>
        		</list>
        	</property>
        </bean>

        <bean id="sqlSessionTemplate" class="org.mybatis.spring.SqlSessionTemplate" destroy-method="clearCache">
        	<constructor-arg ref="sqlSessionFactory"></constructor-arg>
        </bean>
        ```

- MyBatis 설정 파일
    - `src/main/webapp/resources/sqlmap/config/mybatis-config.xml`

    ```xml
    <?xml version="1.0" encoding="UTF-8"?>
    <!DOCTYPE configuration PUBLIC "-//mybatis.org//DTD Config 3.0//EN" "http://mybatis.org/dtd/mybatis-3-config.dtd">

    <configuration>
    	<!-- 마이바티스의 작동 규칙 정의 -->
    	<settings>
    		<setting name="cacheEnabled" value="false" />
    		<setting name="useGeneratedKeys" value="false"/>	
    		<setting name="mapUnderscoreToCamelCase" value="true"/>	
    	</settings>
    	
    	<typeAliases>
    		<typeAlias alias="boardVO" type="com.heaven.mvc.board.domain.BoardVO" />
    	</typeAliases>
    </configuration>
    ```

- SQL 스크립트 작성
    - `/src/main/webapp/resources/sqlmap/sqlmap-board.xml`

        ```xml
        <?xml version="1.0" encoding="UTF-8"?>
        <!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" 
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
        <mapper namespace="boardDAO">
        	<select id="list" resultType="boardVO">
        		SELECT * FROM BOARD
        		ORDER BY seq
        	</select>

        	<select id="select" parameterType="int" resultType="boardVO">
        		SELECT * FROM 
        		BOARD WHERE seq = #{seq}
        	</select>

        	<insert id="insert" parameterType="boardVO">
        		INSERT INTO BOARD
        		(title, content, writer, password, regDate, cnt)
        		VALUES
        		(#{title}, #{content}, #{writer}, #{password}, SYSDATE, 0);
        		<selectKey keyProperty="seq" resultType="Integer">
        			SELECT NVL(MAX(seq), 0) FROM BOARD
        		</selectKey>
        	</insert>
        	
        	
        	<update id="update" parameterType="boardVO">
        		UPDATE BOARD SET
        		title = #{title},
        		content = #{content},
        		writer = #{writer},
        		WHERE seq = #{seq}
        		AND password = #{password}
        	</update>

        	<update id="updateCount" parameterType="int">
        		UPDATE BOARD SET
        		cnt = cnt + 1
        		WHERE seq = #{seq}
        	</update>

        	<delete id="delete" parameterType="boardVO">
        		DELETE FROM BOARD
        		WHERE seq = #{seq}
        		AND password = #{password}
        	</delete>

        	<delete id="deleteAll">
        		DELETE FROM BOARD
        	</delete>
        	
        </mapper>
        ```

- 확장성을 고려해 BoardDao 인터페이스 → 이를 구현하는 BoardDaoMyBatis 클래스를 만든다

### 이클립스 lombok 설정

- pom.xml 추가

    ```xml
    <!-- Lombok -->
    <!-- https://mvnrepository.com/artifact/org.projectlombok/lombok -->
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <version>1.18.12</version>
        <scope>provided</scope>
    </dependency>
    ```

- lombok 어노테이션 인식 불가 문제 해결 방법

    1) lombok jar 파일 별도 설치 과정 필요
       - `~/.m2/repository/org/projectlombok/lombok/1.18.12` 위치로 이동
       - `java -jar lombok-1.18.12.jar` 로 실행
       - IDE 환경 추가 후 Install/Update

    2) eclipse.ini 혹은 STS.ini에 파라미터 추가
        ```xml
        -vmargs
        -Xbootclasspath/a:lombok.jar
        -javaagent:lombok.jar
        ```

    3) eclipse 재시작 하면 lombok 적용 완료

### 단위 테스트를 위해 코드 작성

- SpringJUnit4ClassRunner.class의 빨간줄 → JUnit 사용을 위한 spring-test dependency 추가

```xml
<dependency>
    <groupId>org.springframework</groupId>
        <artifactId>spring-test</artifactId>
            <version>${org.springframework-version}</version>
</dependency>
```

- `<version>${org.springframework-version}</version>` : `<properties>` 태그 안의 스프링 버전 변수명과 일치하지 않는 경우 일치시키기 위해 작성

### 구현 순서

- VO → DAO → 단위테스트 → Service → ServiceImpl → Controller
- 모델은 컨트롤러에서 뷰로 전달해주는 정보다.
- 스프링 MVC에서 모델을 생성하는 것은 DispatcherServlet의 역할로 생성한 모델에 대한 참조 변수는, `@RequestMapping`어노테이션이 붙은 메서드에서 인자를 선언하기만 하면 자동을 받을 수 있다.
- servlet-context.xml

    ```xml
    <!-- Resolves views selected for rendering by @Controllers to .jsp resources in the /WEB-INF/views directory -->
    <beans:bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
    	<beans:property name="prefix" value="/WEB-INF/views/" />
    	<beans:property name="suffix" value=".jsp" />
    </beans:bean>
    ```

- 만들어지는 뷰의 경로 `/src/main/webapp/WEB-INF/views/board/list.jsp`
- .jsp 파일은 jstl과 el 표기법을 이용해 결과를 표시한다.