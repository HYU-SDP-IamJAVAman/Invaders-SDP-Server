package siServer.space_invaders.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import siServer.space_invaders.dto.UserDto;
import siServer.space_invaders.service.MemberService;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

@Controller
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/user/userState")
    public void updateScoreAndCoin(UserDto scoreAndCoinDto, Model model) {
        model.addAttribute("scoreAndCoinDto", scoreAndCoinDto);
        System.out.println(scoreAndCoinDto.getCoin());
        System.out.println(scoreAndCoinDto.getHighestScore());
    }

}
