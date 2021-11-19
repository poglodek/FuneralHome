package p.poglodek.Funeral.Home.Management.Services;


import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import p.poglodek.Funeral.Home.Management.Database.Entity.FuneralInformation;
import p.poglodek.Funeral.Home.Management.Database.Repository.FuneralInformationRepository;
import p.poglodek.Funeral.Home.Management.Database.Repository.UserRepository;
import p.poglodek.Funeral.Home.Management.Dto.FuneralInformation.FuneralInformationDto;
import p.poglodek.Funeral.Home.Management.Mappers.FuneralInformationMapper;

import java.util.List;

@AllArgsConstructor
@Service
public class FuneralInformationServices {

    private FuneralInformationMapper funeralInformationMapper;
    private FuneralInformationRepository funeralInformationRepository;
    private UserRepository userRepository;

    public List<FuneralInformationDto> getFuneralInformationList(){

        return funeralInformationMapper.mapListToDtoList(funeralInformationRepository.findByCreatedBy(userRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName()).get()));
    }
}
