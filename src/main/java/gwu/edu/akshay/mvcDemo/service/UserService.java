package gwu.edu.akshay.mvcDemo.service;

import gwu.edu.akshay.mvcDemo.Entity.User;
import gwu.edu.akshay.mvcDemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

    //read
    public List<User> getAllUsers(){
        List<User> result = (List<User>) repository.findAll();
        return result.size()>0? result:new ArrayList<>();
    }
    //findByID
    public User getUserById(Long id) throws Exception {
        Optional<User> user = repository.findById(id);
        if(user.isPresent())
            return user.get();
        else
            throw new Exception();
    }
    //post and update
   public User createOrUpdate(User entity){
        if(entity==null){
            entity = repository.save(entity);
            return entity;
        }
        else {
            Optional<User> user = repository.findById(entity.getId());
            if(user.isPresent()){
                User u = user.get();
                u.setFirstName(entity.getFirstName());
                u.setLastName(entity.getLastName());
                u.setEmailAddress(entity.getEmailAddress());
                u.setFeedback(entity.getFeedback());
                u = repository.save(u);
                return u;
            }else{
                    entity= repository.save(entity);
                    return entity;
            }
        }
    }
    //delete
    public void deleteUserById(Long id) throws Exception{
        Optional<User> user = repository.findById(id);
        if(user.isPresent()){
            repository.deleteById(id);
        }else {
            throw new Exception("No record Found");
        }
    }
}
