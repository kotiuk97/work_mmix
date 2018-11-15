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
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Controller
//@RequestMapping("/rabota/admin")
//@PreAuthorize("hasAuthority('ADMIN')")
public class UserController {
    @Autowired
    private UserRepo userRepo;

    @Value("${upload.path}")
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
    public String editUser(
            @Valid User user,
            @RequestParam MultipartFile image,
            Model model
    ) throws IOException {
        if (image != null) {
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()){
                uploadDir.mkdirs();
            }
            String uuidFile = UUID.randomUUID().toString();
            String fileName = uuidFile + "." + image.getOriginalFilename();
            image.transferTo(new File(uploadPath + "/" + fileName));
            user.setImageName(fileName);

        }
        userRepo.save(user);

        return "redirect:/rabota/main";
    }

    @PostMapping("/rabota/user/editEmployer")
    public String editEmployer(
            @RequestParam MultipartFile image,
            @Valid User user,
            Model model
    ) throws IOException {
        if (image != null) {
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()){
                uploadDir.mkdirs();
            }
            String uuidFile = UUID.randomUUID().toString();
            String fileName = uuidFile + "." + image.getOriginalFilename();
            image.transferTo(new File(uploadPath + "/" + fileName));
            user.setImageName(fileName);

        }
        userRepo.save(user);

        return "redirect:/rabota/main";
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
