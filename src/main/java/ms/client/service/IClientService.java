package ms.client.service;

import ms.client.model.Client;
import ms.client.util.ICRUD;
import reactor.core.publisher.Mono;

public interface IClientService extends ICRUD<Client> {
  Mono<Client> findFirstByFirstName(String firstName);
}
