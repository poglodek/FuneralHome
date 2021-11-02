package p.poglodek.Funeral.Home.Management.services;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import p.poglodek.Funeral.Home.Management.Database.repository.userRepository;
import p.poglodek.Funeral.Home.Management.mappers.userMapper;
import p.poglodek.Funeral.Home.Management.model.registerRequest;

@Service
@AllArgsConstructor
public class userServices implements UserDetailsService {

    private final userRepository userRepository;
    private final userMapper userMapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;



    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email)
                .orElseThrow(()-> new UsernameNotFoundException("email not found."));
    }
    public boolean signUpUser(registerRequest registerRequest)
    {
        var user = userMapper.mapToUser(registerRequest);
        if(userRepository.findByEmail(user.getEmail()).isPresent()) throw new IllegalStateException("User exist");
        var encodedPassword =
                bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userRepository.save(user);
        System.out.println(user.getEmail() + " " + user.getPassword());
        return  true;
    }
}
