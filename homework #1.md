# Spring boot edu homework #1

## 수업 일시 : 2018 / 07 / 31

### 1. Class loader

    Java Byte Code 를 메모리 상에 load 시켜주는 역할
    Runtime에 동적으로 class들을 load 한다.
    계층구조를 가지고 있으며, 가장 상위의 class loader 부터 작동한다?
    unload 기능은 제공하지 않으며, GC를 통해서 unload 됨.

### 2. Class loader 계층 구조

    1) Bootstrap class loader
    2) Extension class loader
    3) System class loader
    4) User-defined class loader

    위의 계층대로 class를 찾아서 로드 합니다.


### 3. 메모리 구조

    프로그램을 실행하기 위해 데이터 및 명령어를 저장하는 공간

    여기에서는 JVM 메모리 구조를 위주로 작성하겠습니다.

    기본적으로 아래의 list에 나열된 요소들로 구성된다.

    1) class
    2) stack
    3) heap
    4) native method
    5) pc register

    1) class area

        method area, code area, static area로 불림

        i. field information : 멤버 변수의 이름, 데이터 타입, 접근 제어자에 대한 정보
        ii. Method information : method에 대한 정보
        iii. Type information : class 인지, interface인지를 저장
        iv. Constant pool : 상수들을 저장

    2) stack area

        기본적으로 stack 구조로 되어 있음.

        method들이 호출 될떄 마다 push 되고, 리턴하고나면 pop 되는 구조
        method들이 호출 될때마다 stack frame이 생성되어 push 됨
        각각의 stack frame들은 method에서 사용하는 각종 변수, 리턴 값, 임시값등을 저장

    3) heap area

        new 연산자를 통해 생성되는 instance들이 로드되는 부분
        permanant generation, new, old 세부분으로 나뉨

        permanant generation : 생성된 객체들의 주소값 저장
        new : 새롭게 생성된 instance 들이 저장
        old : 참조된지 시간이 좀 지난 instance 들이 저장

    4) native method

        자바 이외의 다른 언어에서 제공되는 method 들이 저장되는 공간

    5) pc register
    
        thread 들이 생성되고, 실행되는 관련 정보들이 저장되는 곳

### 4. AOP 용어 정리 (그림과 함께)

    1) 기본 개념 : 기능을 비즈니스 로직을 수행하는 부분과 공통적으로 수행하는 부분을 나눈 것
                공통 모듈로는 로깅, 보안, 인증과 같은 기능들이 있다.
    
    2) 사용되는 경우
        i. 간단한 메소드 검사
        ii. 트랜잭션 처리
        iii. 예외반환
    
    3) 구성요소
        i. JoinPoint
            공통 모듈이 실행 될 수 있는 위치
        ii. PointCut
            해당 지점에서 어떤 동작이 실행 될지 지정하는 부분
        iii. advise
            각 join point에 삽입되어 동작 될 수 있는 코드
            before advise :method 실행 전 실행
            after returning advise : method가 정상적으로 실행 된 뒤 실행
            after throwing advise : method 가 예외를 받았을 때 실행
            around advise : 모든 지점에서 실행 가능
            
        iv. weaving | crossCutting
            pointCut에 의해 결정된 jointPoint에 삽입하는 과정

        v. introduction | declare intertype
            AOP를 좀 더 동적으로 사용할 수 있게 하는 방법

        ![AOP 이미지](/img/AOP-picture.png)

### 5. proxy class

    비즈니스 로직이 아닌, AOP에서 보여주는 모든 비즈니스 로직 method가 필요로하는 부분을 따로 모아둔 class

### 6. GCLib 

    AOP를 적용하기 위해, 만일 interface가 없는 경우 이를 보완해주는 라이브러리.
    이와 친구 관계인 것이 JDK Dynamic Proxy 와 AspectJ 입니다. 이는 interface가 있는 class에 대해 AOP를 적용할 수 있는 것 입니다.

    또 다른 점으로는 GClib는 runtime에 동적으로 bytecode를 생성해서 AOP를 적용한다. 이후 호출에는 생성한 bytecode를 재사용해서 성능 향상도 꽤한다.

    반면, JDK Dynamic proxy에서는 interface를 추출해서 advise 되는 method를 찾아서 실행하기 때문에, 성능 저하를 불러일으킨다는 말도 있다.

### 7. (java) Thread & 공용 객체

    프로그램을 실행 시키면, process가 하나 생성되어 실행이 됩니다. 프로그램 안에서 한번에 여러개의 연산을 수행할 수 있는 부분이 있다면, thread를 생성해서 실행할 수 있습니다.
    알아서 각각 나눠진 task들은 thread에서 실행되며, 시간을 단축할 수 있습니다.

    하지만, 이들 중에 공용으로 접근해야하는 리소스가 존재하는 경우가 발생할 떄도 있습니다. 이를 공용 객체라고 합니다.
    공용 객체는 하나가 아니라 여러개가 있을 수 있으며, 때에 따라서 이 떄문에 dead lock이 발생 할 수도 있습니다.
    아니면, 공용객체에 대한 접근이 꼬여서 데이터가 이상하게 나오는 경우도 있습니다.

    이를 방지하기 위해서 java에서는 synchronize 라는 선언을 제공 합니다. 해당 키워드가 선언되어 있으면, thread 들은 공용 객체에 접근 시, 순차적으로 접근하게 되며, 이를 thread safe하게 된다고 말 합니다.

### 8. Gradle / Maven 은 무엇인가?

    java를 빌드 시 사용할 수 있는 빌드 tool 중에 하나 입니다.

    1) Maven

        실행 시 다음과 같은 순서대로 수행 됩니다.
        compile -> test -> packaging

        i. compile
            src/main/java 폴더에 있는 모든 소스가 컴파일 됩니다.

        ii. test
            src/test/java, src/test/resources에 있는 테스트 관련 소스들이 컴파일 됩니다. 그리고 정의된 test 들이 순차적으로 수행

        iii. packaging
            위의 과정이 완료 된 후, jar, war 와 같은 파일로 압축.

        Gradle 보다 먼저 나온 빌드 tool
        pom.xml를 이용해서 dependency 관계를 정의하고, 빌드하는 구조
        
        프로젝트에 대한 정보를 잘 보여줌. (ex. unit test coverage, dependancy list, cross referenced check)

        위의 내용을 정리하자면, 빌드 툴이자 라이브러리 관리자 역할을 합니다.

    2) Gradle

        위에 나오는 Maven 보다 좀 더 성능이 좋고, 사용하기 유용한 기능들을 추가한 빌드 툴 입니다.
        나중에 나온 만큼, 기존에 존재하던 빌드 툴들의 장점을 모아서 만들었습니다.

        가장 큰 특징으로는 pom.xml을 통해서 외부 라이브러리들을 관리하는 것을 할 필요가 없습니다.
        프로그램들에 대한 요구사항이 많아짐에 따라 pom.xml의 구조도 점점 복잡해져 갔는데, 더 이상 개발자들을 도우지 못하고 발목만 잡는 존재가 되어서 gradle에서는 꼭 사용하지 않아도 되는 것으로 바뀌었습니다.

        대신, jvm에서 구동되는 script 언어인 groovy를 통해서 라이브러리 상속 관계를 표현할 수 있게 되어서, xml의 한계를 극복한 형태 입니다.


