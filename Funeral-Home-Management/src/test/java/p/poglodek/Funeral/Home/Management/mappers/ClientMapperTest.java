package p.poglodek.Funeral.Home.Management.mappers;

import org.aspectj.lang.annotation.Before;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import p.poglodek.Funeral.Home.Management.Database.Entity.Client;
import p.poglodek.Funeral.Home.Management.Dto.Client.ClientDto;

import static org.junit.jupiter.api.Assertions.*;

class ClientMapperTest {

    private ClientMapper clientMapper;
    private Client client;
    private ClientDto clientDto;

    @BeforeEach
    void setUp(){
        clientMapper = new ClientMapper();
        client = new Client(0L,"First","Last","Email@mail.com", 123123123, null,null);
        clientDto = new ClientDto(0L, "First","Last","Email@mail.com", 123123123);
    }

    @Test
    void mapToModel_ShouldReturnModel() {
        var mappedObject = clientMapper.MapToModel(clientDto);
        assertEquals(client.getId(),mappedObject.getId());
        assertEquals(client.getFirstName(),mappedObject.getFirstName());
        assertEquals(client.getLastName(),mappedObject.getLastName());
        assertEquals(client.getEmail(),mappedObject.getEmail());
        assertEquals(client.getPhone(),mappedObject.getPhone());
    }

    @Test
    void mapToDto_ShouldReturnDto() {
        var mappedObject = clientMapper.MapToDto(client);
        assertEquals(clientDto.getId(),mappedObject.getId());
        assertEquals(clientDto.getFirstName(),mappedObject.getFirstName());
        assertEquals(clientDto.getLastName(),mappedObject.getLastName());
        assertEquals(clientDto.getEmail(),mappedObject.getEmail());
        assertEquals(clientDto.getPhone(),mappedObject.getPhone());
    }
}