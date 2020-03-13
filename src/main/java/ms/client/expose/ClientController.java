package ms.client.expose;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ms.client.model.Client;
import ms.client.model.Confirmation;
import ms.client.repository.IClientRepository;

@RestController
@RequestMapping("/client")
public class ClientController {
	
	@Autowired
	IClientRepository repository;
	
	@GetMapping("/findAllClients")
	public List<Client> findAllClients() {
		return repository.findAll();
	}
	
	@GetMapping("/findClientByName")
	public Client findClientByName(@RequestParam("firstName")String firstName) {
		return repository.findFirstByFirstName(firstName);
	}
	
	@GetMapping("/findClientById")
	public Optional<Client> findClientById(@RequestParam("id")String id) {
		return repository.findById(id);
	}

	@DeleteMapping("/deleteClientById")
	public Confirmation deleteClientById(@RequestParam("id")String id) {
		Confirmation confirmation = new Confirmation();
		
		if (!id.isEmpty() && id != null) {
			try {
				repository.deleteById(id);
				confirmation.setState(1);
				confirmation.setMessage("Client deleted successfully");
			} catch (Exception e) {
				confirmation.setState(0);
				confirmation.setMessage("Error trying delet client");
			}
		} else {
			confirmation.setState(-1);
			confirmation.setMessage("The id client must be different to null");
		}
		
		return confirmation;
	}
	
	@PostMapping("/addClient")
	public Confirmation addClient(@RequestBody Client client) {
		Confirmation confirmation = new Confirmation();
		
		if (client!=null) {
			try {
				repository.save(client);
				confirmation.setState(1);
				confirmation.setMessage("Client register successfully");
			} catch (Exception e) {
				confirmation.setState(0);
				confirmation.setMessage("Error trying register client");
			}
		} else {
			confirmation.setState(-1);
			confirmation.setMessage("Client data must be complete");
		}
		
		return confirmation;
	}
	
	@PutMapping("/updateClient")
	public Confirmation updateClient(@RequestBody Client client) {
		Confirmation confirmation = new Confirmation();
		
		if (client!=null) {
			try {
				repository.save(client);
				confirmation.setState(1);
				confirmation.setMessage("Client updated successfully");
			} catch (Exception e) {
				confirmation.setState(0);
				confirmation.setMessage("Error trying updating client");
			}
		} else {
			confirmation.setState(-1);
			confirmation.setMessage("Client data must be complete");
		}
		
		return confirmation;
	}
}
