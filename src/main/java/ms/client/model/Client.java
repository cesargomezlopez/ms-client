package ms.client.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@Data
@Document(collection = "client")
public class Client {

  @Id
  @Generated
  private String id;

  @NotEmpty(message = "First name can not be empty")
  private String firstName;

  @NotEmpty(message = "Last name paternal can not be empty")
  private String lastNamePaternal;

  private String lastNameMaternal;

  @NotEmpty(message = "Email can not be empty")
  @Email(message = "Enter valid email")
  private String email;

  @NotEmpty(message = "Phone number can not be empty")
  private String phoneNumber;

  @NotEmpty(message = "Address can not be empty")
  private String address;

  @NotEmpty(message = "City can not be empty")
  private String city;

  private String gender;

  @JsonFormat(pattern = "yyyy-MM-dd")
  private Date bornDate;

  @JsonFormat(pattern = "yyyy-MM-dd")
  private Date startDate;

  @JsonFormat(pattern = "yyyy-MM-dd")
  private Date editDate;

  @JsonFormat(pattern = "yyyy-MM-dd")
  private Date endDate;

  @NotNull(message = "Client type can not be null")
  private Integer clientType;

}
