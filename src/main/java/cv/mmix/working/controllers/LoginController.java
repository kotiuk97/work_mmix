package cv.mmix.working.controllers;

import cv.mmix.working.domain.Role;
import cv.mmix.working.domain.Uploader;
import cv.mmix.working.domain.User;
import cv.mmix.working.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
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
public class LoginController {

//    @Autowired
//    private UserService userService;

    @Autowired
    private UserRepo userRepo;

    @Value("${users.images.upload.path}")
    private String imageUploadPath;

    @Value("${cv.upload.path}")
    private String cvUploadPath;

    @GetMapping("/rabota/registration")
    public String registration(){
        return "registration";
    }

    @GetMapping("/rabota/employer/registration")
    public String employerRegistration(){
        return "employer-registration";
    }

    @PostMapping("/rabota/registration")
    public String addUser(
            @RequestParam MultipartFile image,
//            @RequestParam("password2") String passwordConfirmation,
            @Valid User user,
//            BindingResult bindingResult,

            Model model) throws IOException {

//        String URL = String.format(CAPTCHA_URL, recaptchaSecret, captchaResponse);
//        CaptchaResponseDTO captchaResponseDTO = restTemplate.postForObject(URL, Collections.EMPTY_LIST, CaptchaResponseDTO.class);
//        if (!captchaResponseDTO.isSuccess()){
//            model.addAttribute("captchaError", "Fill captcha");
//        }

        if (image != null){
            user.setImageName(Uploader.uploadFile(image, imageUploadPath));

        }
        user.setActive(true);
        user.setRole(Role.USER);
        user.setRegistrationDate(new Date(Calendar.getInstance().getTime().getTime()));
        user.setLastModifiedDate(new Date(Calendar.getInstance().getTime().getTime()));
//        user.setUsername(user.getFirstName());
        userRepo.save(user);
//        userService.addUser(user);
//
//        boolean isConfirmEmpty = Strings.isEmpty(passwordConfirmation);
//        if (isConfirmEmpty){
//            model.addAttribute("password2Error", "Password confirmation cannot be empty");
//        }
//        if (user.getPassword() != null && !user.getPassword().equals(passwordConfirmation)){
//            model.addAttribute("password2Error", "passwords are not equal");
//        }
////        if (isConfirmEmpty || bindingResult.hasErrors() || !captchaResponseDTO.isSuccess()){
//        if (isConfirmEmpty || bindingResult.hasErrors()){
//            Map<String, String> errors = ControllerUtils.getErrors(bindingResult);
//            model.mergeAttributes(errors);
//
//            return "registration";
//        }
//
//        if (!userService.addUser(user)){
//            model.addAttribute("usernameError", "User exists!");
//            return "registration";
//        }
        return "redirect:/login";
    }

    @PostMapping("/rabota/employer/registration")
    public String addEmployer(
            @RequestParam MultipartFile image,
            @RequestParam("password2") String passwordConfirmation,
            @Valid User user,
            BindingResult bindingResult,
            Model model) throws IOException {
//        User usr = userRepo.findByEmail(user.getEmail());
//        if (usr != null){
//            model.addAttribute("message", "User already exists!");
//            return "registration";
//        }
//        user.setRole(Role.EMPLOYER);
//
//        user.setRegistrationDate(new Date());
        if (image != null) {
            user.setImageName(Uploader.uploadFile(image, imageUploadPath));
        }
        user.setActive(true);
        user.setRole(Role.EMPLOYER);
        user.setRegistrationDate(new Date(Calendar.getInstance().getTime().getTime()));
        user.setLastModifiedDate(new Date(Calendar.getInstance().getTime().getTime()));
        userRepo.save(user);

//        boolean isConfirmEmpty = Strings.isEmpty(passwordConfirmation);
//        if (isConfirmEmpty){
//            model.addAttribute("password2Error", "Password confirmation cannot be empty");
//        }
//        if (user.getPassword() != null && !user.getPassword().equals(passwordConfirmation)){
//            model.addAttribute("password2Error", "passwords are not equal");
//        }
////        if (isConfirmEmpty || bindingResult.hasErrors() || !captchaResponseDTO.isSuccess()){
//        if (isConfirmEmpty || bindingResult.hasErrors()){
//            Map<String, String> errors = ControllerUtils.getErrors(bindingResult);
//            model.mergeAttributes(errors);
//
//            return "registration";
//        }
//
//        if (!userService.addUser(user)){
//            model.addAttribute("usernameError", "User exists!");
//            return "registration";
//        }
        return "redirect:/login";
    }

//    @GetMapping("/rabota/login")
//    public String userLogin(){
//        return "login";
//    }


//    @GetMapping("/login")
//    public String userLogin(){
//        return "login";
//    }

//    @PostMapping("/login")
//    public String login(
//            @RequestParam(name = "email", required = true, defaultValue = "") String email,
//            @RequestParam(name = "password", required = true, defaultValue = "") String password,
//            Model model){
//        if (email.isEmpty() || password.isEmpty()){
//            model.addAttribute("message", "all fields are required");
//            model.addAttribute("email", email);
//            return "rabota/login";
//        }
//        User usr = userRepo.findByEmail(email);
//        if (usr == null){
//            model.addAttribute("message", "user doesnt exist");
//            model.addAttribute("email", email);
//            return "redirect:/rabota/login";
//        }
//        if (usr.getPassword().equals(password)){
//            return "redirect:/rabota";
//        }else{
//            model.addAttribute("message", "wrong password");
//            model.addAttribute("email", email);
//            return "rabota/login";
//        }
//    }


//    @GetMapping("/activate/{code}")
//    public String activate(
//            @PathVariable String code,
//            Model model){
//        boolean isActivated = userService.activateUser(code);
//
//        if (isActivated){
//            model.addAttribute("messageType", "success");
//            model.addAttribute("message", "activated successfull");
//        }else{
//            model.addAttribute("messageType", "danger");
//            model.addAttribute("message", "activation code is not found");
//        }
//
//        return "registration";
//
//    }
}
