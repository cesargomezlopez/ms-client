package ms.client.service;

import ms.client.model.ClientType;
import ms.client.repository.IClientTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ClientTypeServiceImpl implements IClientTypeService {

  @Autowired
  private IClientTypeRepository clientTypeRepository;

  @Override
  public Flux<ClientType> findAll() {
    return clientTypeRepository.findAll();
  }

  @Override
  public Mono<ClientType> findById(String id) {
    return clientTypeRepository.findById(id)
      .switchIfEmpty(Mono.empty());
  }

  @Override
  public Mono<ClientType> create(ClientType entity) {
    return clientTypeRepository.save(entity)
      .switchIfEmpty(Mono.empty());
  }

  @Override
  public Mono<ClientType> update(ClientType entity) {
    return clientTypeRepository.findById(entity.getId()).flatMap(ct -> {
      return clientTypeRepository.save(entity);
    })
    .switchIfEmpty(Mono.empty());
  }

  @Override
  public Mono<Void> deleteById(String id) {
    return clientTypeRepository.findById(id).flatMap(ct -> {
      return clientTypeRepository.delete(ct);
    }).switchIfEmpty(Mono.empty());
  }

}
