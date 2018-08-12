# Spring boot edu homework #2

## 수업 일시 : 2018 / 08 / 07

### 1. Builder pattern

    객체 생성 시, 동일한 프로세스를 통해서 객체를 생성할 수 있게 한다.
    
    위에서 설명한 것이 필요한 이유는 객체 생성에 필요한 parameter가 많아지고, 필수 parameter 및 선택 parameter가 생기면서, 객체 생성이 매우 복잡해지기 때문 입니다.

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

### 2. Lombok 사용법

    Lombok은 java에서 객체에서 필요로 하는 공통 함수들을 annotation을 통해서 쉽게 자동으로 구현해주는 프로젝트 입니다.

    위에서 설명한 builder pattern을 아주 손쉽게 구현해주는 java 에 빛과 소금과 같은 존재라고 할 수 있습니다.

    example)

    @Getter
    @Setter
    public class className{
        private int param1;
    }

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

    

### 4. java web programming - 4 types of scope(page, request, session, application)

