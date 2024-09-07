package sukhrob.developer.customer_service.entities.products;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import sukhrob.developer.customer_service.entities.template.AbsEntity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "ingredients")
@SQLDelete(sql = "update ingredients set deleted=true where id = ?")
@Where(clause = "deleted=false")
public class Ingredient extends AbsEntity {

    @Column(nullable = false, unique = true)
    private String name;

}
