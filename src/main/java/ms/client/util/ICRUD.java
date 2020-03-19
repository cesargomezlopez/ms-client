package ms.client.util;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ICRUD<T> {

  public Flux<T> findAll();

  public Mono<T> findById(String id);

  public Mono<T> create(T t);
  
  public Mono<T> update(T t);

  public Mono<Void> deleteById(String id);
  
}
