package velmart.velmart.expetions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExpentionsResponseDto {
public String message;
private int code;

    public ExpentionsResponseDto(String message, int code) {
        this.message = message;
        this.code = code;
    }
}
