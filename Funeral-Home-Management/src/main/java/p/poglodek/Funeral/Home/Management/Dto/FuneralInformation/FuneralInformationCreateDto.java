package p.poglodek.Funeral.Home.Management.Dto.FuneralInformation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import p.poglodek.Funeral.Home.Management.Database.Entity.BurialType;
import p.poglodek.Funeral.Home.Management.Database.Entity.Client;
import p.poglodek.Funeral.Home.Management.Database.Entity.FlowerType;
import p.poglodek.Funeral.Home.Management.Database.Entity.User;

import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FuneralInformationCreateDto {
    private int clientId;
    private String bodyCoolerNumber;
    private boolean isInCooler;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOfBurial;
    private String cemeteryAddress;
    private boolean isInCemetery;
    private int flowerTypeId;
    private int burialTypeId;
}
