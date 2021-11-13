package p.poglodek.Funeral.Home.Management.services;

import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import p.poglodek.Funeral.Home.Management.Database.repository.burialTypeRepository;
import p.poglodek.Funeral.Home.Management.Database.repository.userRepository;
import p.poglodek.Funeral.Home.Management.Dto.burialType.burialTypeDto;
import p.poglodek.Funeral.Home.Management.Helpers.LongHelper;
import p.poglodek.Funeral.Home.Management.mappers.burialTypesMapper;
import p.poglodek.Funeral.Home.Management.mappers.flowerMapper;

import java.util.List;

@Service
@AllArgsConstructor
public class burialTypeServices {

    private burialTypeRepository burialTypeRepository;
    private burialTypesMapper burialTypesMapper;
    private userRepository userRepository;
    private LongHelper longHelper;

    public List<burialTypeDto> getBurialTypesDtoOfUser(){
        return  burialTypesMapper.mapListToDtoList(burialTypeRepository.findByUser(userRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName()).get()));
    }
}
