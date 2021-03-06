package ms.client.model;

import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(collection = "clientType")
public class ClientType {

  @Id
  @Generated
  private String id;

  @NotEmpty(message = "Client type code can not be empty")
  private String code;

  @NotEmpty(message = "Client type description can not be empty")
  private String description;

}
