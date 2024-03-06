package me.yonghwan.springbootdeveloper.service;

import lombok.RequiredArgsConstructor;
import me.yonghwan.springbootdeveloper.domain.User;
import me.yonghwan.springbootdeveloper.dto.AddUserRequest;
import me.yonghwan.springbootdeveloper.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    /**
     *
     @작성자 : admin
     @작성일 : 2024 02 23 오전 10:52
     @변경이력 :  유저 저장 ( 회원가입 )
      * @return
     */
    public Long save(AddUserRequest dto){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return userRepository.save(User.builder()
                .email(dto.getEmail())
                .password(bCryptPasswordEncoder.encode(dto.getPassword()))
                .build()).getId();
    }

    /**
     *
     @작성자 : admin
     @작성일 : 2024 02 23 오전 10:51
     @변경이력 :  userId로 user 조회
      * @return
     */
    public User findById(Long userId){
        return userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("Unexpected user"));
    }
    public User findByEmail(String email){
        return userRepository.findByEmail(email)
                .orElseThrow(()-> new IllegalArgumentException("Unexpected user"));
    }

}
