package p.poglodek.Funeral.Home.Management.mappers;

import org.springframework.stereotype.Service;
import p.poglodek.Funeral.Home.Management.Database.entity.burialType;
import p.poglodek.Funeral.Home.Management.Dto.burialType.burialTypeDto;

import java.util.ArrayList;
import java.util.List;

@Service
public class burialTypesMapper {
    public burialTypeDto mapToDto(burialType burialType){
        return new burialTypeDto(burialType.getId(),
                burialType.getName(),
                burialType.getType(),
                burialType.getDescription(),
                burialType.getPrice());
    }
    public burialType mapToModel(burialTypeDto burialType){
        return new burialType(burialType.getId(),
                burialType.getName(),
                burialType.getType(),
                burialType.getDescription(),
                burialType.getPrice(),
        null,null);
    }
    public List<burialTypeDto> mapListToDtoList(List<burialType> burialTypes){
        var list = new ArrayList<burialTypeDto>();
        for (var burialType: burialTypes) {
            list.add(mapToDto(burialType));
        }
        return list;
    }
}
