package siServer.space_invaders.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import siServer.space_invaders.model.Member;
import siServer.space_invaders.repositiry.MemberRepository;

import java.util.Optional;


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
        if(memberRepository.findByUsername(member.getUsername()).isPresent()){
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }

        memberRepository.save(member);
    }

    public String getNicknameByUsername(String username){
        return memberRepository.findByUsername(username)
                .map(Member::getNickname)
                .orElse("사용자가 없습니다");
    }

    public Integer getCoinByUsername(String  username){
        return memberRepository.findByUsername(username)
                .map(Member::getCoin)
                .orElse(null);
    }

    public Integer getScoreByUsername(String username){
        return memberRepository.findByUsername(username)
                .map(Member::getHighestScore)
                .orElse(null);
    }

    public Member login(String username, String password){

        Optional<Member> optionalMember = memberRepository.findByUsername(username);

        if (optionalMember.isPresent()){
            Member member  = optionalMember.get();
            if(password.equals(member.getPassword()) ){
                return   member;
            }

        }
        return null;
    }

    @Transactional
    public void updateUserState(String nickname, int score, int currentCoin) {
        Optional<Member> optionalMember = memberRepository.findByNickname(nickname);

        if (optionalMember.isPresent()) {
            Member member = optionalMember.get();
            if (member.getHighestScore() < score){
                member.update(currentCoin, score);
            }else{
                member.update(currentCoin, member.getHighestScore());
            }
        }
    }


}
