package ms.client.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Confirmation {
	private Integer state;
	private String message;
	private String id;
	
}
