package p.poglodek.Funeral.Home.Management.Mappers;

import org.springframework.stereotype.Service;
import p.poglodek.Funeral.Home.Management.Database.Entity.BurialType;
import p.poglodek.Funeral.Home.Management.Dto.BurialType.BurialTypeDto;

import java.util.ArrayList;
import java.util.List;

@Service
public class BurialTypesMapper {
    public BurialTypeDto mapToDto(BurialType burialType){
        return new BurialTypeDto(burialType.getId(),
                burialType.getName(),
                burialType.getType(),
                burialType.getDescription(),
                burialType.getPrice());
    }
    public BurialType mapToModel(BurialTypeDto burialType){
        return new BurialType(burialType.getId(),
                burialType.getName(),
                burialType.getType(),
                burialType.getDescription(),
                burialType.getPrice(),
        null,null);
    }
    public List<BurialTypeDto> mapListToDtoList(List<BurialType> burialTypes){
        var list = new ArrayList<BurialTypeDto>();
        for (var burialType: burialTypes) {
            list.add(mapToDto(burialType));
        }
        return list;
    }
}
