package africa.semicolon.noteManagement.dto.request;

import lombok.Data;

@Data
public class DeleteNoteRequest {
    private String title;
    private String content;
}
