package p.poglodek.Funeral.Home.Management.Dto.burialType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class burialTypeDto {
    private String name;
    private String type;
    private String description;
    private double price;
}
