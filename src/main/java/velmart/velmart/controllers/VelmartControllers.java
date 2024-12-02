package velmart.velmart.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import velmart.velmart.dtos.VelmartRequestDtos;
import velmart.velmart.dtos.VelmartResponseDto;
import velmart.velmart.service.IVelmartService;

import java.util.List;

@RestController
@RequestMapping("/velmart")
public class VelmartControllers {
    @Autowired
    private IVelmartService velmartService;
    @PostMapping("/create")
    @CrossOrigin(origins = "http://localhost:63342")
    public ResponseEntity<VelmartResponseDto> create ( @RequestBody VelmartRequestDtos dtos){
        return ResponseEntity.ok(velmartService.createProduct(dtos));
    }
    @GetMapping("/")
    public ResponseEntity<List<VelmartResponseDto>>getAll(){
        return ResponseEntity.ok(velmartService.getAllProduct());
    }
    @GetMapping("/by-name/{name}")
    public ResponseEntity<VelmartResponseDto> getByName(@PathVariable("name")String name){
        return ResponseEntity.ok(velmartService.getByProductName(name));
    }
    @GetMapping("/by-id/{id}")
public ResponseEntity<VelmartResponseDto> getByid(@PathVariable("id") int id){
        return ResponseEntity.ok(velmartService.getById(id));
    }
    @PostMapping("/compare-cost")
    public ResponseEntity<String> compareCost(@RequestBody VelmartRequestDtos dtos){
        VelmartResponseDto responseDto=new VelmartResponseDto();
        if(dtos.getCosts()== responseDto.getCost()){
            return ResponseEntity.ok(" SAME OLD PRICE NOT CHANGE");
        }
        double costDifference= velmartService.compareCost(dtos);
    return ResponseEntity.ok("cost difference is ::"+costDifference );
    }
    @DeleteMapping("/{name}")
    public ResponseEntity<Boolean> deleteByName(@PathVariable ("name")String name){
        return ResponseEntity.ok(velmartService.deleteProduct(name));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteByName(@PathVariable ("id")int id){
        return ResponseEntity.ok(velmartService.deleteById(id));
    }

}
