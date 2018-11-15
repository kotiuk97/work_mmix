package cv.mmix.working.repos;

import cv.mmix.working.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {

    User findByEmail(String email);
    User findByFirstName(String firstName);
//    User findById(Long id);
//    User findByUsername(String username);
}
