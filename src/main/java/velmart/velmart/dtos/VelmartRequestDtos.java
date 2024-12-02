package velmart.velmart.dtos;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

@Getter
@Setter
public class VelmartRequestDtos {

    @NotNull
    private String name;
    private double costs;
    private int quantitys;
    private String discreptions;
}
