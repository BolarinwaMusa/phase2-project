package africa.semicolon.noteManagement.services;

import africa.semicolon.noteManagement.dto.request.DeleteRequest;
import africa.semicolon.noteManagement.dto.request.LogOutRequest;
import africa.semicolon.noteManagement.dto.request.RegisterRequest;
import africa.semicolon.noteManagement.dto.request.LogInRequest;
import africa.semicolon.noteManagement.data.models.User;
import africa.semicolon.noteManagement.data.repositories.Users;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.RowSet;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest

public class UserServicesTest {
    @Autowired
    private Users users;

    @Autowired
    private UserServices userServices;


    @Test
    public void testThatNewUserCanBeCreated(){
        users.deleteAll();
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setUsername("musa");
        registerRequest.setPassword("password");
        userServices.register(registerRequest);
        assertEquals(1, userServices.count());
    }
    @Test
    public void testThatUserCanLogIn(){
         users.deleteAll();
         RegisterRequest registerRequest = new RegisterRequest();
         registerRequest.setUsername("musa");
         registerRequest.setPassword("password");
         userServices.register(registerRequest);
         LogInRequest logInRequest = new LogInRequest();
         User user = users.findUserBy(logInRequest.getUsername());
         user.setLoggedIn(true);
         users.save(user);
    }
    @Test
     public void testThatUserCanLogOut(){
          users.deleteAll();
          RegisterRequest registerRequest = new RegisterRequest();
          registerRequest.setUsername("musa");
          registerRequest.setPassword("password");
          userServices.register(registerRequest);
          LogInRequest logInRequest = new LogInRequest();
          User user = users.findUserBy(logInRequest.getUsername());
          user.setLoggedIn(true);
          users.save(user);
          LogOutRequest logOutRequest = new LogOutRequest();
           user = users.findUserBy(logOutRequest.getUserName());
          user.setLoggedIn(false);
          users.save(user);
    }

    @Test
    public void testThatUserCanBeDeleted(){
        users.deleteAll();
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setUsername("musa");
        registerRequest.setPassword("password");
        userServices.register(registerRequest);
        LogInRequest logInRequest = new LogInRequest();
        User user = users.findUserBy(logInRequest.getUsername());
        user.setLoggedIn(true);
        users.save(user);
        LogOutRequest logOutRequest = new LogOutRequest();
        user = users.findUserBy(logOutRequest.getUserName());
        user.setLoggedIn(false);
        users.save(user);
        DeleteRequest deleteRequest = new DeleteRequest();
         user = users.findUserBy(deleteRequest.getUserName());
        users.delete(user);

    }


    }




