package cv.mmix.working.repos;

import cv.mmix.working.domain.Resume;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResumeRepo extends JpaRepository<Resume, Long> {

}
