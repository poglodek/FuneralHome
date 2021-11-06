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
    public String name;
    public String type;
    public String description;
    public double price;
}
