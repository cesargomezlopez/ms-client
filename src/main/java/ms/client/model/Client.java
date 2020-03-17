package ms.client.model;

import java.sql.Date;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@NoArgsConstructor
@Data
@Document(collection = "client")
public class Client {

  @Id
  private String id;
  @NotEmpty
  private String firstName;
  @NotEmpty
   private String lastNamePaternal;
  @NotEmpty
  private String lastNameMaternal;
  @NotEmpty
  private String email;
  @NotEmpty
  private String phone;
  @NotEmpty
  private String address;
  @NotEmpty
  private String gender;
  @NotEmpty
  private Date bornDate;
  @NotEmpty
  private Date startDate;
  private Date editDate;
  private Date endDate;
  @NotNull
  private Integer clientType;

}
