package p.poglodek.Funeral.Home.Management.Database.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;


import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FuneralInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Client client;
    private String bodyCoolerNumber;
    private boolean isInCooler;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private Date dateOfBurial;
    private String cemeteryAddress;
    private boolean isInCemetery;
    @ManyToOne
    private FlowerType flowerType;
    @ManyToOne
    private BurialType burialType;
    @ManyToOne
    private User createdBy;
}
