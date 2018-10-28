package pprs.Services;

import javafx.util.Pair;
import pprs.Models.User;
import pprs.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;
import org.springframework.data.mongodb.core.query.*;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final MongoOperations mo;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, MongoOperations mo) {
        this.userRepository = userRepository;
        this.mo = mo;
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public boolean findByUsername(String username) {
        Query query = new Query();
        query.addCriteria(Criteria.where("username").is(username));
        return mo.exists(query, User.class);
    }

    @Override
    public User findById(String id) {
        return userRepository.findOne(id);
    }

    @Override
    public boolean userNameAlreadyExists(User user) {
        Query query = new Query();
        query.addCriteria(Criteria.where("username").is(user.getUsername()));
        return mo.exists(query, User.class);
    }

    @Override
    public User isPasswordCorrect(User user) {
        Query query = new Query();
        query.addCriteria(Criteria.where("username").is(user.getUsername()).and("password").is(user.getPassword()));
        if (mo.exists(query, User.class))
            return mo.findOne(query, User.class);
        else
            return null;
    }


    @Override
    public void editUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUser(String id) {
        userRepository.delete(id);
    }

}
