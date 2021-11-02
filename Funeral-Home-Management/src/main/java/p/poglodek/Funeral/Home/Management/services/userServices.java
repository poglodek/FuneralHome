package p.poglodek.Funeral.Home.Management.services;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import p.poglodek.Funeral.Home.Management.Database.repository.userRepository;

@Service
@AllArgsConstructor
public class userServices implements UserDetailsService {

    private final userRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email)
                .orElseThrow(()-> new UsernameNotFoundException("email not found."));
    }
}
