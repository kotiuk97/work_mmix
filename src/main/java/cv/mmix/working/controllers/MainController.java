package cv.mmix.working.controllers;

import cv.mmix.working.domain.Resume;
import cv.mmix.working.domain.Role;
import cv.mmix.working.domain.User;
import cv.mmix.working.domain.Vacancy;
import cv.mmix.working.repos.ResumeRepo;
import cv.mmix.working.repos.UserRepo;
import cv.mmix.working.repos.VacancyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.sql.Date;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private VacancyRepo vacancyRepo;

    @Autowired
    private ResumeRepo resumeRepo;

    @Autowired
    private UserRepo userRepo;

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
            @AuthenticationPrincipal User user,
            @Valid Vacancy vacancy){
        if (user != null && user.getRole().equals(Role.EMPLOYER)){
            vacancy.setEmploye(user);
            vacancy.setAvailable(true);
            vacancy.setPublicationDate(new Date(Calendar.getInstance().getTime().getTime()));
            vacancyRepo.save(vacancy);
        }
        return "redirect:/rabota";

    }

    @GetMapping("/rabota/resume")
    public String resume(){
        return "resume";
    }



    @PostMapping("/rabota/resume")
    public String addResume(
            @AuthenticationPrincipal User user,
            @Valid Resume resume){
        if (user != null && user.getRole().equals(Role.USER)){
            resume.setUser(user);
            resume.setAvailable(true);
            resume.setPublicationDate(new Date(Calendar.getInstance().getTime().getTime()));

            resumeRepo.save(resume);
        }

        return "redirect:/rabota";

    }

    @GetMapping("/rabota/vacancies")
    public String getVacancies(
            Model model){
        List<Vacancy> vacancies = vacancyRepo.findAll();
        model.addAttribute("vacancies",vacancies);

        return "vacancies";
    }
}
