package learn.how.to.develop.spring.MustBeBetterThanSkype.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name="user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User implements Serializable {
    @Id
    private String email;

    private String password;

    private String alias;

    private LocalDateTime regDate;

    private Boolean isLogin;
}
