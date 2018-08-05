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

        [(AOP-picture)]


### 5. proxy class

    비즈니스 로직이 아닌, AOP에서 보여주는 모든 비즈니스 로직 method가 필요로하는 부분을 따로 모아둔 class

### 6. GCLib 

    AOP를 적용하기 위해, 만일 interface가 없는 경우 이를 보완해주는 라이브러리.
    이와 친구 관계인 것이 JDK Dynamic Proxy 와 AspectJ 입니다. 이는 interface가 있는 class에 대해 AOP를 적용할 수 있는 것 입니다.

    또 다른 점으로는 GClib는 runtime에 동적으로 bytecode를 생성해서 AOP를 적용한다. 이후 호출에는 생성한 bytecode를 재사용해서 성능 향상도 꽤한다.

    반면, JDK Dynamic proxy에서는 interface를 추출해서 advise 되는 method를 찾아서 실행하기 때문에, 성능 저하를 불러일으킨다는 말도 있다.

### 7. (java) Thread & 공용 객체

### 8. Gradle / Maven 은 무엇인가?
