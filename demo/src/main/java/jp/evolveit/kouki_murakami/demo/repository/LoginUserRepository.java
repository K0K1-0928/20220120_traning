package jp.evolveit.kouki_murakami.demo.repository;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class LoginUserRepository {
    private Map<String, User> users;

    public LoginUserRepository() {
        this.users = new HashMap<>();
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        User user = new User("user", passwordEncoder.encode("password"),
                Collections.unmodifiableList(List.of(new SimpleGrantedAuthority("USER"))));
        users.put(user.getUsername(), user);
    }

    public User findByUsername(String username) {
        return users.containsKey(username) ? users.get(username) : null;
    }

    public boolean addUser(User user) {
        users.put(user.getUsername(), user);
        return users.containsKey(user.getUsername());
    }
}
