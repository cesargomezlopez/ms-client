package ms.client.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import ms.client.model.Client;

public interface IClientRepository extends MongoRepository<Client, String>{
	Client findFirstByFirstName(String firstName);
}
