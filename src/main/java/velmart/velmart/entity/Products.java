package velmart.velmart.entity;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Products extends BaseModels {
    private String productName;
    private double cost;
    private int quantity;
    private String discreption;
}
