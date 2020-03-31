package ir.maktab.final_exam_app.crudrepositories.usercrud;

import ir.maktab.final_exam_app.crudrepositories.rolecrud.RoleService;
import ir.maktab.final_exam_app.models.Role;
import ir.maktab.final_exam_app.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;

    @GetMapping("/login")
    public String sendLoginForm(Model model){
        model.addAttribute("user", new User());
        return "loginPage";
    }
    @PostMapping("/login")
    public String login(@ModelAttribute User user){
        boolean isUsernameExist = userService.isUserExist(user.getUsername());
        boolean isPasswordValid = userService.isPasswordValid(user.getPassword());
        if(isUsernameExist&&isPasswordValid){
            User loggedInUser = userService.findUserByUsername(user.getUsername());
            Role role = loggedInUser.getRole();
            if(role.getTitle().equalsIgnoreCase("ADMIN")){
                return "adminWelcomePage";
            }else
                return "loginSuccessfulPage";
        }else
            return "errorInLoginPage";
    }

    @GetMapping("/signUp")
    public String sendSignUpForm(Model model){
        model.addAttribute("user", new User());
        List<Role> roles = new ArrayList<>();
        roles.add(roleService.findRoleById(2L));
        roles.add(roleService.findRoleById(3L));
        model.addAttribute("roles",roles);
        return "signUpPage";
    }

    @PostMapping("/signUp")
    public String signUp(@ModelAttribute User user){
        boolean isUserExist = userService.isUserExist(user.getUsername());
        if(isUserExist)
            return "signUpError";
        user.setActive(true);
        user.setStatus("Waiting to confirm");
        userService.saveUser(user);
        return "signUpSuccessful";
    }
}
