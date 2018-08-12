# Spring boot edu homework #3

## 수업 일시 : 2018 / 08 / 09

### 1. 객체 직렬화

    Java 객체로 된 데이터를 Java 외의 시스템에서도 사용할 수 있게, Byte 형태로 변환하는 과정.
    반대로, Byte 형태의 데이터를 Java 객체로 변환하는 것을 역직렬화라고 합니다.

    Java primitive type과 java.io.serializable interface를 상속받은 객체는 직렬화 할 수 있는 기본 조건을 가지게 됩니다.
    직렬화하는 방법은 java.io.ObjectOutputStream 객체를 이용합니다.

    역직렬화시, 직렬화 대상이되는 객체의 class 가 class path에 존재해야하며, import 되어 있어야 합니다.
    직렬화 대상이 되는 객체는 동일한 <SerialVersionUID>를 가져야 합니다.

    다른 시스템 간의 통신에 쓰일 때는 Json 또는 CSV 형태로 직렬화해서 데이터 전달을 합니다.
    Java 시스템 간의 통신에는 Byte로 직렬화하여, 데이터 통신을 하고 있습니다.