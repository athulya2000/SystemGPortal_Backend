package com.nest.system_g_portal_backend;

import com.nest.system_g_portal_backend.entities.StrykerDealerPortal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StrykerDealerPortalTest {

    @Test
    public void testStrykerDealerPortal() {
        // Create an instance of StrykerDealerPortal
        StrykerDealerPortal portal = new StrykerDealerPortal();

        // Set values for the instance variables
        portal.setId(1);
        portal.setTicket_id(1001);
        portal.setSurgery_name("Knee Replacement");
        portal.setDate("2023-05-25");
        portal.setPriority("High");
        portal.setStatus("Open");
        portal.setOrder_item_count("5");
        portal.setAssigned_agent("John Doe");
        portal.setTime("10:00 AM");

        // Perform assertions to validate the values
        Assertions.assertEquals(1, portal.getId());
        Assertions.assertEquals(1001, portal.getTicket_id());
        Assertions.assertEquals("Knee Replacement", portal.getSurgery_name());
        Assertions.assertEquals("2023-05-25", portal.getDate());
        Assertions.assertEquals("High", portal.getPriority());
        Assertions.assertEquals("Open", portal.getStatus());
        Assertions.assertEquals("5", portal.getOrder_item_count());
        Assertions.assertEquals("John Doe", portal.getAssigned_agent());
        Assertions.assertEquals("10:00 AM", portal.getTime());
    }
}
