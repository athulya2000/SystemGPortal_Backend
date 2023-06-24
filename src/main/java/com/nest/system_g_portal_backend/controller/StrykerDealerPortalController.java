package com.nest.system_g_portal_backend.controller;

import com.nest.system_g_portal_backend.entities.StrykerDealerPortal;
import com.nest.system_g_portal_backend.service.StrykerDealerPortalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StrykerDealerPortalController {
    @Autowired
    private StrykerDealerPortalService strykerDealerPortalService;
    @CrossOrigin(origins = "*")
    @GetMapping("/viewAllSurgeries")
    public List<StrykerDealerPortal> getSurgeryDetails(){
        return  strykerDealerPortalService.getAllAvailableSurgeries();
    }
    @CrossOrigin(origins = "*")
    @PutMapping("updateAssignedAgent")
    public StrykerDealerPortal updateAgent(@RequestBody StrykerDealerPortal strykerDealerPortal){
        System.out.println(strykerDealerPortal.getId());
        System.out.println(strykerDealerPortal.getAssigned_agent());
        return  strykerDealerPortalService.updateAssignedAgent(strykerDealerPortal);
    }
}
