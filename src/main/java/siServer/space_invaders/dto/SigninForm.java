package siServer.space_invaders.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SigninForm {
    @NotBlank
    private String username;

    @NotBlank
    private String password;
}
