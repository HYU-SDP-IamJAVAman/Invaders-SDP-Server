package siServer.space_invaders.controller.member;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import siServer.space_invaders.dto.SignupForm;
import siServer.space_invaders.model.Member;
import siServer.space_invaders.service.MemberService;


@Controller
@RequiredArgsConstructor
public class SignupController {
    private final PasswordEncoder passwordEncoder;
    private final MemberService memberService;
    @GetMapping("/user/signup")
    public String signup(Model model) {
        model.addAttribute("signupForm", new SignupForm());
        return "signup";
    }

    @PostMapping("/user/signup")
    public String signUp( @Validated @ModelAttribute SignupForm signupForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "signup";
        }

        if (!signupForm.getConfirmPassword().equals(signupForm.getPassword())) {
            bindingResult.rejectValue("confirmPassword", "unmatchedPassword");
            return "signup";
        }
        String hashPwd = passwordEncoder.encode(signupForm.getPassword());
        signupForm.setPassword(hashPwd);
        Member member = new Member();
        member.signUp(signupForm.getNickname(), signupForm.getEmail(), hashPwd);
        try {
            memberService.join(member);
        } catch (IllegalStateException e) {
            bindingResult.reject("alreadyExistMember");
            return "signup";
        }

        return "index";
    }

}
