package JWTEXAMPLE.repository;

import JWTEXAMPLE.model.User;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.List;


@Getter
@Repository
public class UserRepository {
    private final List<User> users;

    public UserRepository() {
        this.users = List.of(new User("DANIIL", "1111", "sam", "EMAN", 31),
                new User("VLAD", "1122", "VLADIMIR", "PUTIN", 31));
    }


    public User getUserByLogin(String login) {
        return this.users.stream().filter(user ->
                login.equals(user.getLogin())).
                findFirst().orElse(null);
    }

}
