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

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "ingredient_items")
@SQLDelete(sql = "update ingredient_items set deleted=true where id = ?")
@Where(clause = "deleted=false")
public class IngredientItem extends AbsEntity {

    @Column(unique = true, nullable = false)
    private String name;

    @JoinTable(name = "ingredients_items", joinColumns = @JoinColumn(name = "item_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id"))
    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Ingredient> ingredients;

}
