package p.poglodek.Funeral.Home.Management.Dto.FuneralInformation;


import lombok.*;
import lombok.experimental.SuperBuilder;
import net.bytebuddy.implementation.bind.annotation.Super;

import java.util.Date;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FuneralInformationInfoDto extends FuneralInformationDto {
    private String flower;
    private String burialType;

    public FuneralInformationInfoDto(Long id, String clientName, String bodyCoolerNumber, boolean inCooler, Date dateOfBurial, String cemeteryAddress, boolean inCemetery) {
        super(id,clientName,bodyCoolerNumber,inCooler,dateOfBurial,cemeteryAddress,inCemetery);
    }
}
