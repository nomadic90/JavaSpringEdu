package learn.how.to.develop.spring.MustBeBetterThanSkype.repository;

import learn.how.to.develop.spring.MustBeBetterThanSkype.domain.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRoomRepository extends JpaRepository<ChatRoom, Long> {
    public ChatRoom getAllByExpireDateIsNull();
}
