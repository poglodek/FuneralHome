package p.poglodek.Funeral.Home.Management.services;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import p.poglodek.Funeral.Home.Management.Database.Entity.User;
import p.poglodek.Funeral.Home.Management.Database.Repository.BurialTypeRepository;
import p.poglodek.Funeral.Home.Management.Database.Repository.UserRepository;
import p.poglodek.Funeral.Home.Management.Dto.BurialType.BurialTypeDto;
import p.poglodek.Funeral.Home.Management.Enum.CrudEnum;
import p.poglodek.Funeral.Home.Management.Helpers.LongHelper;
import p.poglodek.Funeral.Home.Management.mappers.BurialTypesMapper;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class burialTypeServicesTest {

    @Mock
    private BurialTypeRepository burialTypeRepository;
    @Mock
    private UserRepository userRepository;
    private BurialTypeServices burialTypeServices;

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
    void isBurialTypeValid_InValidName_ShouldReturn_Crud_INVALID_NAME() {
        burialTypeServices = new BurialTypeServices(burialTypeRepository,new BurialTypesMapper(),userRepository, new LongHelper());
        var burialDto = new BurialTypeDto(0L,"","Type","Desc", 12.3);
        var result = burialTypeServices.IsBurialTypeValid(burialDto);
        assertEquals(CrudEnum.INVALID_NAME,result);
    }
    @Test
    void isBurialTypeValid_InValidDescription_ShouldReturn_Crud_INVALID_DESCRIPTION() {
        burialTypeServices = new BurialTypeServices(burialTypeRepository,new BurialTypesMapper(),userRepository, new LongHelper());
        var burialDto = new BurialTypeDto(0L,"Test","type","", 12.3);
        var result = burialTypeServices.IsBurialTypeValid(burialDto);
        assertEquals(CrudEnum.INVALID_DESCRIPTION,result);
    }
    @Test
    void isBurialTypeValid_InValidPrice_ShouldReturn_Crud_INVALID_Price() {
        burialTypeServices = new BurialTypeServices(burialTypeRepository,new BurialTypesMapper(),userRepository, new LongHelper());
        var burialDto = new BurialTypeDto(0L,"Test","type","Desc", -3);
        var result = burialTypeServices.IsBurialTypeValid(burialDto);
        assertEquals(CrudEnum.INVALID_PRICE,result);
    }
    @Test
    void isBurialTypeValid_PriceEqualZero_ShouldReturn_Crud_Valid() {
        burialTypeServices = new BurialTypeServices(burialTypeRepository,new BurialTypesMapper(),userRepository, new LongHelper());
        var burialDto = new BurialTypeDto(0L,"Test","type","Desc", 0);
        var result = burialTypeServices.IsBurialTypeValid(burialDto);
        assertEquals(CrudEnum.VALID,result);
    }
    @Test
    void isBurialTypeValid_ValidModel_ShouldReturn_Crud_Valid() {
        burialTypeServices = new BurialTypeServices(burialTypeRepository,new BurialTypesMapper(),userRepository, new LongHelper());
        var burialDto = new BurialTypeDto(0L,"Test","type","Desc", 12.3);
        var result = burialTypeServices.IsBurialTypeValid(burialDto);
        assertEquals(CrudEnum.VALID,result);
    }

}