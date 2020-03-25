package ms.client.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ClientTypeTest {

  @Test
  public void clientTypeTest() {
    ClientType clientType = new ClientType();
    clientType.setId("ct1");
    clientType.setCode("01");
    clientType.setDescription("Personal");

    Assertions.assertEquals("ct1", clientType.getId());
    Assertions.assertEquals("01", clientType.getCode());
    Assertions.assertEquals("Personal", clientType.getDescription());

    Assertions.assertEquals(true, new ClientType("ct1", "01", "Personal").equals(clientType));
    Assertions.assertEquals("ClientType(id=ct1, code=01, description=Personal)",
        clientType.toString());
    Assertions.assertEquals(false, clientType.hashCode() == new ClientType().hashCode());
    
  }

}
