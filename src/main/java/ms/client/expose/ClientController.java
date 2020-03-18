package ms.client.expose;

import javax.validation.Valid;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ms.client.model.Client;
import ms.client.model.Confirmation;
import ms.client.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
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
@Api(value = "cliente")
public class ClientController {

  @Autowired
  private IClientService clientService;

  @GetMapping(value = "/findAllClients", produces = MediaType.APPLICATION_JSON_VALUE)
  @ApiOperation(value = "Find all clients", notes = "Find all clients registered", 
      response = Client.class)
  public Flux<Client> findAllClients() {
    return clientService.findAll();
  }

  @GetMapping(value = "/findClientById", produces = MediaType.APPLICATION_JSON_VALUE)
  @ApiOperation(value = "Find client by id", notes = "Fin client registered by id", 
      response = Client.class)
  public Mono<Client> findClientById(@RequestParam("id")String id) {
    return clientService.findById(id);
  }

  @GetMapping(value = "/findClientByName", produces = MediaType.APPLICATION_JSON_VALUE)
  @ApiOperation(value = "Find client by name", notes = "Find client registered by name", 
      response = Client.class)
  public Mono<Client> findClientByName(@RequestParam("firstName")String firstName) {
    return clientService.findFirstByFirstName(firstName);
  }

  @DeleteMapping(value = "/deleteClientById", produces = MediaType.APPLICATION_JSON_VALUE)
  @ApiOperation(value = "Delete client by id", notes = "Delete client registered by id",
      response = Confirmation.class)
  public Confirmation<Client> deleteClientById(@RequestParam("id")String id) {
    Confirmation<Client> confirmation = new Confirmation<Client>();

    if (!id.isEmpty() && id != null) {
      try {
        clientService.deleteById(id).subscribe();
        confirmation.setStatus(1);
        confirmation.setMessage("Client deleted successfully");
      } catch (Exception e) {
        confirmation.setStatus(0);
        confirmation.setMessage("Error trying delet client");
      }
    } else {
      confirmation.setStatus(-1);
      confirmation.setMessage("The id client must be different to null");
    }

    return confirmation;
  }

  @PostMapping(value = "/addClient", produces = MediaType.APPLICATION_JSON_VALUE,
      consumes = MediaType.APPLICATION_JSON_VALUE)
  @ApiOperation(value = "Add a client", notes = "Add a new client", response = Confirmation.class)
  public Confirmation<Client> addClient(@Valid @RequestBody Client client, Errors errors) {
    Confirmation<Client> confirmation = new Confirmation<Client>();

    if (errors.hasErrors()) {
      System.out.println(errors);
      confirmation.setStatus(0);
      confirmation.setMessage("Client data must be complete");
    }
    else {
      try {
        confirmation.setModel(clientService.save(client).block());
        confirmation.setStatus(1);
        confirmation.setMessage("Client register successfully");
      } catch (Exception e) {
          confirmation.setStatus(-1);
          confirmation.setMessage("Error trying register client");
        }
    }

    return confirmation;
  }

  @PutMapping(value = "/updateClient", produces = MediaType.APPLICATION_JSON_VALUE,
      consumes = MediaType.APPLICATION_JSON_VALUE)
  @ApiOperation(value = "Update a client", notes = "Update a client registered", 
      response = Client.class)
  public Confirmation<Client> updateClient(@Valid @RequestBody Client client, BindingResult result) {
    Confirmation<Client> confirmation = new Confirmation<Client>();

    if (result.hasErrors()) {
      System.out.println(result);
      confirmation.setStatus(0);
      confirmation.setMessage("Client data must be complete");
    }
    else {
      try {
          confirmation.setModel(clientService.save(client).block());
          confirmation.setStatus(1);
          confirmation.setMessage("Client updated successfully");
      } catch (Exception e) {
          confirmation.setStatus(-1);
          confirmation.setMessage("Error trying updating client");
        }
    }

    return confirmation;
  }

}
