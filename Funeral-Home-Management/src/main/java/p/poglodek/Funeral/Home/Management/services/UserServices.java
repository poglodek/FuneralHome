package p.poglodek.Funeral.Home.Management.services;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import p.poglodek.Funeral.Home.Management.Database.repository.UserRepository;
import p.poglodek.Funeral.Home.Management.Enum.StatusRegister;
import p.poglodek.Funeral.Home.Management.mappers.UserMapper;
import p.poglodek.Funeral.Home.Management.Dto.User.UserRegisterDto;
import p.poglodek.Funeral.Home.Management.Helpers.EmailValidator;

@Service
@AllArgsConstructor
public class UserServices implements UserDetailsService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final EmailValidator emailValidator;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;



    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email)
                .orElseThrow(()-> new UsernameNotFoundException("email not found."));
    }
    public StatusRegister signUpUser(UserRegisterDto userRegisterDto)
    {
        if(!emailValidator.test(userRegisterDto.getEmail())) return StatusRegister.EMAIL_NOT_VALID;
        var user = userMapper.mapToUser(userRegisterDto);
        if(userRepository.findByEmail(user.getEmail()).isPresent()) return StatusRegister.USER_EXIST;
        var encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userRepository.save(user);
        return StatusRegister.OK;
    }
}
