package sukhrob.developer.customer_service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sukhrob.developer.customer_service.entities.products.Category;
import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, UUID> {

    boolean existsByName(String name);
    boolean existsByNameAndIdNot(String name, UUID id);

}
