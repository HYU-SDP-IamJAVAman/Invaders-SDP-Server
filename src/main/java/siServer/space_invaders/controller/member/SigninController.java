package siServer.space_invaders.controller.member;


import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import siServer.space_invaders.dto.MemberResponse;
import siServer.space_invaders.model.Member;
import siServer.space_invaders.service.MemberService;
import java.security.Principal;
import java.util.Optional;


@Controller
@RequiredArgsConstructor
public class SigninController {
    private final MemberService memberService;

    @PostMapping("/user/login")
    public ResponseEntity<MemberResponse> signin(@RequestBody String memberSigninRequest){

        String[] request = memberSigninRequest.split(",");
        String username = request[0];
        String password = request[1];
        Member member = memberService.login(username, password);
        MemberResponse response = new MemberResponse(member.getNickname());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
