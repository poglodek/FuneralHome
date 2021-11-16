package p.poglodek.Funeral.Home.Management.Mappers;

import org.junit.jupiter.api.Test;
import p.poglodek.Funeral.Home.Management.Database.Entity.BurialType;
import p.poglodek.Funeral.Home.Management.Dto.BurialType.BurialTypeDto;

import static org.junit.jupiter.api.Assertions.*;

class burialTypesMapperTest {

    @Test
    void mapToDto() {
        var mapper = new BurialTypesMapper();
        var burialType = new BurialType(0L,"test","type","Desc",12.3,null,null);
        var burialTypeDto = new BurialTypeDto(0L,"test","type","Desc",12.3);
        var mapped = mapper.mapToDto(burialType);
        assertEquals(burialTypeDto.getId(), mapped.getId());
        assertEquals(burialTypeDto.getName(), mapped.getName());
        assertEquals(burialTypeDto.getType(), mapped.getType());
        assertEquals(burialTypeDto.getDescription(), mapped.getDescription());
        assertEquals(burialTypeDto.getPrice(), mapped.getPrice());
    }

    @Test
    void mapToModel() {
        var mapper = new BurialTypesMapper();
        var burialType = new BurialType(0L,"test","type","Desc",12.3,null,null);
        var burialTypeDto = new BurialTypeDto(0L,"test","type","Desc",12.3);
        var mapped = mapper.mapToModel(burialTypeDto);
        assertEquals(burialType.getId(), mapped.getId());
        assertEquals(burialType.getName(), mapped.getName());
        assertEquals(burialType.getType(), mapped.getType());
        assertEquals(burialType.getDescription(), mapped.getDescription());
        assertEquals(burialType.getPrice(), mapped.getPrice());
    }
}