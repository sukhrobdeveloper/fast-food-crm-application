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
@SQLDelete(sql = "update sets set deleted=true where id = ?")
@Where(clause = "deleted=false")
public class Sets extends AbsEntity {

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "sets_product_set", joinColumns = @JoinColumn(name = "set_id"),
                inverseJoinColumns = @JoinColumn(name = "set_product_id"))
    private List<SetProduct> setProducts;

    @Column(nullable = false)
    private String description;

    private double originalPrice;

    @Column(nullable = false)
    private double price;

}
