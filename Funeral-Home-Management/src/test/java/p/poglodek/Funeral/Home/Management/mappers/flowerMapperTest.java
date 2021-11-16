package p.poglodek.Funeral.Home.Management.mappers;

import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import p.poglodek.Funeral.Home.Management.Database.entity.FlowerType;
import p.poglodek.Funeral.Home.Management.Dto.Flower.FlowerDto;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@AllArgsConstructor
class flowerMapperTest {



    @Test
    void mapToDto() {
        var flowerMapper = new FlowerMapper();
        var model = new FlowerType(1l,"tulip", "Nice flower", "Red tulip flower", 12.99, null,null);
        var dto = new FlowerDto(1l,"tulip", "Nice flower", "Red tulip flower", 12.99);
        var dtoFromMapper = flowerMapper.mapToDto(model);
        assertEquals(dto.getName(), dtoFromMapper.getName());
        assertEquals(dto.getPrice(), dtoFromMapper.getPrice());
        assertEquals(dto.getDescription(), dtoFromMapper.getDescription());
        assertEquals(dto.getType(), dtoFromMapper.getType());
    }

    @Test
    void mapToModel() {

        var flowerMapper = new FlowerMapper();
        var model = new FlowerType(1l,"tulip", "Nice flower", "Red tulip flower", 12.99, null,null);
        var dto = new FlowerDto(1l,"tulip", "Nice flower", "Red tulip flower", 12.99);
        var modelFromMapper = flowerMapper.mapToModel(dto);
        assertEquals(dto.getName(), modelFromMapper.getName());
        assertEquals(dto.getPrice(), modelFromMapper.getPrice());
        assertEquals(dto.getDescription(), modelFromMapper.getDescription());
        assertEquals(dto.getType(), modelFromMapper.getType());
    }

    @Test
    void mapListToDto() {
        var flowerMapper = new FlowerMapper();
        var model = new FlowerType(1l,"tulip", "Nice flower", "Red tulip flower", 12.99, null,null);
        var modelList =new ArrayList<FlowerType>();
        modelList.add(model);
        var dto = new FlowerDto(1l,"tulip", "Nice flower", "Red tulip flower", 12.99);
        var dtosFromMapper = flowerMapper.mapListToDto(modelList);
        for (var dtoFromMapper:dtosFromMapper) {
            assertEquals(dto.getName(), dtoFromMapper.getName());
            assertEquals(dto.getPrice(), dtoFromMapper.getPrice());
            assertEquals(dto.getDescription(), dtoFromMapper.getDescription());
            assertEquals(dto.getType(), dtoFromMapper.getType());
        }


    }
}