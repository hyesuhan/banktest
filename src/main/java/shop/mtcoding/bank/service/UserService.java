package shop.mtcoding.bank.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import shop.mtcoding.bank.domain.user.User;
import shop.mtcoding.bank.domain.user.UserEnum;
import shop.mtcoding.bank.domain.user.UserRepository;
import shop.mtcoding.bank.dto.user.UserReqDto;
import shop.mtcoding.bank.dto.user.UserRespDto;
import shop.mtcoding.bank.handler.ex.CustomApiException;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final Logger log = LoggerFactory.getLogger(getClass());
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    // 서비스는 DTO를 요청받고, DTO로 응답한다.
    @Transactional //트랜잭션이 메서드 시작할 때 시작되고, 종료될 때 함께 종료
    public UserRespDto.JoinRespDto 회원가입(UserReqDto.JoinReqDto joinReqDto) {
        // 1. 동일 유저 네임 존재 검사
        Optional<User> userOP =  userRepository.findByUsername(joinReqDto.getUsername());
        if(userOP.isPresent()) {
            // 유저 네임 중복되었다는 뜻
            throw new CustomApiException("동일한 username이 존재합니다.");
        }
        // 2. 패스워드 인코딩 + 회원가입
        User userPS = userRepository.save((joinReqDto.toEntity(passwordEncoder)));

        // 3. dto 응답
        return new UserRespDto.JoinRespDto(userPS);

    }



}
