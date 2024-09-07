package sukhrob.developer.customer_service.entities.products;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import sukhrob.developer.customer_service.entities.template.AbsEntity;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SQLDelete(sql = "update combo_products set deleted=true where id = ?")
@Where(clause = "deleted=false")
@Entity(name = "combo_products")
public class Combo extends AbsEntity {

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "combos_products", joinColumns = @JoinColumn(name = "combo_id"),
                inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> products;

    private String description;

    private double originalPrice;

    private double currentPrice;

}
