package com.nest.system_g_portal_backend;

import com.nest.system_g_portal_backend.controller.AgentDetailsController;
import com.nest.system_g_portal_backend.entities.AgentDetails;
import com.nest.system_g_portal_backend.service.AgentDetailsService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@WebMvcTest(AgentDetailsController.class)
@AutoConfigureMockMvc
public class AgentDetailsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AgentDetailsService agentDetailsService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAgentDetails() throws Exception {
        // Create a list of AgentDetails objects
        List<AgentDetails> agents = new ArrayList<>();
        agents.add(new AgentDetails(1, "John Doe", "A001", "1234567890", "john.doe@example.com", "New York", "Sales", "profile.jpg"));
        agents.add(new AgentDetails(2, "Jane Smith", "A002", "9876543210", "jane.smith@example.com", "Los Angeles", "Marketing", "avatar.jpg"));

        // Mock the service method to return the list of agents
        when(agentDetailsService.agentDetails("John Doe")).thenReturn(agents);

        // Perform the GET request to "/agentDetails/{agent_name}" endpoint
        mockMvc.perform(MockMvcRequestBuilders.get("/agentDetails/{agent_name}", "John Doe"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].agent_name").value("John Doe"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].agent_id").value("A001"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].phone_number").value("1234567890"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].email").value("john.doe@example.com"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].place").value("New York"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].department").value("Sales"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].image").value("profile.jpg"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].id").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].agent_name").value("Jane Smith"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].agent_id").value("A002"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].phone_number").value("9876543210"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].email").value("jane.smith@example.com"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].place").value("Los Angeles"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].department").value("Marketing"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].image").value("avatar.jpg"));
    }
}
