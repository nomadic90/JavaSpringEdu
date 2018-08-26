Must be better than Skype

#1 설명

    Skype를 대체할만한 채팅 웹이 만들고 싶어졌습니다.
    Skype는 편리하긴 하지만, 기본적인 기능이 잘 동작하지 못할때가 많습니다.
    안정적이고 믿고 사용할 수 있는 채팅앱을 만들고자 합니다.

#2 Entity

    1. User
        email, String, pk
        password, String, encrypted
        alias, String
        regDate, LocalDateTime
        isLogin, bool

    2. Message (복합키 : from, to, sendTime, message)
        messageText, Text
        from, User
        to, User
        sendTime, LocalDateTime
        chatRoomInfo, CharRoom 

    3. ChatRoom
        id, Long, pk
        member, List<User>
        regDate, LocalDateTime
        expireDate, Nullable<LocalDateTime>