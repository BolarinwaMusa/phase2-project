package africa.semicolon.noteManagement.services;
import africa.semicolon.noteManagement.dto.request.RegisterRequest;
import africa.semicolon.noteManagement.dto.request.DeleteRequest;
import africa.semicolon.noteManagement.dto.request.LogOutRequest;
import africa.semicolon.noteManagement.exception.IncorrectPasswordException;
import africa.semicolon.noteManagement.data.models.User;
import africa.semicolon.noteManagement.dto.request.LogInRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import africa.semicolon.noteManagement.data.repositories.Users;

@Service
public class UserServicesImpl implements UserServices{
    @Autowired
    Users users;

    @Override
    public void register(RegisterRequest registerRequest) {
        User user = new User();
        user.setPassword(registerRequest.getPassword());
        user.setUsername(registerRequest.getUsername());
        users.save(user);
    }



    @Override
    public void logIn(LogInRequest logInRequest) {
        User user = users.findUserBy(logInRequest.getUsername());
        if(!user.getPassword().equals(logInRequest.getPassword())) throw new IncorrectPasswordException("incorrect password");
        user.setLoggedIn(true);
        users.save(user);
    }

    @Override
    public void logOut(LogOutRequest logOutRequest) {
      User user = users.findUserBy(logOutRequest.getUserName());
      user.setLoggedIn(false);
      users.save(user);

    }

    @Override
    public void delete(DeleteRequest deleteRequest) {
        User user = users.findUserBy(deleteRequest.getUserName());
        users.delete(user);
        users.save(user);

    }

    @Override
    public long count() {
        return users.count();
    }


}
