import com.nest.system_g_portal_backend.entities.AgentDetails;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AgentDetailsTest {

    @Test
    public void testAgentDetails() {
        // Create an instance of AgentDetails
        AgentDetails agent = new AgentDetails();

        // Set values for the instance variables
        agent.setId(1);
        agent.setAgent_name("John Doe");
        agent.setAgent_id("A001");
        agent.setPhone_number("1234567890");
        agent.setEmail("john.doe@example.com");
        agent.setPlace("New York");
        agent.setDepartment("Sales");
        agent.setImage("profile.jpg");

        // Perform assertions to validate the values
        Assertions.assertEquals(1, agent.getId());
        Assertions.assertEquals("John Doe", agent.getAgent_name());
        Assertions.assertEquals("A001", agent.getAgent_id());
        Assertions.assertEquals("1234567890", agent.getPhone_number());
        Assertions.assertEquals("john.doe@example.com", agent.getEmail());
        Assertions.assertEquals("New York", agent.getPlace());
        Assertions.assertEquals("Sales", agent.getDepartment());
        Assertions.assertEquals("profile.jpg", agent.getImage());
    }
}
