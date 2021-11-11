package p.poglodek.Funeral.Home.Management.services;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import p.poglodek.Funeral.Home.Management.Database.repository.userRepository;
import p.poglodek.Funeral.Home.Management.Enum.statusRegister;
import p.poglodek.Funeral.Home.Management.mappers.userMapper;
import p.poglodek.Funeral.Home.Management.Dto.User.userRegisterDto;
import p.poglodek.Funeral.Home.Management.validator.emailValidator;

@Service
@AllArgsConstructor
public class userServices implements UserDetailsService {

    private final userRepository userRepository;
    private final userMapper userMapper;
    private final emailValidator emailValidator;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;



    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email)
                .orElseThrow(()-> new UsernameNotFoundException("email not found."));
    }
    public statusRegister signUpUser(userRegisterDto userRegisterDto)
    {
        if(!emailValidator.test(userRegisterDto.getEmail())) return statusRegister.EMAIL_NOT_VALID;
        var user = userMapper.mapToUser(userRegisterDto);
        if(userRepository.findByEmail(user.getEmail()).isPresent()) return statusRegister.USER_EXIST;
        var encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userRepository.save(user);
        return statusRegister.OK;
    }
}
