package velmart.velmart.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VelmartResponseDto {
    private int id;
    private String productName;
    private double cost;
    private int quantity;
    private String discreption;
}
