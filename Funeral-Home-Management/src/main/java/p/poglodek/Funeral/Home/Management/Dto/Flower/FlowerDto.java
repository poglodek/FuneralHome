package p.poglodek.Funeral.Home.Management.Dto.Flower;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FlowerDto {
    private Long id;
    private String name;
    private String type;
    private String description;
    private double price;
}
