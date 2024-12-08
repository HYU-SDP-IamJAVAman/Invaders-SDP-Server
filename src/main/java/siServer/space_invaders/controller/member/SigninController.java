package siServer.space_invaders.controller.member;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import siServer.space_invaders.dto.LoginResponse;
import siServer.space_invaders.model.Member;
import siServer.space_invaders.service.MemberService;


@Controller
@RequiredArgsConstructor
public class SigninController {
    private final MemberService memberService;

    @PostMapping("/user/login")
    public ResponseEntity<LoginResponse> signin(@RequestBody String memberSigninRequest){

        String[] request = memberSigninRequest.split(",");
        String username = request[0];
        String password = request[1];
        Member member = memberService.login(username, password);
        LoginResponse response = new LoginResponse(member.getNickname(), member.getCoin(),member.getTotalPlay(), member.getTotalScore(), member.getMaxCombo(), member.getCurrentPerfectStage(), member.getFlawlessFailure());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
