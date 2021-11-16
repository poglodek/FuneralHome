package p.poglodek.Funeral.Home.Management.Services;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import p.poglodek.Funeral.Home.Management.Database.Repository.ClientRepository;
import p.poglodek.Funeral.Home.Management.Database.Repository.UserRepository;
import p.poglodek.Funeral.Home.Management.Dto.Client.ClientDto;
import p.poglodek.Funeral.Home.Management.Mappers.ClientMapper;

import java.util.List;

@Service
@AllArgsConstructor
public class ClientServices {

    private ClientRepository clientRepository;
    private UserRepository userRepository;
    private ClientMapper clientMapper;

    public List<ClientDto> GetClientsDto(){
          return clientMapper.MapListToListDtos(clientRepository.findByCreatedBy(userRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName()).get()));
    }

}
