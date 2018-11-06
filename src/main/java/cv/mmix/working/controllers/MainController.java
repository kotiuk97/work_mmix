package cv.mmix.working.controllers;

import cv.mmix.working.domain.Vacancy;
import cv.mmix.working.repos.VacancyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.sql.Date;
import java.util.Calendar;

@Controller
public class MainController {

    @Autowired
    private VacancyRepo vacancyRepo;

//    @GetMapping(name = "/rabota")
//    public String rabota(){
//        return "rabota";
//    }

    @GetMapping("/rabota/vacancy")
    public String vacancy(){
        return "vacancy";
    }

    @PostMapping("/rabota/vacancy")
    public String addVacancy(
            @Valid Vacancy vacancy){
        vacancy.setEmployeId(new Long(14));
        vacancy.setAvailable(true);
        vacancy.setPublicationDate(new Date(Calendar.getInstance().getTime().getTime()));

        vacancyRepo.save(vacancy);

        return "redirect:/main";

    }
}
