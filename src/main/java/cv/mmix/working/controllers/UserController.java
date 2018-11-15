package cv.mmix.working.controllers;

import cv.mmix.working.domain.Role;
import cv.mmix.working.domain.User;
import cv.mmix.working.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
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
//@RequestMapping("/rabota/admin")
//@PreAuthorize("hasAuthority('ADMIN')")
public class UserController {
    @Autowired
    private UserRepo userRepo;

    @Value("${users.images.upload.path}")
    private String uploadPath;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/rabota/userList")
    public String userList(
            Model model){
        List<User> all = userRepo.findAll();
        List<User> users = new LinkedList<>();
        List<User> employers = new LinkedList<>();
        for (User user : all){
            if (user.getRole().equals(Role.USER)){
                users.add(user);
                continue;
            }
            if (user.getRole().equals(Role.EMPLOYER)){
                employers.add(user);
            }
        }

        model.addAttribute("users", users);
        model.addAttribute("employers", employers);
        return "userList";
    }

    @GetMapping("/rabota/user/{user}")
    public String userEdit(
            @PathVariable User user,
            Model model
    ){
        model.addAttribute("user", user);
        return "userEdit";
    }

    @GetMapping("/rabota/employer/{user}")
    public String employerEdit(
            @PathVariable User user,
            Model model
    ){
        model.addAttribute("user", user);
        return "userEdit";
    }


    @GetMapping("/rabota/user/editUser")
    public String getEditUser(
            @AuthenticationPrincipal User user,
            Model model){
        model.addAttribute("user", user);
        return "userEdit";
    }

    @GetMapping("/rabota/user/editEmployer")
    public String getEditEmployer(
            @AuthenticationPrincipal User user,
            Model model){
        model.addAttribute("user", user);
        return "editEmployer";
    }


    @PostMapping("/rabota/user/editUser")
    public String updateUser(
//            @Valid User user,
            @RequestParam Long id,
            @RequestParam (defaultValue = "") String firstName,
            @RequestParam (defaultValue = "") String lastName,
            @RequestParam (defaultValue = "") String email,
            @RequestParam (defaultValue = "") String phoneNumber,
            @RequestParam (defaultValue = "") String password,
            @RequestParam (defaultValue = "") String password2,
            @RequestParam MultipartFile image,
            Model model
    ) throws IOException {
        User user = userRepo.findById(id).get();
        if (!firstName.isEmpty()){
            user.setFirstName(firstName);
        }
        if (!lastName.isEmpty()){
            user.setLastName(lastName);
        }
        if (!email.isEmpty()){
            user.setEmail(email);
        }
        if (!phoneNumber.isEmpty()){
            user.setPhoneNumber(phoneNumber);
        }
        if (!password.isEmpty()){
            if (password.equals(password2)){
                user.setPassword(password);
            }else{
                return "userEdit";
            }
        }
        if (image != null){
            user.setImageName(uploadImage(image));
        }
        user.setLastModifiedDate(new Date(Calendar.getInstance().getTime().getTime()));
        userRepo.save(user);

        return "redirect:/rabota";
    }

    @PostMapping("/rabota/user/editEmployer")
    public String updateEmployer(
            @RequestParam Long id,
            @RequestParam (defaultValue = "") String companyName,
            @RequestParam (defaultValue = "") String email,
            @RequestParam (defaultValue = "") String phoneNumber,
            @RequestParam (defaultValue = "") String password,
            @RequestParam (defaultValue = "") String password2,
            @RequestParam MultipartFile image,
//            @Valid User user,
            Model model
    ) throws IOException {
        User employer = userRepo.findById(id).get();
        if (!companyName.isEmpty()){
            employer.setCompanyName(companyName);
        }
        if (!email.isEmpty()){
            employer.setEmail(email);
        }
        if (!phoneNumber.isEmpty()){
            employer.setPhoneNumber(phoneNumber);
        }
        if (!password.isEmpty()){
            if (password.equals(password2)){
                employer.setPassword(password);
            }else{
                return "editEmployer";
            }
        }
        if (image != null){
            employer.setImageName(uploadImage(image));
        }
        employer.setLastModifiedDate(new Date(Calendar.getInstance().getTime().getTime()));
        userRepo.save(employer);

        return "redirect:/rabota/";
    }

    /**
     * Returns image name
     * @param image
     * @return
     */
    private String uploadImage(MultipartFile image) throws IOException {
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()){
            uploadDir.mkdirs();
        }
        String uuidFile = UUID.randomUUID().toString();
        String fileName = uuidFile + "." + image.getOriginalFilename();
        image.transferTo(new File(uploadPath + "/" + fileName));
        return fileName;
    }


 /*   @PreAuthorize("hasAuthority('ADMIN')")      //only admin has access to here
    @PostMapping
    public String userSave(
            @RequestParam String username,
            @RequestParam Map<String, String> form,
            @RequestParam(name = "userId") User user,
            Model model
    ){

        userService.saveUser(user,username, form);

        return "redirect:/user";
    }

    @GetMapping("/profile")
    public String getProfile(
            Model model,
            @AuthenticationPrincipal User user){
        model.addAttribute("username", user.getUsername());
        model.addAttribute("email", user.getEmail());
        return "profile";
    }

    @PostMapping("/profile")
    public String updateProfile(
            @AuthenticationPrincipal User user,
            @RequestParam String password,
            @RequestParam String email
    ){
        userService.updateProfile(user, password, email);
        return "redirect:/user/profile";
    }
*/
 }
