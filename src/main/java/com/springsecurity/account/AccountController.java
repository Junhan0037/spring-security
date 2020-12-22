package com.springsecurity.account;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @GetMapping("/account/{role}/{username}/{password}") // 임시 회원가입 컨트롤러
    public Account createAccount(@ModelAttribute Account account) {
        return accountService.createNew(account);
    }

}
