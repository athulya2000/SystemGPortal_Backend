package com.nest.system_g_portal_backend;

import com.nest.system_g_portal_backend.controller.StrykerDealerPortalController;
import com.nest.system_g_portal_backend.entities.StrykerDealerPortal;
import com.nest.system_g_portal_backend.service.StrykerDealerPortalService;
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

@WebMvcTest(StrykerDealerPortalController.class)
@AutoConfigureMockMvc
public class StrykerDealerPortalControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StrykerDealerPortalService strykerDealerPortalService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetSurgeryDetails() throws Exception {
        // Create a list of StrykerDealerPortal objects
        List<StrykerDealerPortal> surgeries = new ArrayList<>();
        surgeries.add(new StrykerDealerPortal(1, 1001, "Surgery 1", "2023-05-25", "High", "Open", "5", "John Doe", "10:00 AM"));
        surgeries.add(new StrykerDealerPortal(2, 1002, "Surgery 2", "2023-05-26", "Medium", "Closed", "3", "Jane Smith", "11:00 AM"));

        // Mock the service method to return the list of surgeries
        when(strykerDealerPortalService.getAllAvailableSurgeries()).thenReturn(surgeries);

        // Perform the GET request to "/viewAllSurgeries" endpoint
        mockMvc.perform(MockMvcRequestBuilders.get("/viewAllSurgeries"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].ticket_id").value(1001))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].surgery_name").value("Surgery 1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].date").value("2023-05-25"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].priority").value("High"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].status").value("Open"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].order_item_count").value("5"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].assigned_agent").value("John Doe"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].time").value("10:00 AM"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].id").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].ticket_id").value(1002))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].surgery_name").value("Surgery 2"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].date").value("2023-05-26"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].priority").value("Medium"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].status").value("Closed"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].order_item_count").value("3"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].assigned_agent").value("Jane Smith"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].time").value("11:00 AM"));
    }

    @Test
    public void testUpdateAgent() throws Exception {
        // Create a StrykerDealerPortal object with updated agent details
        StrykerDealerPortal updatedPortal = new StrykerDealerPortal(1, 1001, "Surgery 1", "2023-05-25", "High", "Open", "5", "New Agent", "10:00 AM");

        // Mock the service method to return the updated portal
        when(strykerDealerPortalService.updateAssignedAgent(updatedPortal)).thenReturn(updatedPortal);

        // Perform the PUT request to "/updateAssignedAgent" endpoint
        mockMvc.perform(MockMvcRequestBuilders.put("/updateAssignedAgent")
                        .content("{\"id\":1,\"ticket_id\":1001,\"surgery_name\":\"Surgery 1\",\"date\":\"2023-05-25\",\"priority\":\"High\",\"status\":\"Open\",\"order_item_count\":\"5\",\"assigned_agent\":\"New Agent\",\"time\":\"10:00 AM\"}")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.ticket_id").value(1001))
                .andExpect(MockMvcResultMatchers.jsonPath("$.surgery_name").value("Surgery 1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.date").value("2023-05-25"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.priority").value("High"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value("Open"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.order_item_count").value("5"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.assigned_agent").value("New Agent"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.time").value("10:00 AM"));
    }
}
