package p.poglodek.Funeral.Home.Management.Services;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import p.poglodek.Funeral.Home.Management.Database.Repository.ClientRepository;
import p.poglodek.Funeral.Home.Management.Database.Repository.UserRepository;
import p.poglodek.Funeral.Home.Management.Dto.Client.ClientDto;
import p.poglodek.Funeral.Home.Management.Helpers.LongHelper;
import p.poglodek.Funeral.Home.Management.Mappers.ClientMapper;

import java.util.List;

@Service
@AllArgsConstructor
public class ClientServices {

    private ClientRepository clientRepository;
    private UserRepository userRepository;
    private ClientMapper clientMapper;
    private LongHelper longHelper;

    public List<ClientDto> getClientsDto(){
          return clientMapper.MapListToListDtos(clientRepository.findByCreatedBy(userRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName()).get()));
    }
    public ClientDto getClientDto(String id){
         if (!canIGetClient(id))
             return null;
         return clientMapper.MapToDto(clientRepository.findById(Long.parseLong(id)).get());
    }
    public boolean canIGetClient(String id){
        if(!longHelper.tryParseLong(id) || !clientRepository.existsById(Long.parseLong(id)))
            return false;
        return clientRepository.findById(Long.parseLong(id)).get().getCreatedBy() == userRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName()).get();
    }

}
