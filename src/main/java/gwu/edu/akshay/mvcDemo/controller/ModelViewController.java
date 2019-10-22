package gwu.edu.akshay.mvcDemo.controller;
import gwu.edu.akshay.mvcDemo.Entity.User;
import gwu.edu.akshay.mvcDemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ModelViewController {
    @Autowired
    UserService service;

    @RequestMapping(value = "/index")
    public String index(){
        return "index";
    }
    @RequestMapping(value ="/displayUser")
    public String getAllUser(Model model){
        List<User> userList = service.getAllUsers();
        model.addAttribute("users",userList);
        return "displayUser";
    }
    @RequestMapping(value = "/addUser")
    public String add(){
        return ("saveUser");
    }
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute User user ){
        ModelAndView mv = new ModelAndView();
        mv.addObject("user",user);
        service.createOrUpdate(user);
        mv.setViewName("savedUserDetails");
        return mv;
    }
}
