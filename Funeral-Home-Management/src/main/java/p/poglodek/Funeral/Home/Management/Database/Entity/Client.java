package p.poglodek.Funeral.Home.Management.Database.Entity;

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
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private int phone;
    @ManyToOne
    @JoinColumn(nullable = true)
    private User createdBy;
    @OneToOne
    private FuneralInformation funeralInformation;

}
