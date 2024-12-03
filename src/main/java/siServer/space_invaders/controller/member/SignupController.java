package siServer.space_invaders.controller.member;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import siServer.space_invaders.dto.MemberResponse;
import siServer.space_invaders.model.Member;
import siServer.space_invaders.service.MemberService;


@Controller
@RequiredArgsConstructor
public class SignupController {

    private final MemberService memberService;

    @PostMapping("/user/signup")
    public ResponseEntity<MemberResponse> signUp(@RequestBody String memberRegisterRequest) {
        String[] memberRegisterInformation = memberRegisterRequest.split(",");

        Member member = new Member();
        member.signUp(memberRegisterInformation[0],  memberRegisterInformation[1], memberRegisterInformation[2]);
        memberService.join(member);

        MemberResponse response = new MemberResponse(memberRegisterInformation[0]);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
