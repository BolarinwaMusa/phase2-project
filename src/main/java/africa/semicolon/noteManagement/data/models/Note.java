package africa.semicolon.noteManagement.data.models;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document("note_list")
public class Note {
    private String id;
    private String title;
    private String content;
    private LocalDateTime dateCreated;
    private LocalDateTime dateModified;
}
