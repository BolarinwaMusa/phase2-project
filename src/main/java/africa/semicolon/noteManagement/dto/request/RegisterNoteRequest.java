package africa.semicolon.noteManagement.dto.request;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RegisterNoteRequest {
    private String title;
    private String content;
    private LocalDateTime dateCreated;
    private String id;
}
