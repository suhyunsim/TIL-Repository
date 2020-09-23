# Ch.B 자바 8 람다와 인터페이스 스펙 변화

## 람다가 도입된 이유 (순서대로)
* 빅데이터 지원 
* 병렬화 강화
  * 멀티 코어 프로세서 등장으로 병렬화 프로그래밍에 대한 필요성 
* 컬렉션 강화
  * Java의 array, list, set, map
* 스트림 강화 
  * 컬렉션의 효율적 사용을 위해
* 함수형 프로그래밍
  * 스트림 효율성
* 람다 도입 
* 인터페이스 명세 변경
* 함수형 인터페이스 도입
  * 람다를 지원하기 위한 인터페이스를 `함수형 인터페이스`라고 함

## 람다란?
* 코드 블록, 변수에 저장 가능한 로직
  * 변수는 지역변수, 속성, 메서드의 인자, 메서드의 반환값으로 사용될 수 있음
  -> 람다도!
* 기존:
  * 반드시 메서드 내에 존재해야 했음
  * 코드블록을 위해 메서드, 메서드를 사용하기 위해 익명 객체를 만들었음
* 자바 8:
  * 코드 블록인 람다를 메서드의 인자나 반환값으로 사용할 수 있음
  * 코드 블록을 변수처럼 사용할 수 있음

## 함수형 인터페이스
* 추상 메서드를 하나만 갖는 인터페이스
* 함수형 인터페이스만을 람다식으로 변경할 수 있음
  
## 메서드 레퍼런스와 생성자 레퍼런스
### 메서드 레퍼런스
* `인스턴스::인스턴스 메서드`
* `클래스::정적 메서드`
* `클래스::인스턴스 메서드`

### 생성자 레퍼런스
* `클래스::new`