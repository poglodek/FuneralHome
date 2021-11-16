package p.poglodek.Funeral.Home.Management.Mappers;

import org.springframework.stereotype.Service;
import p.poglodek.Funeral.Home.Management.Database.Entity.Client;
import p.poglodek.Funeral.Home.Management.Dto.Client.ClientDto;

import java.util.ArrayList;
import java.util.List;

@Service
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
    public List<ClientDto> MapListToListDtos(List<Client> clients){
        List<ClientDto> clientDtos = new ArrayList<>();
        for(Client client:  clients) {
            clientDtos.add(MapToDto(client));
        }
        return clientDtos;
    }
}
