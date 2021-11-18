package p.poglodek.Funeral.Home.Management.Services;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import p.poglodek.Funeral.Home.Management.Database.Entity.User;
import p.poglodek.Funeral.Home.Management.Database.Repository.ClientRepository;
import p.poglodek.Funeral.Home.Management.Database.Repository.FlowerRepository;
import p.poglodek.Funeral.Home.Management.Database.Repository.UserRepository;
import p.poglodek.Funeral.Home.Management.Dto.Client.ClientDto;
import p.poglodek.Funeral.Home.Management.Enum.CrudEnum;
import p.poglodek.Funeral.Home.Management.Helpers.EmailValidator;
import p.poglodek.Funeral.Home.Management.Helpers.LongHelper;
import p.poglodek.Funeral.Home.Management.Helpers.PhoneValidator;
import p.poglodek.Funeral.Home.Management.Mappers.ClientMapper;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ClientServicesTest {

    @Mock
    private ClientRepository clientRepository;
    @Mock
    private UserRepository userRepository;
    private ClientServices clientServices;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        Authentication authentication = Mockito.mock(Authentication.class);
        SecurityContext securityContext = Mockito.mock(SecurityContext.class);
        Mockito.when(securityContext.getAuthentication()).thenReturn(authentication);
        SecurityContextHolder.setContext(securityContext);
        when(SecurityContextHolder.getContext().getAuthentication().getName()).thenReturn("test@mail.com");
        var userTest = new User("First","Last","test@mail.com","P4S5w0rd!.!", 123123123);
        when(userRepository.findByEmail("test@mail.com")).thenReturn(java.util.Optional.of(userTest));
    }

    @Test
    void validClientDto_CorrectDto_ShouldReturn_CrudEnum_VALID() {
        clientServices = new ClientServices(clientRepository, userRepository, new ClientMapper(), new LongHelper(), new EmailValidator(), new PhoneValidator());
        ClientDto clientDto = new ClientDto(0L,"First","Last","email@test.com", 123123123);
        var result = clientServices.validClientDto(clientDto);
        assertEquals(CrudEnum.VALID, result);
    }
    @Test
    void validClientDto_InCorrectFirstName_ShouldReturn_CrudEnum_IncorrectFirstName() {
        clientServices = new ClientServices(clientRepository, userRepository, new ClientMapper(), new LongHelper(), new EmailValidator(), new PhoneValidator());
        ClientDto clientDto = new ClientDto(0L,"","Last","email@test.com", 123123123);
        var result = clientServices.validClientDto(clientDto);
        assertEquals(CrudEnum.INVALID_FIRST_NAME, result);
    }
    @Test
    void validClientDto_InCorrectLastName_ShouldReturn_CrudEnum_IncorrectLastName() {
        clientServices = new ClientServices(clientRepository, userRepository, new ClientMapper(), new LongHelper(), new EmailValidator(), new PhoneValidator());
        ClientDto clientDto = new ClientDto(0L,"First","","email@test.com", 123123123);
        var result = clientServices.validClientDto(clientDto);
        assertEquals(CrudEnum.INVALID_LAST_NAME, result);
    }
    @ParameterizedTest
    @ValueSource(strings = {"","abc","@","asda@","@com","@com.pl","dasd@asdasd"})
    void validClientDto_InCorrectEmail_ShouldReturn_CrudEnum_IncorrectEMAIl(String email) {
        clientServices = new ClientServices(clientRepository, userRepository, new ClientMapper(), new LongHelper(), new EmailValidator(), new PhoneValidator());
        ClientDto clientDto = new ClientDto(0L,"First","Last",email, 123123123);
        var result = clientServices.validClientDto(clientDto);
        assertEquals(CrudEnum.INVALID_EMAIL, result);
    }
}