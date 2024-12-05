package siServer.space_invaders.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import siServer.space_invaders.dto.MemberResponse;
import siServer.space_invaders.service.MemberService;

@Controller
@RequiredArgsConstructor
public class RecordController {

    private final MemberService memberService;

    @PostMapping("/userstate")
    public ResponseEntity<MemberResponse> getMemberRecord(@RequestBody String requestBody){
        String[] memberState = requestBody.split(",");
        memberService.updateUserState(memberState[0],
                Integer.parseInt(memberState[1]), Integer.parseInt(memberState[2]));

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
