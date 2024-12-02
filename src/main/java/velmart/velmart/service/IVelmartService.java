package velmart.velmart.service;

import velmart.velmart.dtos.VelmartRequestDtos;
import velmart.velmart.dtos.VelmartResponseDto;

import java.util.List;

public interface IVelmartService {
    VelmartResponseDto createProduct(VelmartRequestDtos dtos);
    List<VelmartResponseDto> getAllProduct();
    VelmartResponseDto getById(int id);
    VelmartResponseDto getByProductName(String name);
    Boolean deleteProduct(String name);
    double compareCost(VelmartRequestDtos dto);
    Boolean deleteById(int  id);
}
