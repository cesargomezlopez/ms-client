package ms.client.service;

import ms.client.model.Client;
import ms.client.util.ICrud;
import reactor.core.publisher.Mono;

public interface IClientService extends ICrud<Client,String> {

  Mono<Client> findFirstByName(String firstName);

}
