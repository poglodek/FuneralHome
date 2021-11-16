package p.poglodek.Funeral.Home.Management.mappers;

import org.junit.jupiter.api.Test;
import p.poglodek.Funeral.Home.Management.Database.entity.User;
import p.poglodek.Funeral.Home.Management.Dto.User.UserRegisterDto;

import static org.junit.jupiter.api.Assertions.*;

class userMapperTest {

    @Test
    void mapToUser() {
        var mapper = new UserMapper();
        var user = new User("Test","Testing","test@test.com","T3ss&tedPa5520!rd.",123123123);
        var userDto = new UserRegisterDto("Test","Testing","test@test.com","T3ss&tedPa5520!rd.",123123123);
        var userMapped = mapper.mapToUser(userDto);
        assertEquals(user.getFirstName(),userMapped.getFirstName());
        assertEquals(user.getLastName(),userMapped.getLastName());
        assertEquals(user.getEmail(),userMapped.getEmail());
        assertEquals(user.getPassword(),userMapped.getPassword());
        assertEquals(user.getPhoneNumber(),userMapped.getPhoneNumber());
    }
}