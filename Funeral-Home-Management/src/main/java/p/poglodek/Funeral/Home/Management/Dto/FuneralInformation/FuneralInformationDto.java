package p.poglodek.Funeral.Home.Management.Dto.FuneralInformation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import p.poglodek.Funeral.Home.Management.Database.Entity.Client;

import javax.persistence.OneToOne;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FuneralInformationDto {
    private Long id;
    private String clientName;
    private String bodyCoolerNumber;
    private boolean isInCooler;
    private Date dateOfBurial;
    private String cemeteryAddress;
    private boolean isInCemetery;
}
