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
@Setter
@Getter
@SQLDelete(sql = "update box set deleted=true where id = ?")
@Where(clause = "deleted=false")
@Entity(name = "box")
public class Box extends AbsEntity {

    /*

    Box class is pre order class so customer can customize

     */

}
