package sukhrob.developer.customer_service.entities.order;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import sukhrob.developer.customer_service.entities.template.AbsEntity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "orders")
@SQLDelete(sql = "update orders set deleted=true where id = ?")
@Where(clause = "deleted=true")
public class Order extends AbsEntity {

    @Column(nullable = false)
    private String userId;

    @OneToOne(fetch = FetchType.LAZY)
    @Column(nullable = false)
    private Box box;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sale_id")
    private Sale sale;

    @Enumerated(value = EnumType.STRING)
    private OrderType orderType;

    @Enumerated(value = EnumType.STRING)
    private PaymentType paymentType;

    private String address;

    private double originalPrice;

    private double deliveryPrice;

    private double overallPrice;

}
