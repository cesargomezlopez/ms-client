package ms.client.model;

import javax.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document(collection = "clientType")
public class ClientType {

  @Id
  @Generated
  private String id;
  @NotEmpty(message = "Description can not be empty")
  private String description;

}
