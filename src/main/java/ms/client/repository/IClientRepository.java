package ms.client.repository;

import ms.client.model.Client;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface IClientRepository extends ReactiveMongoRepository<Client, String> {
  Mono<Client> findFirstByName(String firstName);
}
