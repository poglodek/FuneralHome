package p.poglodek.Funeral.Home.Management.Services;


import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import p.poglodek.Funeral.Home.Management.Database.Entity.FuneralInformation;
import p.poglodek.Funeral.Home.Management.Database.Repository.*;
import p.poglodek.Funeral.Home.Management.Dto.FuneralInformation.FuneralInformationCreateDto;
import p.poglodek.Funeral.Home.Management.Dto.FuneralInformation.FuneralInformationDto;
import p.poglodek.Funeral.Home.Management.Enum.CrudEnum;
import p.poglodek.Funeral.Home.Management.Mappers.ClientMapper;
import p.poglodek.Funeral.Home.Management.Mappers.FuneralInformationMapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Service
public class FuneralInformationServices {

    private FuneralInformationMapper funeralInformationMapper;
    private FuneralInformationRepository funeralInformationRepository;
    private UserRepository userRepository;
    private ClientRepository clientRepository;
    private FlowerRepository flowerRepository;
    private BurialTypeRepository burialTypeRepository;

    public List<FuneralInformationDto> getFuneralInformationList(){

        return funeralInformationMapper.mapListToDtoList(funeralInformationRepository.findByCreatedBy(userRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName()).get()));
    }

    @SneakyThrows
    public CrudEnum addFuneralInformation(FuneralInformationCreateDto funeralInformationCreateDto) {
        var valid = isValidFuneralInformation(funeralInformationCreateDto);
        if(valid != CrudEnum.VALID)
            return valid;
        FuneralInformation funeralInformation = funeralInformationMapper.mapToModel(funeralInformationCreateDto);
        funeralInformation.setClient(clientRepository.findById((long) funeralInformationCreateDto.getClientId()).get());
        funeralInformation.setFlowerType(flowerRepository.findById((long) funeralInformationCreateDto.getFlowerTypeId()).get());
        funeralInformation.setBurialType(burialTypeRepository.findById((long) funeralInformationCreateDto.getBurialTypeId()).get());
        funeralInformation.setCreatedBy(userRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName()).get());
        funeralInformationRepository.save(funeralInformation);
        return CrudEnum.CREATED;
    }
    public CrudEnum isValidFuneralInformation(FuneralInformationCreateDto funeralInformationDto) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date maxDate = simpleDateFormat.parse("31-12-2099");
        if (funeralInformationDto.getDateOfBurial().before(Calendar.getInstance().getTime()) || funeralInformationDto.getDateOfBurial().after(maxDate))
            return CrudEnum.INVALID_DATE;
        return CrudEnum.VALID;
    }
}
