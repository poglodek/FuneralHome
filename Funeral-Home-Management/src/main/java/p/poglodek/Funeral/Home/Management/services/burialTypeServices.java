package p.poglodek.Funeral.Home.Management.services;

import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import p.poglodek.Funeral.Home.Management.Database.repository.burialTypeRepository;
import p.poglodek.Funeral.Home.Management.Database.repository.userRepository;
import p.poglodek.Funeral.Home.Management.Dto.burialType.burialTypeDto;
import p.poglodek.Funeral.Home.Management.Enum.CrudEnum;
import p.poglodek.Funeral.Home.Management.Helpers.LongHelper;
import p.poglodek.Funeral.Home.Management.mappers.burialTypesMapper;

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

    public CrudEnum AddNewBurialType(burialTypeDto burialTypeDto) {
        var isValidBurialType = IsBurialTypeValid(burialTypeDto);
        if(isValidBurialType != CrudEnum.VALID)
            return isValidBurialType;
        var burialType = burialTypesMapper.mapToModel(burialTypeDto);
        burialType.setUser(userRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName()).get());
        burialTypeRepository.save(burialType);
        return CrudEnum.CREATED;
    }
    public CrudEnum IsBurialTypeValid(burialTypeDto burialTypeDto){
        if(burialTypeDto.getPrice() < 0)
            return CrudEnum.INVALID_PRICE;
        else if(burialTypeDto.getName().isEmpty())
            return CrudEnum.INVALID_NAME;
        else if(burialTypeDto.getDescription().isEmpty())
            return CrudEnum.INVALID_DESCRIPTION;
        return CrudEnum.VALID;
    }
}
