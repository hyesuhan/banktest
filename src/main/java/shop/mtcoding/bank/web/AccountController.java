package shop.mtcoding.bank.web;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import shop.mtcoding.bank.config.auth.LoginUser;
import shop.mtcoding.bank.dto.ResponseDTO;
import shop.mtcoding.bank.dto.account.AccountReqDto;
import shop.mtcoding.bank.dto.account.AccountResDto;
import shop.mtcoding.bank.service.AccountService;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class AccountController {

    private final AccountService accountService;

    @PostMapping("/s/account")
    public ResponseEntity<?> saveAccount(
            @RequestBody @Valid AccountReqDto.AccountSaveReqDto accountSaveReqDto,
            BindingResult bindingResult, @AuthenticationPrincipal LoginUser loginUser) {
        AccountResDto.AccountSaveResDto accountSaveResDto = accountService.계좌등록(accountSaveReqDto, loginUser.getUser().getId());
        return new ResponseEntity<>(new ResponseDTO<>(1, "계좌등록", accountSaveResDto), HttpStatus.CREATED);
    }

    // 인증이 필요하고, account 테이블에 1번 row를 주세요
    // cos로 로그인을 했^는데, cos의 id가 2번이에요!
    // 권한 처리 때문에 선호 x
    // 인증이 필요하고, account table data 다 주세요
    // 인증이 피요하고, account 테이블에 login 한 유저의 계좌만 주세요
    @GetMapping("/s/account/{id}")
    public ResponseEntity<?> findUserAccount(@AuthenticationPrincipal LoginUser loginUser) {

        AccountService.AccountListRespDto accountListRespDto = accountService.계좌목록보기_유저별(loginUser.getUser().getId());
        return new ResponseEntity<>(new ResponseDTO<>(1,"계좌목록 보기_유형별 성공", accountListRespDto), HttpStatus.OK);
    }
}
