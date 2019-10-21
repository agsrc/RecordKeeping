package gwu.edu.akshay.mvcDemo.controller;

import gwu.edu.akshay.mvcDemo.Entity.User;
import gwu.edu.akshay.mvcDemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

public class ForwardController {
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

    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public ModelAndView saveUser(@ModelAttribute User user ){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("user-post-report");
        mv.addObject("user",user);
        return mv;
    }
    @RequestMapping(value = "/addUser")
    public String add(Model model){
        return "saveUser";
//        ModelAndView mv = new ModelAndView();
//        mv.setViewName("user-data");
//        mv.addObject("user",user);
//        return mv;
    }
}
