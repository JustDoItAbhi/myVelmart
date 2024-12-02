package velmart.velmart.expetions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductExpentionsHandlings {
@ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ExpentionsResponseDto> getException(ProductNotFoundException e){
    ExpentionsResponseDto responseDto=new ExpentionsResponseDto(
            e.getMessage(),
            404
    );
    return new ResponseEntity<>(responseDto, HttpStatus.NOT_FOUND);
}
    @ExceptionHandler(PriceIncreaseException.class)
    public ResponseEntity<ExpentionsResponseDto> price(PriceIncreaseException e){
        ExpentionsResponseDto responseDto=new ExpentionsResponseDto(
                e.getMessage(),
                409
        );
        return new ResponseEntity<>(responseDto, HttpStatus.CONFLICT);
    }
}
