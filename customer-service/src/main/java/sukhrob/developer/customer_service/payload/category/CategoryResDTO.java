package sukhrob.developer.customer_service.payload.category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryResDTO {

    private String name;

    private String description;

    private UUID parentId;

}
