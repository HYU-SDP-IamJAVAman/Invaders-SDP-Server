package siServer.space_invaders.controller.member;



import jakarta.servlet.http.HttpServletRequest;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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

    public String signin(Model model, Principal principal, HttpServletRequest request){

        String username = principal.getName();
        String nickname = memberService.getNicknameByUsername(username);
        String userEmail = SecurityContextHolder.getContext().getAuthentication().getName();
        String sessionId = request.getSession().getId();
        model.addAttribute("nickname", nickname);
        model.addAttribute("userEmail", userEmail);
        model.addAttribute("sessionId", sessionId);


       return "userPage";
    }
}
