package sukhrob.developer.customer_service.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import sukhrob.developer.customer_service.payload.category.CategoryReqDTO;
import sukhrob.developer.customer_service.payload.category.CategoryResDTO;
import sukhrob.developer.customer_service.service.CategoryService;

import java.util.List;
import java.util.UUID;

@RestController
public class CategoryControllerImpl implements CategoryController {

    private final CategoryService categoryService;

    public CategoryControllerImpl(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public ResponseEntity<CategoryResDTO> add(CategoryReqDTO categoryReqDTO) {
        return categoryService.add(categoryReqDTO);
    }

    @Override
    public ResponseEntity<CategoryResDTO> edit(CategoryResDTO categoryResDTO, UUID categoryId) {
        return categoryService.edit(categoryResDTO, categoryId);
    }

    @Override
    public ResponseEntity<CategoryResDTO> viewOne(UUID categoryId) {
        return categoryService.viewOne(categoryId);
    }

    @Override
    public ResponseEntity<List<CategoryResDTO>> viewAll() {
        return categoryService.viewAll();
    }

    @Override
    public ResponseEntity<?> delete(UUID deleteId) {
        return categoryService.delete(deleteId);
    }


}
