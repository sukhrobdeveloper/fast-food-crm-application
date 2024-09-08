package sukhrob.developer.customer_service.entities.order;

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
@Setter
@Getter
@SQLDelete(sql = "update box set deleted=true where id = ?")
@Where(clause = "deleted=false")
@Entity(name = "box")
public class Box extends AbsEntity {

    /*

    Box class is pre order class so customer can customize

     */

    @Column(name = "user_id")
    private String userId;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BoxProduct> boxProducts;

    private double price;

    private String tempUserId;

}
