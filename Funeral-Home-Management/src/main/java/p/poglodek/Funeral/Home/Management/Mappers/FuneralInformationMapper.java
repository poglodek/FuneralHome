package p.poglodek.Funeral.Home.Management.Mappers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import p.poglodek.Funeral.Home.Management.Database.Entity.FuneralInformation;
import p.poglodek.Funeral.Home.Management.Dto.FuneralInformation.FuneralInformationCreateDto;
import p.poglodek.Funeral.Home.Management.Dto.FuneralInformation.FuneralInformationDto;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class FuneralInformationMapper {

    public FuneralInformationDto mapToDto(FuneralInformation funeralInformation){
        return new FuneralInformationDto(funeralInformation.getId(),
                funeralInformation.getClient().getFirstName() + " " + funeralInformation.getClient().getLastName(),
                funeralInformation.getBodyCoolerNumber(),
                funeralInformation.isInCooler(),
                funeralInformation.getDateOfBurial(),
                funeralInformation.getCemeteryAddress(),
                funeralInformation.isInCemetery());
    }
    public List<FuneralInformationDto> mapListToDtoList(List<FuneralInformation> funeralInformationList){
        List<FuneralInformationDto> funeralInformationDtoList = new ArrayList<>();
        for (var funeralInfo: funeralInformationList) {
            funeralInformationDtoList.add(mapToDto(funeralInfo));
        }
        return funeralInformationDtoList;
    }
    public FuneralInformation mapToModel(FuneralInformationDto funeralInformationDto){
        return  new FuneralInformation(funeralInformationDto.getId(),
                null,
                funeralInformationDto.getBodyCoolerNumber(),
                funeralInformationDto.isInCooler(),
                funeralInformationDto.getDateOfBurial(),
                funeralInformationDto.getCemeteryAddress(),
                funeralInformationDto.isInCemetery(),
                null,null,null);
    }
    public FuneralInformation mapToModel(FuneralInformationCreateDto funeralInformationDto){
        return  new FuneralInformation(0L,
                null,
                funeralInformationDto.getBodyCoolerNumber(),
                funeralInformationDto.isInCooler(),
                funeralInformationDto.getDateOfBurial(),
                funeralInformationDto.getCemeteryAddress(),
                funeralInformationDto.isInCemetery(),
                null,null,null);
    }
}
