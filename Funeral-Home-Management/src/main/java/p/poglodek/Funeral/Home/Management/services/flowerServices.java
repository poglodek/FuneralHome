package p.poglodek.Funeral.Home.Management.services;

import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import p.poglodek.Funeral.Home.Management.Database.repository.flowerRepository;
import p.poglodek.Funeral.Home.Management.Database.repository.userRepository;
import p.poglodek.Funeral.Home.Management.Dto.Flower.FlowerDto;
import p.poglodek.Funeral.Home.Management.Enum.CrudEnum;
import p.poglodek.Funeral.Home.Management.Helpers.LongHelper;
import p.poglodek.Funeral.Home.Management.mappers.flowerMapper;

import java.util.ArrayList;

@Service
@AllArgsConstructor
public class flowerServices {
    private flowerMapper flowerMapper;
    private flowerRepository flowerReposiotry;
    private userRepository userRepository;
    private LongHelper longHelper;

    public ArrayList<FlowerDto> GetFlowersOfUser()
    {
        return flowerMapper.mapListToDto(flowerReposiotry.findByUser(userRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName()).get()));
    }

    public CrudEnum AddFlower(FlowerDto flowerDto) {
        var isValidFlower = isValidFlower(flowerDto);
        if(isValidFlower != CrudEnum.VALID)
            return isValidFlower;
        var flower = flowerMapper.mapToModel(flowerDto);
        flower.setUser(userRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName()).get());
        flowerReposiotry.save(flower);
        return CrudEnum.CREATED;
    }

    public FlowerDto getFlower(String id) {
        if(!canEditFlower(id))
            return null;
        return flowerMapper.mapToDto(flowerReposiotry.findById(Long.parseLong(id)).get());

    }
    public boolean canEditFlower(String id){
        if(!longHelper.tryParseLong(id) || !flowerReposiotry.existsById(Long.parseLong(id)))
            return false;
        return flowerReposiotry.findById(Long.parseLong(id)).get().getUser() == userRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName()).get();
    }

    public CrudEnum updateFlower(FlowerDto flowerDto, String id) {
        if(!canEditFlower(id))
            return CrudEnum.CANNOT_UPDATE;
        var isValidFlower = isValidFlower(flowerDto);
        if(isValidFlower != CrudEnum.VALID)
            return isValidFlower;
        var flower = flowerReposiotry.findById(Long.parseLong(id)).get();
        flower.setDescription(flowerDto.getDescription());
        flower.setPrice(flowerDto.getPrice());
        flower.setName(flowerDto.getName());
        flower.setType(flowerDto.getType());
        flowerReposiotry.save(flower);
        return CrudEnum.UPDATED;
    }
    private CrudEnum isValidFlower(FlowerDto flowerDto){
        if(flowerDto.getPrice() < 0)
            return CrudEnum.INVALID_PRICE;
        else if(flowerDto.getName().isEmpty())
            return CrudEnum.INVALID_NAME;
        else if(flowerDto.getDescription().isEmpty())
            return CrudEnum.INVALID_DESCRIPTION;
        return CrudEnum.VALID;
    }

}
