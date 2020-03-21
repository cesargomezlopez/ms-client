package ms.client.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.validation.Valid;
import ms.client.model.ClientType;
import ms.client.service.IClientTypeService;
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
@RequestMapping("/clientType")
@Api(value = "clientType")
public class ClientTypeController {

  @Autowired
  private IClientTypeService clientTypeService;

  @GetMapping(value="/findAllClientsType", produces = MediaType.APPLICATION_JSON_VALUE)
  @ApiOperation(value = "Get all client types", notes = "Get all client types registered")
  public Mono<ResponseEntity<Flux<ClientType>>> findAllClientTypes(){
    return Mono.just(ResponseEntity
      .ok()
      .contentType(MediaType.APPLICATION_JSON)
      .body(clientTypeService.findAll()));
  }

  @GetMapping(value = "/findClientTypeById", produces = MediaType.APPLICATION_JSON_VALUE)
  @ApiOperation(value = "Find client type by id", notes = "Find client type registered by id")
  public Mono<ResponseEntity<ClientType>> findClientTypeById(@RequestParam("id")String id) {
    return clientTypeService.findById(id).flatMap(ct -> {
      return Mono.just(ResponseEntity
          .ok()
          .contentType(MediaType.APPLICATION_JSON)
          .body(ct));
    }).defaultIfEmpty(ResponseEntity.notFound().build());
  }

  @PostMapping(value = "/createClientType", produces = MediaType.APPLICATION_JSON_VALUE)
  @ApiOperation(value = "Create a new client type", notes = "Register a new client type")
  public Mono<ResponseEntity<ClientType>> createClientType(
      @Valid @RequestBody ClientType clientType) {
    return clientTypeService.create(clientType).flatMap(ct -> {
      return Mono.just(ResponseEntity
        .ok()
        .contentType(MediaType.APPLICATION_JSON)
        .body(ct));
    }).defaultIfEmpty(ResponseEntity.notFound().build());
  }

  @PutMapping(value = "/updateClientType", produces = MediaType.APPLICATION_JSON_VALUE)
  @ApiOperation(value = "Update a client type", notes = "Update a client type registered")
  public Mono<ResponseEntity<ClientType>> updateClientType(
      @Valid @RequestBody ClientType clientType) {
    return clientTypeService.update(clientType).flatMap(ct -> {
      return Mono.just(ResponseEntity
        .ok()
        .contentType(MediaType.APPLICATION_JSON)
        .body(ct));
    }).defaultIfEmpty(ResponseEntity.notFound().build());
  }
  
  @DeleteMapping(value = "/deleteClientType", produces = MediaType.APPLICATION_JSON_VALUE)
  @ApiOperation(value = "Delet a client type", notes = "Delet a client type registered")
  public Mono<ResponseEntity<Void>> deleteClient(@RequestParam("id")String id) {
    return clientTypeService.deleteById(id)
      .then(Mono.just(new ResponseEntity<Void>(HttpStatus.NO_CONTENT)))
      .defaultIfEmpty(ResponseEntity.notFound().build());
  }
}
