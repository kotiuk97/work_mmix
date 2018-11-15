package cv.mmix.working.controllers;

import cv.mmix.working.domain.*;
import cv.mmix.working.repos.ResumeRepo;
import cv.mmix.working.repos.SlidesRepo;
import cv.mmix.working.repos.UserRepo;
import cv.mmix.working.repos.VacancyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Controller
public class MainController {

    @Autowired
    private VacancyRepo vacancyRepo;

    @Autowired
    private ResumeRepo resumeRepo;

    @Autowired
    private SlidesRepo slidesRepo;

    @Autowired
    private UserRepo userRepo;

    @Value("${slide.images.upload.path}")
    private String uploadPath;

//    @GetMapping(name = "/rabota")
//    public String rabota(){
//        return "rabota";
//    }

    @GetMapping ("/rabota/slides")
    public String getSlides(Model model){
        List<Slide> slides = slidesRepo.findAll();
        model.addAttribute("slides", slides);

        return "slides";
    }

    @PostMapping("/rabota/slides")
    public String addSlide(
            @RequestParam MultipartFile image) throws IOException {
        if (image != null){
            Slide slide = new Slide();
            slide.setActive(true);
            slide.setImageName(uploadImage(image));
            slide.setPublicationDate(new Date(Calendar.getInstance().getTime().getTime()));

            slidesRepo.save(slide);
        }
        return "redirect:/rabota/slides";
    }

    @GetMapping("/rabota/slides/delete/{slide}")
    public String deleteSlide(@PathVariable Slide slide){
        File image = new File(uploadPath + "/" + slide.getImageName());
        if (image.exists()){
            image.delete();
        }
        slidesRepo.delete(slide);
        return "redirect:/rabota/slides";
    }

    @GetMapping("/rabota/slides/activation/{slide}")
    public String editSlide(@PathVariable Slide slide){
        slide.setActive(!slide.isActive());
        slidesRepo.save(slide);
        return "redirect:/rabota/slides";
    }

    /**
     * Returns image name
     * @param image
     * @return
     */
    protected String uploadImage(MultipartFile image) throws IOException {
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()){
            uploadDir.mkdirs();
        }
        String uuidFile = UUID.randomUUID().toString();
        String fileName = uuidFile + "." + image.getOriginalFilename();
        image.transferTo(new File(uploadPath + "/" + fileName));
        return fileName;
    }

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

    @GetMapping("/rabota")
    public String getMainPage(Model model){
        List<Slide> slides = slidesRepo.findAllByIsActive(true);
        model.addAttribute("slides", slides);
        return "rabota";
    }
}
