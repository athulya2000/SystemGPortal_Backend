package com.nest.system_g_portal_backend.service;

import com.nest.system_g_portal_backend.entities.StrykerDealerPortal;
import org.springframework.stereotype.Service;

import java.util.List;

public interface StrykerDealerPortalService {

   public List<StrykerDealerPortal> getAllAvailableSurgeries();
   public StrykerDealerPortal updateAssignedAgent(StrykerDealerPortal strykerDealerPortal);
}
