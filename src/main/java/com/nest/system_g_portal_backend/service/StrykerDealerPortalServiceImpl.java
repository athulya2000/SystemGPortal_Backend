package com.nest.system_g_portal_backend.service;

import com.nest.system_g_portal_backend.entities.StrykerDealerPortal;
import com.nest.system_g_portal_backend.repository.StrykerDealerPortalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StrykerDealerPortalServiceImpl implements StrykerDealerPortalService {
    @Autowired
    private StrykerDealerPortalRepo strykerDealerPortalRepo;

    @Override
    public List<StrykerDealerPortal> getAllAvailableSurgeries() {

        return strykerDealerPortalRepo.findAll();
    }

    @Override
    public StrykerDealerPortal updateAssignedAgent(StrykerDealerPortal strykerDealerPortal) {
        try {
            StrykerDealerPortal update = strykerDealerPortalRepo.findById(strykerDealerPortal.getId()).orElse(null);
            if (update != null) {
                update.setAssigned_agent(strykerDealerPortal.getAssigned_agent());
                strykerDealerPortalRepo.save(update);
                return update;
            }
            else{
                throw new Exception("Id not found");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return null;

    }

}