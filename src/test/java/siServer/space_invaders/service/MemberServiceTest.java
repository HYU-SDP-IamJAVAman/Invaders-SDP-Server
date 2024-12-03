package siServer.space_invaders.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import siServer.space_invaders.model.Member;
import siServer.space_invaders.repositiry.MemberRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MemberServiceTest {

    @Mock
    private MemberRepository memberRepository;

    @Spy
    @InjectMocks
    private MemberService memberService;


    @Test
    void getUserById() {
        Member mockMember = new Member();
        String nickname = "John";
        String email = "asdf@example.com";
        String password = "1234";
        mockMember.signUp(nickname, email, password);
        when(memberRepository.findById(1)).thenReturn(Optional.of(mockMember));

        Member result = memberService.getUserById(1);

        assertEquals("John", result.getNickname());
        assertEquals("asdf@example.com", result.getEmail());
        verify(memberRepository, times(1)).findById(1);
    }

    @Test
    void join() {
        Member mockMember = new Member();
        String nickname = "John";
        String email = "asdf@example.com";
        String password = "1234";
        mockMember.signUp(nickname, email, password);

        memberService.join(mockMember);

        verify(memberRepository, times(1)).save(mockMember);


    }

    @Test
    void getNicknameByUsername() {
        Member mockMember = new Member();
        String nickname = "John";
        String email = "asdf@example.com";
        String password = "1234";
        mockMember.signUp(nickname, email, password);
        when(memberRepository.findByEmail(email)).thenReturn(Optional.of(mockMember));

        String mockMemberNickname = memberService.getNicknameByUsername(email);

        assertEquals(mockMemberNickname, nickname);
    }
}