package sukhrob.developer.customer_service.service;

import org.springframework.http.ResponseEntity;
import sukhrob.developer.customer_service.payload.category.CategoryReqDTO;
import sukhrob.developer.customer_service.payload.category.CategoryResDTO;

import java.util.List;
import java.util.UUID;

public interface CategoryService {

    ResponseEntity<CategoryResDTO> add(CategoryReqDTO categoryReqDTO);

    ResponseEntity<CategoryResDTO> edit(CategoryResDTO categoryResDTO, UUID categoryId);

    ResponseEntity<CategoryResDTO> viewOne(UUID categoryId);

    ResponseEntity<List<CategoryResDTO>> viewAll();

    ResponseEntity<?> delete(UUID deleteId);
}
