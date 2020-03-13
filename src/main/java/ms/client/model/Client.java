package ms.client.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "client")
public class Client {
	
	@Id
	private String id;
	private String firstName;
	private String lastNamePaternal;
	private String lastNameMaternal;
	
	public Client(String firstName, String lastNamePaternal, String lastNameMaternal) {
		this.firstName = firstName;
		this.lastNamePaternal = lastNamePaternal;
		this.lastNameMaternal = lastNameMaternal;
	}
}
