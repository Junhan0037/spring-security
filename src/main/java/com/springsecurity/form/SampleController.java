package com.springsecurity.form;

import com.springsecurity.account.Account;
import com.springsecurity.account.AccountContext;
import com.springsecurity.account.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class SampleController {

    private final SampleService sampleService;
    private final AccountRepository accountRepository;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("message", "Hello Spring Security");
        return "index";
    }

    @GetMapping("/info") // 아무나 접근 가능
    public String info(Model model) {
        model.addAttribute("message", "Info");
        return "info";
    }

    @GetMapping("/dashboard") // 로그인 한 사용자만 접근 가능
    public String dashboard(Model model, Principal principal) {
        if (principal == null) {
            model.addAttribute("message", "Hello Spring Security");
        } else {
            model.addAttribute("message", "Hello " + principal.getName());
        }
        sampleService.dashboard();
        return "dashboard";
    }

    @GetMapping("/admin") // admin 권한자만 접근 가능
    public String admin(Model model, Principal principal) {
        model.addAttribute("message", "Hello Admin, " + principal.getName());
        return "admin";
    }

}
