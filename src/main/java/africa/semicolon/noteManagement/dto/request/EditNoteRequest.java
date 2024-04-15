package africa.semicolon.noteManagement.dto.request;

import lombok.Data;

@Data
public class EditNoteRequest {
    private String content;
    private String title;

}
