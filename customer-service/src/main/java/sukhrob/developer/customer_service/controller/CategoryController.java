package sukhrob.developer.customer_service.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sukhrob.developer.customer_service.payload.category.CategoryReqDTO;
import sukhrob.developer.customer_service.payload.category.CategoryResDTO;
import sukhrob.developer.customer_service.utils.AppConstant;

import java.util.List;
import java.util.UUID;

@RequestMapping(AppConstant.CATEGORY_CONTROLLER)
public interface CategoryController {

    @PostMapping(AppConstant.ADD)
    ResponseEntity<CategoryResDTO> add(@RequestBody CategoryReqDTO categoryReqDTO);

    @PutMapping(AppConstant.EDIT + "{id}")
    ResponseEntity<CategoryResDTO> edit(@RequestBody CategoryResDTO categoryResDTO, @PathVariable(name = "id") UUID categoryId);

    @GetMapping(AppConstant.VIEW + "{id}")
    ResponseEntity<CategoryResDTO> viewOne(@PathVariable(name = "id") UUID categoryId);

    @GetMapping(AppConstant.VIEW_ALL)
    ResponseEntity<List<CategoryResDTO>> viewAll();

    @DeleteMapping(AppConstant.DELETE + "{id}")
    ResponseEntity<?> delete(@PathVariable(name = "id") UUID deleteId);

}

