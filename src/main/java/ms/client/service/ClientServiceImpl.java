package ms.client.service;

import ms.client.model.Client;
import ms.client.repository.IClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ClientServiceImpl implements IClientService {

  @Autowired
  private IClientRepository clientRepository;

  @Override
  public Flux<Client> findAll() {
    return clientRepository.findAll();
  }

  @Override
  public Mono<Client> findById(String id) {
    return clientRepository.findById(id);
  }

  @Override
  public Mono<Client> save(Client cliente) {
    return clientRepository.save(cliente);
  }

  @Override
  public Mono<Void> deleteById(String id) {
    return clientRepository.deleteById(id);
  }

  @Override
  public Mono<Client> findFirstByFirstName(String firstName) {
    return clientRepository.findFirstByFirstName(firstName);
  }

}
