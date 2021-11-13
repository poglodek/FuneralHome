package p.poglodek.Funeral.Home.Management.services;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import p.poglodek.Funeral.Home.Management.Database.entity.user;
import p.poglodek.Funeral.Home.Management.Database.repository.flowerRepository;
import p.poglodek.Funeral.Home.Management.Database.repository.userRepository;
import p.poglodek.Funeral.Home.Management.Dto.Flower.FlowerDto;
import p.poglodek.Funeral.Home.Management.Enum.CrudEnum;
import p.poglodek.Funeral.Home.Management.Helpers.LongHelper;
import p.poglodek.Funeral.Home.Management.mappers.flowerMapper;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class flowerServicesTest {

    @Mock
    private flowerRepository flowerReposiotry;
    @Mock
    private userRepository userRepository;
    private flowerServices flowerServices;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        Authentication authentication = Mockito.mock(Authentication.class);
        SecurityContext securityContext = Mockito.mock(SecurityContext.class);
        Mockito.when(securityContext.getAuthentication()).thenReturn(authentication);
        SecurityContextHolder.setContext(securityContext);
        when(SecurityContextHolder.getContext().getAuthentication().getName()).thenReturn("test@mail.com");
        var userTest = new user("First","Last","test@mail.com","P4S5w0rd!.!", 123123123);
        when(userRepository.findByEmail("test@mail.com")).thenReturn(java.util.Optional.of(userTest));
    }


    @Test
    void addFlower_InCorrectName_ShouldReturn_CrudEnumINVALID_NAME() {

        flowerServices = new flowerServices(new flowerMapper(),flowerReposiotry,userRepository, new LongHelper());
        var flowerDto = new FlowerDto(0L, "","Testing Flower","Very pretty flower", 12.3);
        var result = flowerServices.AddFlower(flowerDto);
        assertEquals(CrudEnum.INVALID_NAME, result);
    }
    @Test
    void addFlower_InCorrectDescription_ShouldReturn_CrudEnumINVALID_DESCRIPTION() {

        flowerServices = new flowerServices(new flowerMapper(),flowerReposiotry,userRepository, new LongHelper());
        var flowerDto = new FlowerDto(0L, "Test","Testing Flower","", 12.3);
        var result = flowerServices.AddFlower(flowerDto);
        assertEquals(CrudEnum.INVALID_DESCRIPTION, result);
    }
    @Test
    void addFlower_PriceEqualZero_ShouldReturn_CrudEnumINVALID_DESCRIPTION() {

        flowerServices = new flowerServices(new flowerMapper(),flowerReposiotry,userRepository, new LongHelper());
        var flowerDto = new FlowerDto(0L, "Test","Testing Flower","Very pretty flower", 0);
        var result = flowerServices.AddFlower(flowerDto);
        assertEquals(CrudEnum.INVALID_PRICE, result);
    }
    @Test
    void addFlower_PriceLessZero_ShouldReturn_CrudEnumINVALID_DESCRIPTION() {

        flowerServices = new flowerServices(new flowerMapper(),flowerReposiotry,userRepository, new LongHelper());
        var flowerDto = new FlowerDto(0L, "Test","Testing Flower","Very pretty flower", -1);
        var result = flowerServices.AddFlower(flowerDto);
        assertEquals(CrudEnum.INVALID_PRICE, result);
    }

    
}