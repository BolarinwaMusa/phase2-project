package africa.semicolon.noteManagement.services;

import africa.semicolon.noteManagement.data.models.Note;
import africa.semicolon.noteManagement.data.repositories.Notes;
import africa.semicolon.noteManagement.dto.request.DeleteNoteRequest;
import africa.semicolon.noteManagement.dto.request.EditNoteRequest;
import africa.semicolon.noteManagement.dto.request.RegisterNoteRequest;
import africa.semicolon.noteManagement.exception.InvalidNoteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoteServicesImpl implements NoteServices {
    @Autowired
    Notes notes;
@Override
    public void createNote(RegisterNoteRequest registerNoteRequest) {

        Note note = new Note();
        note.setTitle(registerNoteRequest.getTitle());
        note.setContent(registerNoteRequest.getContent());
        note.setDateCreated(registerNoteRequest.getDateCreated());
        notes.save(note);
    }
    @Override
    public void deleteNote(DeleteNoteRequest deleteNoteRequest) {
        Note note = notes.findNoteBy(deleteNoteRequest.getTitle());
        notes.findNoteBy(deleteNoteRequest.getContent());
        notes.delete(note);
        notes.save(note);

    }

    @Override
    public void EditNote(EditNoteRequest editNoteRequest) {
        Note note = notes.findNoteBy(editNoteRequest.getTitle());
        if (!note.getTitle().equals(editNoteRequest.getTitle())) throw new InvalidNoteException("Note does not exist");
//        notes.edit(note.getTitle());
        notes.save(note);

    }

    }




