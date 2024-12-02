package velmart.velmart.mappers;

import velmart.velmart.dtos.VelmartResponseDto;
import velmart.velmart.entity.Products;

public class Mapper {
    public static VelmartResponseDto fromEntity(Products products){
        VelmartResponseDto responseDto=new VelmartResponseDto();
        responseDto.setId(products.getId());
        responseDto.setProductName(products.getProductName());
        responseDto.setCost(products.getCost());
        responseDto.setQuantity(products.getQuantity());
        responseDto.setDiscreption(products.getDiscreption());
        return responseDto;
    }
}
