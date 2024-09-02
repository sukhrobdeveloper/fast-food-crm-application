package sukhrob.developer.customer_service.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import sukhrob.developer.customer_service.entities.template.AbsEntity;

import java.util.Set;

@Entity(name = "combo_products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SQLDelete(sql = "update combo_products set deleted=true where id = ?")
@Where(clause = "deleted=false")
public class ComboProduct extends AbsEntity {

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "combos-products", joinColumns = @JoinColumn(name = "combo_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private Set<Product> products;

    private String description;

    private double originalPrice;

    @Column(nullable = false)
    private double currentPrice;

}
