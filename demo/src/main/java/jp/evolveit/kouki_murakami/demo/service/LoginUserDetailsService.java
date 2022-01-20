package jp.evolveit.kouki_murakami.demo.service;

import jp.evolveit.kouki_murakami.demo.model.LoginUserDetails;
import jp.evolveit.kouki_murakami.demo.repository.LoginUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class LoginUserDetailsService implements UserDetailsService {
    private final LoginUserRepository repository;

    @Autowired
    public LoginUserDetailsService(LoginUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Not found user.");
        }
        return new LoginUserDetails(user);
    }
}
