package sukhrob.developer.customer_service.service;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import sukhrob.developer.customer_service.entities.Category;
import sukhrob.developer.customer_service.payload.category.CategoryReqDTO;
import sukhrob.developer.customer_service.payload.category.CategoryResDTO;
import sukhrob.developer.customer_service.repositories.CategoryRepository;

import java.util.List;
import java.util.UUID;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public ResponseEntity<CategoryResDTO> add(CategoryReqDTO categoryReqDTO) {
        if (categoryRepository.existsByName(categoryReqDTO.getName())) throw new EntityExistsException("Category with this name already exists!");
        Category category = new Category(
                categoryReqDTO.getName(),
                categoryReqDTO.getDescription(),
                categoryReqDTO.getParentId());
        categoryRepository.save(category);
        return ResponseEntity.ok(entityToDTO(category));
    }

    @Override
    public ResponseEntity<CategoryResDTO> edit(CategoryResDTO categoryResDTO, UUID categoryId) {
        if (categoryRepository.existsByNameAndIdNot(categoryResDTO.getName(), categoryId))
            throw new EntityExistsException("Category with this name already exists!");
        Category category = findById(categoryId);
        category.setDescription(categoryResDTO.getDescription());
        category.setName(categoryResDTO.getName());
        category.setParentId(categoryResDTO.getParentId());
        Category savedCategory = categoryRepository.save(category);
        return ResponseEntity.ok(entityToDTO(savedCategory));
    }

    @Override
    public ResponseEntity<CategoryResDTO> viewOne(UUID categoryId) {
        return ResponseEntity.ok(entityToDTO(findById(categoryId)));
    }

    @Override
    public ResponseEntity<List<CategoryResDTO>> viewAll() {
        return ResponseEntity.ok(
                categoryRepository.findAll().stream().map(this::entityToDTO).toList()
        );
    }

    @Override
    public ResponseEntity<?> delete(UUID deleteId) {
        categoryRepository.delete(findById(deleteId));
        return ResponseEntity.ok("Success!");
    }

    private Category findById(UUID id) {
        return categoryRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Category with this id not found!"));
    }

    private CategoryResDTO entityToDTO(Category category) {
        return new CategoryResDTO(category.getName(),
                category.getDescription(),
                category.getParentId());
    }

}
