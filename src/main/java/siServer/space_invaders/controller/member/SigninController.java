package siServer.space_invaders.controller.member;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import siServer.space_invaders.service.MemberService;
import java.security.Principal;


@Controller
@RequiredArgsConstructor
public class SigninController {
    private final MemberService memberService;

    @GetMapping("/userPage")
    public String signin(Model model, Principal principal){

        String username = principal.getName();
        String nickname = memberService.getNicknameByUsername(username);
        model.addAttribute("nickname", nickname);

       return "userPage";
    }
}
