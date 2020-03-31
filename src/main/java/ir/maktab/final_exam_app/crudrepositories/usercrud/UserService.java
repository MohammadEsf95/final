package ir.maktab.final_exam_app.crudrepositories.usercrud;

import ir.maktab.final_exam_app.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
  @Autowired
  private UserRepository userRepository;

  public boolean isUserExist(String username){
      Optional<User> user = userRepository.findByUsername(username);
      if(user.isPresent())
          return true;
      return false;
  }

  public User saveUser(User user){
      return userRepository.save(user);
  }
  public boolean isPasswordValid(String password){
      return userRepository.findUserByPassword(password).size()>0;
  }
  public User findUserByUsername(String username){return userRepository.findByUsername(username).get();};
}
