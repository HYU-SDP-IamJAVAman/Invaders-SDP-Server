package siServer.space_invaders.dto;

import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

@Getter
@Setter
public class SignupForm {
    @NotBlank
    private String nickname;

    @NotBlank
    private String username;

    @NotBlank
    private String password;
}
