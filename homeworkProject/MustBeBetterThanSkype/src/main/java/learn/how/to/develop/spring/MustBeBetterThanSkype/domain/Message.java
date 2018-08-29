package learn.how.to.develop.spring.MustBeBetterThanSkype.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;


@Getter
@Setter
@Entity
@Table(name="message")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Message implements Serializable {

    @Column(columnDefinition = "TEXT")
    private String messageText;

    @ManyToOne(fetch= FetchType.LAZY)
    private User from;

    @ManyToOne(fetch=FetchType.LAZY)
    private User to;

    private LocalDateTime sendTime;

    @ManyToOne(fetch=FetchType.LAZY)
    private ChatRoom chatRoomInfo;
}
