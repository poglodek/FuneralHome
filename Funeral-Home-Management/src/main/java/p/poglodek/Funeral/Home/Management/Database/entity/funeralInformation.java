package p.poglodek.Funeral.Home.Management.Database.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class funeralInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @OneToOne
    public client client;
    public String bodyCoolerNumber;
    public boolean isInCooler;
    public Date dateOfBurial;
    public String cemeteryAddress;
    public boolean isInCemetery;
    @OneToOne
    public burialType wayOfBurial;
}
