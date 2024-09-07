package sukhrob.developer.customer_service.entities.order;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import sukhrob.developer.customer_service.entities.template.AbsEntity;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SQLDelete(sql = "update box_products set deleted=true where id=?")
@Where(clause = "deleted=false")
@Entity(name = "box_products")
public class BoxProduct extends AbsEntity {

    // box element

}
