package ms.client.util;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ICRUD<T> {

  public Flux<T> findAll();

  public Mono<T> findById(String id);

  public Mono<T> save(T t);

  public Mono<Void> deleteById(String id);
  
}
