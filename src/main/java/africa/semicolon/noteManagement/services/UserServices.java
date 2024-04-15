package africa.semicolon.noteManagement.services;

import africa.semicolon.noteManagement.dto.request.RegisterRequest;
import africa.semicolon.noteManagement.dto.request.DeleteRequest;
import africa.semicolon.noteManagement.dto.request.LogInRequest;
import africa.semicolon.noteManagement.dto.request.LogOutRequest;
import org.springframework.stereotype.Service;

@Service

public interface UserServices {
    void register(RegisterRequest registerRequest);



    void logIn(LogInRequest logInRequest);

    void logOut(LogOutRequest logOutRequest);
    void delete(DeleteRequest deleteRequest);

    long count();
}
