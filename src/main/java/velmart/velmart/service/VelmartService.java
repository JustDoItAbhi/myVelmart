package velmart.velmart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import velmart.velmart.dtos.VelmartRequestDtos;
import velmart.velmart.dtos.VelmartResponseDto;
import velmart.velmart.entity.Products;
import velmart.velmart.expetions.PriceIncreaseException;
import velmart.velmart.expetions.ProductNotFoundException;
import velmart.velmart.mappers.Mapper;
import velmart.velmart.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VelmartService implements IVelmartService {
@Autowired
    private ProductRepository productRepository;

    @Override
    public VelmartResponseDto createProduct(VelmartRequestDtos dtos) {
        Optional<Products> products=productRepository.findByProductName(dtos.getName());
   if(products.isPresent()){
       throw new ProductNotFoundException(" PRODCUT ALREADY EXISTS :: "+ dtos.getName());
   }
   Products products1=new Products();
   products1.setProductName(dtos.getName());
   products1.setDiscreption(dtos.getDiscreptions());
   products1.setCost(dtos.getCosts());
   products1.setQuantity(dtos.getQuantitys());
   products1.setDiscreption(dtos.getDiscreptions());
    productRepository.save(products1);
        return Mapper.fromEntity(products1);
    }

    @Override
    public List<VelmartResponseDto> getAllProduct() {
      List<Products>products=productRepository.findAll();
      List<VelmartResponseDto>responseDtos=new ArrayList<>();
      for(Products p:products) {
          responseDtos.add(Mapper.fromEntity(p));
      }
        return responseDtos;
    }

    @Override
    public VelmartResponseDto getById(int id) {
        Products products= productRepository.findById(id).orElseThrow(
                ()-> new ProductNotFoundException("PRODUCT NOT FOUND ::"+ id));
        return Mapper.fromEntity(products);
    }

    @Override
    public VelmartResponseDto getByProductName(String name) {
        Optional<Products>products=productRepository.findByProductName(name);
        if(products.isEmpty()){
            throw new ProductNotFoundException("PRODUCT NOT FOUND "+name);
        }
        Products products1=products.get();
        return Mapper.fromEntity(products1);
    }

    @Override
    public Boolean deleteProduct(String name) {
        Optional<Products> products=productRepository.findByProductName(name);
        if (products.isEmpty()){
            Products products1=products.get();
            productRepository.findById(products1.getId());
        }
        return true;
    }
    @Override
    public Boolean deleteById(int  id) {
       productRepository.deleteById(id);
        return true;
    }

    @Override
    public double compareCost(VelmartRequestDtos dto) {
       Optional<Products>exitingProducts=productRepository.findByProductName(dto.getName());
       if (exitingProducts.isEmpty()){
           throw new ProductNotFoundException("PRODUCT NOT FOUND :: "+ dto.getName());
       }
       Products products1=exitingProducts.get();
       double sum=0;
       if(dto.getCosts()<0){
               throw new PriceIncreaseException("PRICE INCREASED "+products1.getProductName());

       }else if(dto.getCosts()>products1.getCost()) {
           double costDifference = dto.getCosts() - products1.getCost();
           throw new PriceIncreaseException(
                   "PRICE INCREASED: " +products1.getProductName() +
                           " by " + costDifference
           );
       }
        return products1.getCost();
    }
}
