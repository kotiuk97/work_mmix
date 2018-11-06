package cv.mmix.working.controllers;

import cv.mmix.working.domain.Role;
import cv.mmix.working.domain.User;
import cv.mmix.working.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.sql.Date;
import java.util.Calendar;

@Controller
public class LoginController {

//    @Autowired
//    private UserService userService;

    @Autowired
    private UserRepo userRepo;

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
//            @RequestParam("password2") String passwordConfirmation,
            @Valid User user,
//            BindingResult bindingResult,

            Model model){

//        String URL = String.format(CAPTCHA_URL, recaptchaSecret, captchaResponse);
//        CaptchaResponseDTO captchaResponseDTO = restTemplate.postForObject(URL, Collections.EMPTY_LIST, CaptchaResponseDTO.class);
//        if (!captchaResponseDTO.isSuccess()){
//            model.addAttribute("captchaError", "Fill captcha");
//        }

//        User user = new User("ser", "kot", "1212", "mail", "pass", Role.ADM, "asd", true, false);
//        User usr = userRepo.findByEmail(user.getEmail());
//        if (usr != null){
//            model.addAttribute("message", "User already exists!");
//            return "registration";
//        }
//        user.setRole(Role.USER);
        user.setActive(true);
        user.setRole(Role.USER);
        user.setRegistrationDate(new Date(Calendar.getInstance().getTime().getTime()));
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
            @RequestParam("password2") String passwordConfirmation,
            @Valid User user,
            BindingResult bindingResult,
            Model model){
//        User usr = userRepo.findByEmail(user.getEmail());
//        if (usr != null){
//            model.addAttribute("message", "User already exists!");
//            return "registration";
//        }
//        user.setRole(Role.EMPLOYER);
//
//        user.setRegistrationDate(new Date());
        user.setActive(true);
        user.setRole(Role.EMPLOYER);
        user.setRegistrationDate(new Date(Calendar.getInstance().getTime().getTime()));
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

    @GetMapping("/rabota/employer/login")
    public String employersLogin(){
        return "employer-login";
    }

    @GetMapping("/rabota/admin/userList")
    public String userList(
            Model model){
        model.addAttribute("users", userRepo.findAll());
        return "userList";
    }

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
