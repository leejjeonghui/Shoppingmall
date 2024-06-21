package springpractice.shoppingmall.Service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import springpractice.shoppingmall.DTO.SaveUserRequestDto;
import springpractice.shoppingmall.Entity.User;
import springpractice.shoppingmall.Repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseEntity<String> saveUser(SaveUserRequestDto dto){
        User user = new User(dto.name(),dto.zipCode(),dto.address(), dto.detailAddress());
        userRepository.save(user);
        return ResponseEntity.ok("유저생성완료"+user.getId());
    }
}
