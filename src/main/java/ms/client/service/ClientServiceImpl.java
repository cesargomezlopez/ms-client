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
    return clientRepository.findById(id)
      .switchIfEmpty(Mono.empty());
  }
  
  @Override
  public Mono<Client> findFirstByName(String firstName) {
    return clientRepository.findFirstByName(firstName)
      .switchIfEmpty(Mono.empty());
  }
  
  @Override
  public Mono<Void> deleteById(String id) {
    return clientRepository.findById(id).flatMap(client -> {
      return clientRepository.delete(client);
    }).switchIfEmpty(Mono.empty());
  }

  @Override
  public Mono<Client> create(Client entity) {
    return clientRepository.save(entity)
      .switchIfEmpty(Mono.empty());
  }
  
  @Override
  public Mono<Client> update(Client entity) {
    return clientRepository.findById(entity.getId())
      .flatMap(cl -> {
        return clientRepository.save(entity);
      }).switchIfEmpty(Mono.empty());
  }

}
