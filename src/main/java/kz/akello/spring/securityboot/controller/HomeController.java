package kz.akello.spring.securityboot.controller;

import kz.akello.spring.securityboot.model.User;
import kz.akello.spring.securityboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/")
    public String indexPage(){
        return "index";
    }

    @GetMapping(value = "/sign-in-page")
    public String signInPage(){
        return "signIn";
    }

    @GetMapping(value = "/update-password-page")
    public String updatePasswordPage(){
        return "updatePassword";
    }

    @GetMapping(value = "/sign-up-page")
    public String signUpPage(){
        return "signUp";
    }

    @PostMapping(value = "/to-sign-up")
    public String toSignUp(@RequestParam("user_full_name") String fullName,
                           @RequestParam("user_email") String email,
                           @RequestParam("user_password") String password,
                           @RequestParam("user_repeat_password") String rePassword){
        if(password.equals(rePassword)) {
            User user = new User();
            user.setFullName(fullName);
            user.setEmail(email);
            user.setPassword(password);
            User newUser = userService.addUser(user);
            if(newUser != null){
                return "redirect:/sign-up-page?success";
            }else {
                return "redirect:/sign-up-page?emailerror";
            }
        }else {
            return "redirect:/sign-up-page?passworderror";
        }

    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping(value = "/profile")
    public String profilePage(){
        return "profile";
    }

    @GetMapping(value = "/403-page")
    public String accessDeniedPage(){
        return "403";
    }

    @PostMapping(value = "/to-update-password")
    public String toSignUp(
                            @RequestParam("user_old_password") String oldPassword,
                           @RequestParam("user_new_password") String newPassword,
                           @RequestParam("user_repeat_new_password") String rePassword){
        if(newPassword.equals(rePassword)) {
            User user = userService.updatePassword(newPassword, oldPassword);
            if(user!=null){
                return "redirect:/update-password-page?success";
            }else {
                return "redirect:/update-password-page?oldpassworderror";
            }
        }else {
            return "redirect:/update-password-page?passwordmismatch";
        }

    }

}
