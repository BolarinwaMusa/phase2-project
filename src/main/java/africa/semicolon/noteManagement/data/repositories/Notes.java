package africa.semicolon.noteManagement.data.repositories;

import africa.semicolon.noteManagement.data.models.Note;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface Notes extends MongoRepository<Note,String> {


    Note findNoteBy(String title);

//    void edit(String title);
}
