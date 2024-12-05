package siServer.space_invaders.dto;

import jakarta.persistence.criteria.Predicate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponse {
    private String nickname;

    private String currentCoin;

    private Integer totalPlay;

    private Integer totalScore;

    private Integer maxCombo;

    private Integer currentPerfectStage;

    private Boolean flawlessFailure;

    public LoginResponse(String nickname, Integer totalPlay, Integer totalScore
    , Integer maxCombo, Integer currentPerfectStage, Boolean flawlessFailure) {
        this.nickname = nickname;
        this.totalPlay = totalPlay;
        this.totalScore = totalScore;
        this.maxCombo = maxCombo;
        this.currentPerfectStage = currentPerfectStage;
        this.flawlessFailure = flawlessFailure;
    }
}
