package cv.mmix.working.controllers;

import cv.mmix.working.domain.*;
import cv.mmix.working.repos.ResumeRepo;
import cv.mmix.working.repos.SlidesRepo;
import cv.mmix.working.repos.UserRepo;
import cv.mmix.working.repos.VacancyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
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
import java.util.List;

@Controller
@EnableGlobalMethodSecurity(prePostEnabled = true)
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
    @PreAuthorize("hasRole('ADMIN')")
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
            slide.setImageName(Uploader.uploadFile(image, uploadPath));
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

    @GetMapping("/rabota/vacancy")
    public String vacancy(){
        return "addVacancy";
    }

    @PostMapping("/rabota/vacancy")
    public String addVacancy(
            @AuthenticationPrincipal User user,
            @Valid Vacancy vacancy){
        if (user != null && user.getRole().equals(Role.EMPLOYER)){
            vacancy.setEmployer(user);
            vacancy.setActive(true);
            vacancy.setPublicationDate(new Date(Calendar.getInstance().getTime().getTime()));
            vacancy.setLastModifiedDate(new Date(Calendar.getInstance().getTime().getTime()));

            vacancyRepo.save(vacancy);
        }
        return "redirect:/vacancyList";

    }

    @GetMapping("/rabota/resume")
    public String resume(
            @AuthenticationPrincipal User user
    ){
        Resume resume = resumeRepo.findFirstByUserId(user.getId());
//        Resume resume = resumeRepo.Id(user.getId());
        if (resume != null ){
            return "redirect:/rabota/resume/edit/" + String.valueOf(resume.getId());
        }else{
            return "addResume";
        }
    }


    @GetMapping("/rabota/resume/edit/{resume}")
    public String editResume(
            @PathVariable Resume resume,
            Model model
    ){
        model.addAttribute("resume", resume);
        return "editResume";
    }

    @PostMapping("/rabota/resume")
    public String addResume(
            @AuthenticationPrincipal User user,
            @Valid Resume resume){
        if (user != null && user.getRole().equals(Role.USER)){
            resume.setUser(user);
            resume.setActive(true);
            resume.setPublicationDate(new Date(Calendar.getInstance().getTime().getTime()));
            resume.setLastModifiedDate(new Date(Calendar.getInstance().getTime().getTime()));

            resumeRepo.save(resume);
        }

        return "redirect:/rabota";

    }

    @GetMapping("/rabota/vacancies")
    public String getVacancies(
            Model model){
        List<Vacancy> vacancies = vacancyRepo.findAll();
        int i = 0;
        while (i < vacancies.size()){
            if (!vacancies.get(i).isActive()){
                vacancies.remove(i);
            }else{
                i++;
            }
        }
        model.addAttribute("vacancies",vacancies);
        return "vacancies";
    }

    @GetMapping("/rabota")
    public String getMainPage(Model model){
        List<Slide> slides = slidesRepo.findAllByIsActiveTrue();
        model.addAttribute("slides", slides);
        return "rabota";
    }

    @GetMapping("/rabota/resumes")
    public String resumes(Model model){
        List<Resume> resumes = resumeRepo.findAll();
//        List<Resume> resumes = resumeRepo.findAllByIsActive(true);
        model.addAttribute("resumes", resumes);

        return "resumes";
    }

    @GetMapping("/rabota/resumes/{resume}")
    public String resume(
            @PathVariable Resume resume,
            Model model){
        model.addAttribute("resume", resume);

        return "resume";
    }

    @GetMapping("/rabota/vacancy/{vacancy}")
    public String vacancy(
            @PathVariable Vacancy vacancy,
            Model model){
        model.addAttribute("vacancy", vacancy);

        return "vacancy";
    }

    @GetMapping("/rabota/vacancy/activation/{vacancy}")
    public String activationVacancy(
            @PathVariable Vacancy vacancy){
        vacancy.setActive(!vacancy.isActive());
        vacancy.setLastModifiedDate(new Date(Calendar.getInstance().getTime().getTime()));
        vacancyRepo.save(vacancy);

        return "redirect:/vacancyList";
    }

    @GetMapping("/rabota/vacancy/delete/{vacancy}")
    public String deleteVacancy(
            @PathVariable Vacancy vacancy){
        vacancyRepo.delete(vacancy);
        return "redirect:/vacancyList";
    }

    @GetMapping("/rabota/vacancy/update/{vacancy}")
    public String getVacancy(
            @PathVariable Vacancy vacancy,
            Model model){
        model.addAttribute("vacancy", vacancy);
        return "editVacancy";
    }

    @PostMapping("/rabota/vacancy/update")
    public String updateVacancy(
                @RequestParam Long id,
                @RequestParam(defaultValue = "") String name,
                @RequestParam(defaultValue = "") String description,
                @RequestParam(defaultValue = "") String contactPerson,
                @RequestParam(defaultValue = "") String phoneNumber,
                @RequestParam(defaultValue = "") String city,
                @RequestParam(defaultValue = "") String email,
                @RequestParam(defaultValue = "-1") Integer salary)
            {
                Vacancy vacancy = vacancyRepo.findById(id).get();
                if (vacancy != null){
                    vacancy.setActive(true);
                    if (!name.isEmpty()){
                        vacancy.setName(name);
                    }
                    if (!description.isEmpty()){
                        vacancy.setDescription(description);
                    }
                    if (!contactPerson.isEmpty()){
                        vacancy.setContactPerson(contactPerson);
                    }
                    if (!phoneNumber.isEmpty()){
                        vacancy.setPhoneNumber(phoneNumber);
                    }
                    if (!city.isEmpty()){
                        vacancy.setCity(city);
                    }
                    if (!email.isEmpty()){
                        vacancy.setEmail(email);
                    }
                    if (salary != -1){
                        vacancy.setSalary(salary);
                    }
                    vacancy.setLastModifiedDate(new Date(Calendar.getInstance().getTime().getTime()));
                    vacancyRepo.save(vacancy);
                }
        return "redirect:/vacancyList";

    }

}
