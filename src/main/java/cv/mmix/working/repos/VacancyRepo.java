package cv.mmix.working.repos;

import cv.mmix.working.domain.Vacancy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VacancyRepo extends JpaRepository<Vacancy, Long> {

}
