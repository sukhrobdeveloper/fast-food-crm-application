package sukhrob.developer.customer_service.entities.order;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import sukhrob.developer.customer_service.entities.products.Product;
import sukhrob.developer.customer_service.entities.template.AbsEntity;

@Entity(name = "product_sales")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SQLDelete(sql = "update product_sales set deleted=true where id = ?")
@Where(clause = "deleted=false")
public class ProductSale extends AbsEntity {

    // SALE for products

}
