package p.poglodek.Funeral.Home.Management.Database.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String firstName;
    public String lastName;
    public String email;
    public String password;
    @ManyToOne
    @JoinColumn(nullable = true)
    public user createdBy;
    @OneToOne
    public  funeralInformation funeralInformation;
    @OneToOne
    public  flowerType flowerType;
}
