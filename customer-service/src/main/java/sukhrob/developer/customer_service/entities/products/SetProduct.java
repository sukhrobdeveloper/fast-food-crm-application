package sukhrob.developer.customer_service.entities.products;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
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
@SQLDelete(sql = "update set_products set deleted=true where id = ?")
@Where(clause = "deleted=false")
@Entity(name = "set_products")
public class SetProduct extends AbsEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "product", nullable = false)
    private Product product;

    private int count = 1;

    private double price;

    private void setPrice() {
        this.price = this.product.getPrice() * count;
    }

    private double getPrice() {
        return this.price == 0d ? product.getPrice() : this.price;
    }

}
