package sukhrob.developer.customer_service.payload.category;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryReqDTO {

    @NotNull(message = "Please enter the name!")
    private String name;

    private String description;

    private UUID parentId;

}
