package springpractice.shoppingmall.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springpractice.shoppingmall.DTO.SaveUserRequestDto;
import springpractice.shoppingmall.Repository.UserRepository;
import springpractice.shoppingmall.Service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {


    private final UserService userService;

    public UserController( UserService userService) {
        this.userService = userService;
    }

   @PostMapping("/")
    ResponseEntity<String> createUser (@RequestBody SaveUserRequestDto userdto){
        return userService.saveUser(userdto);
   }


}
