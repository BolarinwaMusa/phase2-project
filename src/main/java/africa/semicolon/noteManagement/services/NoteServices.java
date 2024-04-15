package africa.semicolon.noteManagement.services;

import africa.semicolon.noteManagement.dto.request.DeleteNoteRequest;
import africa.semicolon.noteManagement.dto.request.EditNoteRequest;
import africa.semicolon.noteManagement.dto.request.RegisterNoteRequest;
import org.springframework.stereotype.Service;


public interface NoteServices {
    void createNote(RegisterNoteRequest registerNoteRequest);
    void deleteNote(DeleteNoteRequest deleteNoteRequest);
    void EditNote(EditNoteRequest editNoteRequest);
}
