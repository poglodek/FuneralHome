package p.poglodek.Funeral.Home.Management.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import p.poglodek.Funeral.Home.Management.Database.repository.flowerReposiotry;
import p.poglodek.Funeral.Home.Management.Dto.Flower.FlowerDto;
import p.poglodek.Funeral.Home.Management.mappers.flowerMapper;

import java.util.ArrayList;

@Service
@AllArgsConstructor
public class flowerServices {
    private flowerMapper flowerMapper;
    private flowerReposiotry flowerReposiotry;

    public ArrayList<FlowerDto> GetFlowers()
    {
        return flowerMapper.mapListToDto(flowerReposiotry.findAll());
    }

}
