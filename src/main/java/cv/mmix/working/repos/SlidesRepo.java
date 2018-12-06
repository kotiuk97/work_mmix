package cv.mmix.working.repos;

import cv.mmix.working.domain.Slide;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SlidesRepo extends JpaRepository<Slide, Long> {

    Slide findByImageName(String imageName);
    List<Slide> findAllByIsActiveTrue();
}
