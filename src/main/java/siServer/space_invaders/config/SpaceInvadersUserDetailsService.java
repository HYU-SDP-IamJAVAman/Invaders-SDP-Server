package siServer.space_invaders.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import siServer.space_invaders.model.Member;
import siServer.space_invaders.repositiry.MemberRepository;

import java.util.ArrayList;

@Slf4j
@Service
@RequiredArgsConstructor
public class SpaceInvadersUserDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member member = memberRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + username));


        return new User(
                member.getEmail(),
                member.getPassword(),
                new ArrayList<>()
        );
    }
}
