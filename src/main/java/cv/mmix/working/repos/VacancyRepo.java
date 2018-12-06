package cv.mmix.working.repos;

import cv.mmix.working.domain.Vacancy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VacancyRepo extends JpaRepository<Vacancy, Long> {


    List<Vacancy> findAllByIsActiveTrue();
//    List<Vacancy> findAllByEmploye(User employer);

}
