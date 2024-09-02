package sukhrob.developer.customer_service.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import sukhrob.developer.customer_service.entities.template.AbsEntity;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "categories")
@SQLDelete(sql = "update categories set deletet=true where id=?")
@Where(clause = "deleted=false")
public class Category extends AbsEntity {

    @Column(unique = true, nullable = false)
    private String name;

    private String description;

    private UUID parentId;

}
