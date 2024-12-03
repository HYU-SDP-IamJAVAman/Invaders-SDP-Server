package siServer.space_invaders.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
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
        String username = "asdf@example.com";
        String password = "1234";
        mockMember.signUp(nickname, username, password);
        when(memberRepository.findById(1)).thenReturn(Optional.of(mockMember));

        Member result = memberService.getUserById(1);

        assertEquals("John", result.getNickname());
        assertEquals("asdf@example.com", result.getUsername());
        verify(memberRepository, times(1)).findById(1);
    }

    @Test
    void join() {
        Member mockMember = new Member();
        String nickname = "John";
        String username = "asdf@example.com";
        String password = "1234";
        mockMember.signUp(nickname, username, password);

        memberService.join(mockMember);

        verify(memberRepository, times(1)).save(mockMember);


    }

    @Test
    void getNicknameByUsername() {
        Member mockMember = new Member();
        String nickname = "John";
        String username = "asdf@example.com";
        String password = "1234";
        mockMember.signUp(nickname, username, password);
        when(memberRepository.findByUsername(username)).thenReturn(Optional.of(mockMember));

        String mockMemberNickname = memberService.getNicknameByUsername(username);

        assertEquals(mockMemberNickname, nickname);
    }

    @Test
    void updateUserState(){
        String nickname = "testUser";
        int score = 100;
        int currentCoin = 50;

        Member existingMember = Mockito.mock(Member.class);
        when(existingMember.getHighestScore()).thenReturn(80);
        when(memberRepository.findByNickname(nickname)).thenReturn(Optional.of(existingMember));

        memberService.updateUserState(nickname, score, currentCoin);

        verify(existingMember).update(currentCoin, score);
        verify(memberRepository, times(1)).findByNickname(nickname);
    }
}