package ms.client.model;

import java.util.Date;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ClientTest {

  @Test
  public void clienteTest() {
    Client client = new Client();
    client.setId("c1");
    client.setCode("bcp-c1");
    client.setName("Cesar");
    client.setLastNamePaternal("Gomez");
    client.setLastNameMaternal("Lopez");
    client.setDocumentNumber("77269125");
    client.setPhoneNumber("993661990");
    client.setEmail("cesar.gomez@urp.edu.pe");
    client.setAddress("Av. Benavides 5440");
    client.setCity("Lima");
    client.setStartDate(new Date(2020,3,24));
    ClientType clientType = new ClientType("ct1", "01", "Personal");
    client.setClientType(clientType);

    Assertions.assertEquals("c1", client.getId());
    Assertions.assertEquals("bcp-c1", client.getCode());
    Assertions.assertEquals("Cesar", client.getName());
    Assertions.assertEquals("Gomez", client.getLastNamePaternal());
    Assertions.assertEquals("Lopez", client.getLastNameMaternal());
    Assertions.assertEquals("77269125", client.getDocumentNumber());
    Assertions.assertEquals("993661990", client.getPhoneNumber());
    Assertions.assertEquals("cesar.gomez@urp.edu.pe", client.getEmail());
    Assertions.assertEquals("Av. Benavides 5440", client.getAddress());
    Assertions.assertEquals("Lima", client.getCity());
    Assertions.assertEquals(new Date(2020,3,24), client.getStartDate());
    Assertions.assertEquals(clientType, client.getClientType());

    Assertions.assertEquals(true, new Client("c1","bcp-c1","Cesar","Gomez",
        "Lopez","77269125","993661990","cesar.gomez@urp.edu.pe",
        "Av. Benavides 5440","Lima",new Date(2020,3,24),clientType).equals(client));
    Assertions.assertEquals("Client(id=c1, code=bcp-c1, name=Cesar, lastNamePaternal=Gomez, "
        + "lastNameMaternal=Lopez, documentNumber=77269125, phoneNumber=993661990, "
        + "email=cesar.gomez@urp.edu.pe, address=Av. Benavides 5440, city=Lima, "
        + "startDate=Sat Apr 24 00:00:00 COT 3920, "
        + "clientType=ClientType(id=ct1, code=01, description=Personal))",
        client.toString());
    Assertions.assertEquals(false, client.hashCode() == new Client().hashCode());
  }

}
