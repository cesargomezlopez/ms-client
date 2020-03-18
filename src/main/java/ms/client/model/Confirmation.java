package ms.client.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Confirmation<T> {
  private Integer status;
  private String message;
  private T model;

}
