package gwu.edu.akshay.mvcDemo.controller;

import gwu.edu.akshay.mvcDemo.Entity.User;
import gwu.edu.akshay.mvcDemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
import java.util.Optional;

@Controller
public class UserController {
    @Autowired
    UserService service;

     @RequestMapping(path = "/createUser", method = RequestMethod.POST)
    public String createOrUpdate(User user){
        service.createOrUpdate(user);
                return "/userDisplay";
    }
    @RequestMapping(value = {"/edit","/edit/{id}"})
    public String getUserById(Model model, @PathVariable("id")Optional<Long> idop) throws Exception {
        if(idop.isPresent()) {
            User user = service.getUserById(idop.get());
            model.addAttribute("user",user);
        }
        else{
            model.addAttribute("user",new User());
        }
        return "add-edit";
    }
    @RequestMapping("/delete/{id")
    public String deleteById(@PathVariable Long id) throws Exception {
        service.deleteUserById(id);
        return "add-edit";
    }


}
