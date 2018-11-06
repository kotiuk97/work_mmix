package cv.mmix.working.controllers;

import cv.mmix.working.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
//@RequestMapping("/rabota/admin")

public class UserController {
    @Autowired
    private UserRepo userRepo;

//    @GetMapping(name = "/rabota/admin/userList")
//    public String userList(
//            Model model){
//        model.addAttribute("users", userRepo.findAll());
//        return "userList";
//    }
/*
    @GetMapping("{user}")
    public String userEdit(
            @PathVariable User user,
            Model model
    ){
        model.addAttribute("user", user);
        model.addAttribute("roles", Role.values());
        return "userEdit";
    }

    @PreAuthorize("hasAuthority('ADMIN')")      //only admin has access to here
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
