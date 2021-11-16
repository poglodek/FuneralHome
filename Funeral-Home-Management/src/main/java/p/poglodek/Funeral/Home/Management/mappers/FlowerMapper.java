package p.poglodek.Funeral.Home.Management.mappers;

import org.springframework.stereotype.Component;
import p.poglodek.Funeral.Home.Management.Database.Entity.FlowerType;
import p.poglodek.Funeral.Home.Management.Dto.Flower.FlowerDto;

import java.util.ArrayList;
import java.util.List;

@Component
public class FlowerMapper {
    public FlowerDto mapToDto(FlowerType flower){
            return new FlowerDto(
                    flower.getId(),
                    flower.getName(),
                    flower.getType(),
                    flower.getDescription(),
                    flower.getPrice()
        );
    }
    public FlowerType mapToModel(FlowerDto flower){
        return new FlowerType(
                0l,
                flower.getName(),
                flower.getType(),
                flower.getDescription(),
                flower.getPrice(),
                null,null
        );
    }
    public ArrayList<FlowerDto> mapListToDto(List<FlowerType> flowers){
        var list = new ArrayList<FlowerDto>();
        for (var flower: flowers) {
            list.add(mapToDto(flower));
        }
        return list;

    }
}
