package learn.how.to.develop.spring.MustBeBetterThanSkype.domain;

import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

public class ChatRoom implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch= FetchType.LAZY)
    private List<User> members;

    private LocalDateTime regDate;

    @Nullable
    private LocalDateTime expireDate;
}
