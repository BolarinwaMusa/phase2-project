package africa.semicolon.noteManagement.dto.request;

import lombok.Data;

@Data
public class LogInRequest {
    private String username;
    private String password;
    private boolean isLoggedIn;
}
