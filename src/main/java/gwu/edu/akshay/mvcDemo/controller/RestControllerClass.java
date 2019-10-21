package gwu.edu.akshay.mvcDemo.controller;

import gwu.edu.akshay.mvcDemo.Entity.User;
import gwu.edu.akshay.mvcDemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class RestControllerClass {
    @Autowired
    UserService service;
    //GET
    @GetMapping("/")
    public List<User> getAllUser(Model model){
        List<User> ls = service.getAllUsers();
        return ls;
    }
    //POST
    @PostMapping(path = "/createUser")
    public User createOrUpdate(@Valid @RequestBody User user){
        service.createOrUpdate(user);
        return user;
    }
    //PUT
    @PutMapping(path = {"edit","/edit/{id}"})
    public User getUserById(@PathVariable("id") Optional<Long> idop) throws Exception {
        if(idop.isPresent()) {
            User user = service.getUserById(idop.get());
            return user;
        }
        else{
          return  new User();
        }
    }
    //DELETE
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) throws Exception {
        service.deleteUserById(id);
        return ResponseEntity.ok().build();
    }
}
