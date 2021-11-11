package p.poglodek.Funeral.Home.Management.services;

import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import p.poglodek.Funeral.Home.Management.Database.repository.flowerReposiotry;
import p.poglodek.Funeral.Home.Management.Database.repository.userRepository;
import p.poglodek.Funeral.Home.Management.Dto.Flower.FlowerDto;
import p.poglodek.Funeral.Home.Management.Enum.CrudEnum;
import p.poglodek.Funeral.Home.Management.Helpers.IntegerHelper;
import p.poglodek.Funeral.Home.Management.Helpers.LongHelper;
import p.poglodek.Funeral.Home.Management.mappers.flowerMapper;

import java.util.ArrayList;

@Service
@AllArgsConstructor
public class flowerServices {
    private flowerMapper flowerMapper;
    private flowerReposiotry flowerReposiotry;
    private userRepository userRepository;
    private LongHelper longHelper;

    public ArrayList<FlowerDto> GetFlowers()
    {
        return flowerMapper.mapListToDto(flowerReposiotry.findByUser(userRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName()).get()));
    }

    public CrudEnum AddFlower(FlowerDto flowerDto)
    {
        System.out.println(flowerDto.getPrice());
        if (flowerDto.getName().isEmpty())
            return  CrudEnum.INVALID_NAME;
        if (flowerDto.getDescription().isEmpty())
            return CrudEnum.INVALID_DESCRIPTION;
        if (flowerDto.getPrice() < 0)
            return CrudEnum.INVALID_PRICE;
        var flower = flowerMapper.mapToModel(flowerDto);
        flower.setUser(userRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName()).get());
        flowerReposiotry.save(flower);
        return CrudEnum.CREATED;
    }

    public FlowerDto getFlower(String id) {
        System.out.println(id);
        if(!longHelper.tryParseLong(id) || !flowerReposiotry.existsById(Long.parseLong(id)))
            return null;
        var flower = flowerReposiotry.findById(Long.parseLong(id)).get();
        var user = userRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName()).get();
        if(flower.getUser() == user)
            return flowerMapper.mapToDto(flower);
        else
            return null;

    }
}
