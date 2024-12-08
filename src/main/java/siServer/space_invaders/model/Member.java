package siServer.space_invaders.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String username;

    private String password;

    private String nickname;

    private Integer coin = 0;

    private Integer highestScore = 0;

    private Integer totalPlay = 0;

    private Integer totalScore = 0;

    private Integer maxCombo = 0;

    private Integer currentPerfectStage = 0;

    private Boolean flawlessFailure = false;

    public void signUp(String nickname, String username, String password) {
        this.nickname = nickname;
        this.username = username;
        this.password = password;
    }

    public void update(Integer coin, Integer score, Integer totalPlay, Integer totalScore, Integer maxCombo, Integer currentPerfectStage, Boolean flawlessFailure){
        this.coin = coin;
        this.highestScore = score;
        this.totalPlay = totalPlay;
        this.totalScore = totalScore;
        this.maxCombo = maxCombo;
        this.currentPerfectStage = currentPerfectStage;
        this.flawlessFailure = flawlessFailure;
    }
}
