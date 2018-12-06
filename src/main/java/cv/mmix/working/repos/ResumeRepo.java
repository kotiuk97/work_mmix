package cv.mmix.working.repos;

import cv.mmix.working.domain.Resume;
import cv.mmix.working.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResumeRepo extends JpaRepository<Resume, Long> {

    List<Resume> findAllByIsActive(Boolean isActive);
    Resume findFirstByUserId(Long userId);
//    Resume findByUserId(Long userId);

}
