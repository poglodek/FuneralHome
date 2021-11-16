package p.poglodek.Funeral.Home.Management.services;

import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import p.poglodek.Funeral.Home.Management.Database.repository.BurialTypeRepository;
import p.poglodek.Funeral.Home.Management.Database.repository.UserRepository;
import p.poglodek.Funeral.Home.Management.Dto.burialType.BurialTypeDto;
import p.poglodek.Funeral.Home.Management.Enum.CrudEnum;
import p.poglodek.Funeral.Home.Management.Helpers.LongHelper;
import p.poglodek.Funeral.Home.Management.mappers.BurialTypesMapper;

import java.util.List;

@Service
@AllArgsConstructor
public class BurialTypeServices {

    private BurialTypeRepository burialTypeRepository;
    private BurialTypesMapper burialTypesMapper;
    private UserRepository userRepository;
    private LongHelper longHelper;

    public List<BurialTypeDto> getBurialTypesDtoOfUser(){
        return  burialTypesMapper.mapListToDtoList(burialTypeRepository.findByUser(userRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName()).get()));
    }

    public CrudEnum AddNewBurialType(BurialTypeDto burialTypeDto) {
        var isValidBurialType = IsBurialTypeValid(burialTypeDto);
        if(isValidBurialType != CrudEnum.VALID)
            return isValidBurialType;
        var burialType = burialTypesMapper.mapToModel(burialTypeDto);
        burialType.setUser(userRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName()).get());
        burialTypeRepository.save(burialType);
        return CrudEnum.CREATED;
    }
    public CrudEnum IsBurialTypeValid(BurialTypeDto burialTypeDto){
        if(burialTypeDto.getPrice() < 0)
            return CrudEnum.INVALID_PRICE;
        else if(burialTypeDto.getName().isEmpty())
            return CrudEnum.INVALID_NAME;
        else if(burialTypeDto.getDescription().isEmpty())
            return CrudEnum.INVALID_DESCRIPTION;
        return CrudEnum.VALID;
    }
    public boolean canEditBurialType(String id){
        if(!longHelper.tryParseLong(id) || !burialTypeRepository.existsById(Long.parseLong(id)))
            return false;
        return burialTypeRepository.findById(Long.parseLong(id)).get().getUser() == userRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName()).get();
    }

    public BurialTypeDto getBurialTypeDtoById(String id) {
        if(!canEditBurialType(id))
            return null;
        return  burialTypesMapper.mapToDto(burialTypeRepository.findById(Long.parseLong(id)).get());

    }

    public CrudEnum updateBurialType(BurialTypeDto burialTypeDto, String id) {
        if(!canEditBurialType(id))
            return CrudEnum.CANNOT_UPDATE;
        var isValidBurialType = IsBurialTypeValid(burialTypeDto);
        if(isValidBurialType != CrudEnum.VALID)
            return isValidBurialType;
        var burialType = burialTypeRepository.findById(Long.parseLong(id)).get();
        burialType.setName(burialTypeDto.getName());
        burialType.setType(burialTypeDto.getType());
        burialType.setDescription(burialTypeDto.getDescription());
        burialType.setPrice(burialTypeDto.getPrice());
        burialTypeRepository.save(burialType);
        return CrudEnum.UPDATED;
    }
}
