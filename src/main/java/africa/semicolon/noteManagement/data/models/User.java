package africa.semicolon.noteManagement.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("user_list")
@Data
public class User {
    private String username;
    private String password;
    @Id
    private String id;
    private boolean isLoggedIn;
    }

