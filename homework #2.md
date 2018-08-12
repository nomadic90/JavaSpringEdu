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

    

### 3. Default method

### 4. java web programming - 4 types of scope(page, request, session, application)

