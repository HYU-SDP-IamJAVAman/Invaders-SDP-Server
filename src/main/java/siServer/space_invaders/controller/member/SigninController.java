package siServer.space_invaders.controller.member;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import siServer.space_invaders.dto.SigninForm;
import siServer.space_invaders.model.Member;
import siServer.space_invaders.service.MemberService;

@Controller
@RequiredArgsConstructor
public class SigninController {
    private final MemberService memberService;

    @PostMapping("/user/signin")
    public String signIn(@Validated @ModelAttribute SigninForm signInForm, BindingResult bindingResult,
                         HttpServletRequest request) {
        if (bindingResult.hasErrors()) {
            return "signin";
        }
        return "/";
    }
}
