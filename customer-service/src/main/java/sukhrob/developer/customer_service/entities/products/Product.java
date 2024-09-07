package sukhrob.developer.customer_service.entities.products;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import sukhrob.developer.customer_service.entities.template.AbsEntity;

import java.util.Set;

@Entity(name = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SQLDelete(sql = "update products set deleted=true where id = ?")
@Where(clause = "deleted=false")
public class Product extends AbsEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;

    @Column(unique = true, nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String description;

    @Column(nullable = false)
    private double price;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "products_items", joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id"))
    private Set<IngredientItem> ingredientItems;

}
