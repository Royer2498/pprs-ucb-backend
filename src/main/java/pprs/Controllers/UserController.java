package pprs.Controllers;

import pprs.Controllers.exception.IncorrectPasswordException;
import pprs.Controllers.exception.IncorrectUserNameException;
import pprs.Controllers.exception.UserAlreadyExistsException;
import pprs.Controllers.exception.UserNotFoundException;
import pprs.Models.User;
import pprs.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/registration")
    @ResponseStatus(HttpStatus.CREATED)
    public void registration(@RequestBody User user) throws HttpMessageNotReadableException, UserAlreadyExistsException {
        boolean userExists = userService.findByUsername(user.getUsername());
        if (!userExists)
            userService.saveUser(user);
        else
            throw new UserAlreadyExistsException("");
    }

    @GetMapping(value = "/user/{id}")
    public User getUser(@PathVariable String id) throws UserNotFoundException {
        User user = userService.findById(id);
        if (user != null)
            return user;
        else
            throw new UserNotFoundException("");
    }

    @PostMapping(value = "/login")
    public User login(@RequestBody User user) throws IncorrectPasswordException, IncorrectUserNameException {
        if (userService.userNameAlreadyExists(user)) {
            User loggedUser = userService.isPasswordCorrect(user);
            if (loggedUser == null)
                throw new IncorrectPasswordException("");
            return loggedUser;
        } else
            throw new IncorrectUserNameException("");
    }

    @PutMapping(value = "/user")
    public void editUser(@RequestBody User user) throws UserNotFoundException {
        User userEdited = userService.findById(user.getId());
        if (userEdited != null) {
            userService.editUser(user);
        } else
            throw new UserNotFoundException("");
    }

    @DeleteMapping(value = "/user/{id}")
    public void deleteUser(@PathVariable String id) throws UserNotFoundException{
        User userEdited = userService.findById(id);
        if (userEdited != null) {
            userService.deleteUser(id);
        } else
            throw new UserNotFoundException("");
    }

}
