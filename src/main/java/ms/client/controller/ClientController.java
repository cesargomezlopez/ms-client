package ms.client.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.validation.Valid;
import ms.client.model.Client;
import ms.client.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/client")
@Api(value = "client")
public class ClientController {

  @Autowired
  private IClientService clientService;

  /**
   * Find all clients.
   * 
   * @return A list of registered clients if they exist, empty if there are not registered clients.
   */
  @GetMapping(value = "/findAllClients", produces = MediaType.APPLICATION_JSON_VALUE)
  @ApiOperation(value = "Find all clients", notes = "Find all clients registered")
  public Mono<ResponseEntity<Flux<Client>>> findAllClients() {
    return Mono.just(ResponseEntity
      .ok()
      .contentType(MediaType.APPLICATION_JSON)
      .body(clientService.findAll()));
  }

  /**
   * Gets a client by its id.
   * 
   * @param id client
   * @return Client data if it exists, empty if does not exist.
   */
  @GetMapping(value = "/findClientById", produces = MediaType.APPLICATION_JSON_VALUE)
  @ApiOperation(value = "Find client by id", notes = "Fin client registered by id")
  public Mono<ResponseEntity<Client>> findClientById(@RequestParam("id")String id) {
    return clientService.findById(id).flatMap(c -> {
      return Mono.just(ResponseEntity.ok()
        .contentType(MediaType.APPLICATION_JSON)
        .body(c));
    }).defaultIfEmpty(ResponseEntity.notFound().build());
  }

  /**
   * Find client by its name.
   * 
   * @param name client name
   * @return Client data if it exists, empty if does not exist registered client with that name.
   */
  @GetMapping(value = "/findClientByName", produces = MediaType.APPLICATION_JSON_VALUE)
  @ApiOperation(value = "Find client by name", notes = "Find client registered by name", 
      response = Client.class)
  public Mono<ResponseEntity<Client>> findClientByName(@RequestParam("name")String name) {
    return clientService.findFirstByName(name).flatMap(c -> {
      return Mono.just(ResponseEntity
        .ok()
        .contentType(MediaType.APPLICATION_JSON)
        .body(c));
    }).defaultIfEmpty(ResponseEntity.notFound().build());
  }

  /**
   * Delete client by its id.
   * 
   * @param id client
   * @return Client delete action.
   */
  @DeleteMapping(value = "/deleteClientById", produces = MediaType.APPLICATION_JSON_VALUE)
  @ApiOperation(value = "Delete client by id", notes = "Delete client registered by id")
  public Mono<ResponseEntity<Void>> deleteClientById(@RequestParam("id")String id) {
    return clientService.deleteById(id)
      .then(Mono.just(new ResponseEntity<Void>(HttpStatus.NO_CONTENT)))
      .defaultIfEmpty(ResponseEntity.notFound().build());
  }

  /**
   * Create a client.
   * 
   * @param client JSON with client data.
   * @return The new client registered including its generated id.
   */
  @PostMapping(value = "/createClient", produces = MediaType.APPLICATION_JSON_VALUE,
      consumes = MediaType.APPLICATION_JSON_VALUE)
  @ApiOperation(value = "Create a client", notes = "Add a new client",
      response = ResponseEntity.class)
  public Mono<ResponseEntity<Client>> createClient(@Valid @RequestBody Client client) {
    return clientService.create(client)
              .flatMap(c -> {
                return Mono.just(ResponseEntity.ok()
                      .contentType(MediaType.APPLICATION_JSON)
                      .body(c));
              }).defaultIfEmpty(ResponseEntity.notFound().build());
  }

  /**
   * Update a client.
   * 
   * @param client JSON with client data, including its id to verify the client exists.
   * @return The client updated if the id as parameter exists,
   *     message warning if do not exist registered client with that id.
   */
  @PutMapping(value = "/updateClient", produces = MediaType.APPLICATION_JSON_VALUE,
      consumes = MediaType.APPLICATION_JSON_VALUE)
  @ApiOperation(value = "Update a client", notes = "Update a client registered", 
      response = Client.class)
  public Mono<ResponseEntity<Client>> updateClient(@Valid @RequestBody Client client) {
    return clientService.update(client)
              .flatMap(c -> {
                return Mono.just(ResponseEntity
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(c));
              })
              .defaultIfEmpty(ResponseEntity.notFound().build());
  }

}
