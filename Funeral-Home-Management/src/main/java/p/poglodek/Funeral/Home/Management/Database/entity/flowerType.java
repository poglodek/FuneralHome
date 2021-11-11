package p.poglodek.Funeral.Home.Management.Database.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class flowerType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String name;
    public String type;
    public String description;
    public double price;
    @OneToOne
    public user user;
    @OneToMany
    public List<funeralInformation> funeralInformationList;
}
