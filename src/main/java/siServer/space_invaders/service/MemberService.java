package siServer.space_invaders.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import siServer.space_invaders.model.Member;
import siServer.space_invaders.repositiry.MemberRepository;


@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

     private final MemberRepository memberRepository;
    public Member getUserById(int id) {
        return memberRepository.findById(id).orElse(null);
    }

    @Transactional
    public void join(Member member) {
        if(memberRepository.findById(member.getId()).isPresent()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
        if(memberRepository.findByEmail(member.getEmail()).isPresent()){
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }

        memberRepository.save(member);
    }

    public String getNicknameByUsername(String username){
        return memberRepository.findByEmail(username)
                .map(Member::getNickname)
                .orElse("사용자가 없습니다");
    }
}
