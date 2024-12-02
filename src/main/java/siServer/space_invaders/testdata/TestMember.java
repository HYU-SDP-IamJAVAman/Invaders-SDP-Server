package siServer.space_invaders.testdata;


import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import siServer.space_invaders.model.Member;
import siServer.space_invaders.service.MemberService;

//@Component
//@RequiredArgsConstructor
//public class TestMember {
//    private final MemberService memberService;
////    private final PasswordEncoder passwordEncoder;
//
//    @PostConstruct
//    public void initMember(){
//        Member member = new Member();
//  //      String hashPwd = passwordEncoder.encode("12345");
//        member.signUp("test1", "12345@example.com", "12345");
//        memberService.join(member);
//    }
//
//}
