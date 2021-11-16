package p.poglodek.Funeral.Home.Management.mappers;

import p.poglodek.Funeral.Home.Management.Database.Entity.Client;
import p.poglodek.Funeral.Home.Management.Dto.Client.ClientDto;

public class ClientMapper {

    public Client MapToModel(ClientDto clientDto){
        return new Client(
                clientDto.getId(),
                clientDto.getFirstName(),
                clientDto.getLastName(),
                clientDto.getEmail(),
                clientDto.getPhone(),
                null, null
        );
    }
    public ClientDto MapToDto(Client client){
        return new ClientDto(
                client.getId(),
                client.getFirstName(),
                client.getLastName(),
                client.getEmail(),
                client.getPhone()
        );
    }
}
