package ms.client.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@Data
@Document(collection = "client")
public class Client {

  @Id
  @Generated
  private String id;

  @NotEmpty(message = "Client code can not be empty")
  private String code;

  @NotEmpty(message = "Client name can not be empty")
  private String name;

  private String lastNamePaternal;

  private String lastNameMaternal;

  @NotEmpty(message = "Document number can not be empty")
  private String documentNumber;

  @NotEmpty(message = "Phone number can not be empty")
  private String phoneNumber;

  @NotEmpty(message = "Email can not be empty")
  @Email(message = "Enter valid email")
  private String email;

  @NotEmpty(message = "Address can not be empty")
  private String address;

  @NotEmpty(message = "City can not be empty")
  private String city;

  @JsonFormat(pattern = "yyyy-MM-dd")
  private Date startDate;

  @Valid
  @DBRef
  private ClientType clientType;

}
