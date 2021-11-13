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
    private Long id;
    @OneToOne
    private client client;
    private String bodyCoolerNumber;
    private boolean isInCooler;
    private Date dateOfBurial;
    private String cemeteryAddress;
    private boolean isInCemetery;
    @OneToOne
    private burialType wayOfBurial;
    @ManyToOne
    private  flowerType flowerType;
    @ManyToOne
    private  burialType burialType;
}
