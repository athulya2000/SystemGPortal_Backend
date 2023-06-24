package com.nest.system_g_portal_backend.service;

import com.nest.system_g_portal_backend.entities.AgentDetails;
import com.nest.system_g_portal_backend.repository.AgentDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AgentDetailsServiceImpl implements AgentDetailsService{
    @Autowired
    private AgentDetailsRepo agentDetailsRepo;
    @Override
    public List<AgentDetails> agentDetails(String agent_name) {
        return agentDetailsRepo.details(agent_name);
    }
}
