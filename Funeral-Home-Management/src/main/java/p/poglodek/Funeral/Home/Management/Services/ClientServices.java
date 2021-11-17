package p.poglodek.Funeral.Home.Management.Services;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import p.poglodek.Funeral.Home.Management.Database.Entity.Client;
import p.poglodek.Funeral.Home.Management.Database.Repository.ClientRepository;
import p.poglodek.Funeral.Home.Management.Database.Repository.UserRepository;
import p.poglodek.Funeral.Home.Management.Dto.Client.ClientDto;
import p.poglodek.Funeral.Home.Management.Enum.CrudEnum;
import p.poglodek.Funeral.Home.Management.Helpers.EmailValidator;
import p.poglodek.Funeral.Home.Management.Helpers.LongHelper;
import p.poglodek.Funeral.Home.Management.Helpers.PhoneValidator;
import p.poglodek.Funeral.Home.Management.Mappers.ClientMapper;

import java.util.List;

@Service
@AllArgsConstructor
public class ClientServices {

    private ClientRepository clientRepository;
    private UserRepository userRepository;
    private ClientMapper clientMapper;
    private LongHelper longHelper;
    private EmailValidator emailValidator;
    private PhoneValidator phoneValidator;

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

    public CrudEnum addClient(ClientDto clientDto) {
        var validResult = validClientDto(clientDto);
        if(validResult != CrudEnum.VALID)
            return  validResult;
        Client client = clientMapper.MapToModel(clientDto);
        client.setCreatedBy(userRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName()).get());
        clientRepository.save(client);
        return CrudEnum.CREATED;
    }
    public CrudEnum validClientDto(ClientDto clientDto){
        if(clientDto.getFirstName().isEmpty())
            return CrudEnum.INVALID_FIRST_NAME;
        else if(clientDto.getLastName().isEmpty())
            return CrudEnum.INVALID_LAST_NAME;
        else if(!emailValidator.test(clientDto.getEmail()))
            return CrudEnum.INVALID_EMAIL;
        else if(!phoneValidator.isValid(clientDto.getPhone()))
            return CrudEnum.INVALID_PHONE;
        return CrudEnum.VALID;
    }
}
