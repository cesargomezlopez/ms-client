package ms.client;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ms.client.model.Client;
import ms.client.repository.IClientRepository;

@SpringBootApplication
public class MsClientApplication implements CommandLineRunner{

	@Autowired
	IClientRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(MsClientApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		deleteAllClients();
		Client client1 = new Client("Cesar", "Gomez", "Lopez");
		Client client2 = new Client("Diego", "García", "Garay");
		addClient(client1);
		addClient(client2);
		findAllClients();
		System.out.println(findClientByFirstName("Diego"));
		deleteClient(client2);
		findAllClients();
		
		Client client3 = findClientByFirstName("Cesar");
		client3.setFirstName("Cesarrr");
		updateClient(client3);
		findAllClients();
		
		System.out.println(findClientById(client3.getId()));
	}
	
	public void deleteAllClients() {
		System.out.println("Removing clients...");
		repository.deleteAll();
	}
	
	public void addClient(Client client) {
		System.out.println("Adding a client...'"+ client.getFirstName() + " " + client.getLastNamePaternal() + "'");
		repository.save(client);
	}
	
	public void findAllClients() {
		System.out.println("Finding all clients...");
		repository.findAll().forEach(u -> System.out.println(u));
	}
	
	public Client findClientByFirstName(String name) {
		System.out.println("Finding Client by first name '" + name + "'");
		return repository.findFirstByFirstName(name);
	}
	
	public void deleteClient(Client client) {
		System.out.println("Removing Client '" + client.getFirstName() + " " + client.getLastNamePaternal() + "'");
		repository.delete(client);
	}
	
	public void updateClient(Client client) {
		System.out.println("Updating client...");
		repository.save(client);
	}
	
	public Optional<Client> findClientById(String id) {
		System.out.println("Finding Client by Id '" + id + "'");
		return repository.findById(id);
	}

}
