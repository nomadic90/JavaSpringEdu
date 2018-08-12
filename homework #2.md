# Spring boot edu homework #2

## 수업 일시 : 2018 / 08 / 07

### 1. Builder pattern

    객체 생성 시, 동일한 프로세스를 통해서 객체를 생성할 수 있게 한다.
    
    위에서 설명한 것이 필요한 이유는 객체 생성에 필요한 parameter가 많아지고, 필수 parameter 및 선택 parameter가 생기면서, 객체 생성이 매우 복잡해지기 때문 입니다.

```
example)

public class builderPattern {
    private int param1;
    private int param2;

    public builderPattern setParam1(int param1) {
        this.param1 = param1;
        return this;
    }

    public builderPattern setParam2(int param2){
        this.param2 = param2;
        return this;
    }

    public builderPattern build()
    {
        return new builderPattern(this);
    }
}

static void main(args[]){
    builderPattern bp = builderPattern
                        .setParam1(1)
                        .setParam2(2)
                        .build();

    // do something..
}
```

### 2. Lombok 사용법

    Lombok은 java에서 객체에서 필요로 하는 공통 함수들을 annotation을 통해서 쉽게 자동으로 구현해주는 프로젝트 입니다.

    위에서 설명한 builder pattern을 아주 손쉽게 구현해주는 java 에 빛과 소금과 같은 존재라고 할 수 있습니다.

```
// example)

@Getter
@Setter
public class className{
    private int param1;
}
```
    위의 예제 처럼 작성한다면, class 전체의 field에 getter, setter method 자동으로 생성 됩니다.

    static void main(String args[]){
        className cn = new className()
                        .param1(1)
                        .build();
    }

    각각의 getter, setter 메소드를 사용하기 위해선 위의 예제 처럼 작성 합니다.
    마지막에 build() method는 꼭 호출해줘야합니다.

    나머지, getter, tostring 과 같은 기능들은 구글에서 잘 찾습니다.


### 3. Default method

    java 8에서 추가된 새로운 기능

    interface의 모든 method를 구현해야하는 문제를 해결하기 위해 만들어짐.
    아래의 예제 코드와 같이 선언하여 사용이 가능. interface의 필요한 부분만 override하여 구현해서 사용 가능. 따라서 interface가 바뀌어도, 기존의 구현체에서 에러가 발생하지 않게 됨.

```
example)

public interface exampleClass {
    default int defaultFunc(){}
}
```

### 4. Java web programming - 4 types of scope (page, request, session, application)

    1) Page

        한 JSP 페이지 내에서 유효한 객체.
        JSP 파일에는 pageContext 가 내장되어 있으며, 이 객체는 page 영역 내에서만 유효.
        JSP 파일에 <% %> 안에 변수를 사용하면, 이 변수는 JSP 파일 내에서만 유효함.

    2) Request

        요청을 받아서 응답을 하기까지 객체가 유효한 영역
        request 관련 변수가 효유한 구간은 모두 Request Scope이라고 볼 수 있다.

    3) Session

        브라우저 당 생기는 하나의 객체.
        같은 세션 안에서는 요청과 응답이 모두 같은 session의 객체를 바라보게 되어 있습니다.
        로그인 정보와 같은 것이 세션으로 쓰일 수 있습니다.
        세션이 반환되기 전까지는 세션은 유지 됩니다.

    4) Application
    
        하나의 Application 당, 1개의 Application Object가 생성됩니다. 같은 Application 내에서 요청되는 페이지들은 같은 Application object를 공유합니다.
        Application 이 종료되면, 반환됩니다.

    이들 Scope는 범위가 각각 다른데 아래의 순서대로 큰 범위를 가진다고 볼 수 있습니다.

    Page < Request < Session < Application    
