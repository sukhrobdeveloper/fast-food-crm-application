package sukhrob.developer.security_service.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RefreshToken {

    @Id
    private String id;

    @DocumentReference(lazy = true)
    private User owner;

}
