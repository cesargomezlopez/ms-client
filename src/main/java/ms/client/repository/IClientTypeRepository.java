package ms.client.repository;

import ms.client.model.ClientType;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClientTypeRepository extends ReactiveMongoRepository<ClientType, String> {

}
