package p.poglodek.Funeral.Home.Management.Mappers;

import org.junit.jupiter.api.Test;
import p.poglodek.Funeral.Home.Management.Database.Entity.Client;
import p.poglodek.Funeral.Home.Management.Database.Entity.FuneralInformation;
import p.poglodek.Funeral.Home.Management.Dto.FuneralInformation.FuneralInformationDto;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class FuneralInformationMapperTest {

    @Test
    void mapToDto_CorrectModel_ShouldReturnDtoOfModel() {
        Date date = Calendar.getInstance().getTime();
        FuneralInformationMapper funeralInformationMapper = new FuneralInformationMapper();
        Client client = new Client(0L,"First","Last","email@email.com",123123123,null,null);
        FuneralInformation funeralInformation = new FuneralInformation(
                0L,
                client,
                "0",
                false,
                date,
                "address",
                true,null,null,null
                );
        FuneralInformationDto funeralInformationDto = new FuneralInformationDto(
                0L,
                "First Last",
                "0",
                false,
                date,
                "address",
                true);
        var result = funeralInformationMapper.mapToDto(funeralInformation);
        assertEquals(result.getBodyCoolerNumber(), funeralInformationDto.getBodyCoolerNumber());
        assertEquals(result.getCemeteryAddress(), funeralInformationDto.getCemeteryAddress());
        assertEquals(result.getClientName(), funeralInformationDto.getClientName());
        assertEquals(result.getId(), funeralInformationDto.getId());
        assertEquals(result.getDateOfBurial(), funeralInformationDto.getDateOfBurial());
    }
}