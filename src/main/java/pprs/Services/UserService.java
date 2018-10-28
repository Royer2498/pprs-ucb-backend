package pprs.Services;

import javafx.util.Pair;
import pprs.Models.User;

public interface UserService {

    void saveUser(User user);

    boolean findByUsername(String username);

    User findById(String id);

    void editUser(User user);

    void deleteUser(String id);

    boolean userNameAlreadyExists(User user);

    User isPasswordCorrect(User user);


}
