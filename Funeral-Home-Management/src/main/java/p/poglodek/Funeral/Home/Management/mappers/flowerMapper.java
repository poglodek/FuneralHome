package p.poglodek.Funeral.Home.Management.mappers;

import org.springframework.stereotype.Component;
import p.poglodek.Funeral.Home.Management.Database.entity.flowerType;
import p.poglodek.Funeral.Home.Management.Dto.Flower.FlowerDto;

import java.util.ArrayList;
import java.util.List;

@Component
public class flowerMapper {
    public FlowerDto mapToDto(flowerType flower){
            return new FlowerDto(
                    flower.getName(),
                    flower.getType(),
                    flower.getDescription(),
                    flower.getPrice()
        );
    }
    public flowerType mapToModel(FlowerDto flower){
        return new flowerType(
                0l,
                flower.getName(),
                flower.getType(),
                flower.getDescription(),
                flower.getPrice(),
                null,null
        );
    }
    public ArrayList<FlowerDto> mapListToDto(List<flowerType> flowers){
        var list = new ArrayList<FlowerDto>();
        for (var flower: flowers) {
            list.add(new FlowerDto(
                    flower.getName(),
                    flower.getType(),
                    flower.getDescription(),
                    flower.getPrice()));
        }
        return list;

    }
}
