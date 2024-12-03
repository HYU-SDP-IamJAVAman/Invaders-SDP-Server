package siServer.space_invaders.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberResponse {
    private String nickname;

    private String currentCoin;

    private String score;

    public MemberResponse(String nickname) {
        this.nickname = nickname;
    }
}
