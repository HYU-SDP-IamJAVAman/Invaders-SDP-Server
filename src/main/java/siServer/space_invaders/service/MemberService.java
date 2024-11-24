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
}
