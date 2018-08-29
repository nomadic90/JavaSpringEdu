package learn.how.to.develop.spring.MustBeBetterThanSkype.repository;

import learn.how.to.develop.spring.MustBeBetterThanSkype.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    public User findByEmail(String email);
}
