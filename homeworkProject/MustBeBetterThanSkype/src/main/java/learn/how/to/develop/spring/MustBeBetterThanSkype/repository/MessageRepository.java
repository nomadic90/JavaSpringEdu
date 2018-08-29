package learn.how.to.develop.spring.MustBeBetterThanSkype.repository;

import learn.how.to.develop.spring.MustBeBetterThanSkype.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
    public Message addMessage(Message message);
}
