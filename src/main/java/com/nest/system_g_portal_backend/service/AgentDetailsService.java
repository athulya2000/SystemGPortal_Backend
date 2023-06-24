package com.nest.system_g_portal_backend.service;

import com.nest.system_g_portal_backend.entities.AgentDetails;

import java.util.List;

public interface AgentDetailsService {
    List<AgentDetails> agentDetails(String agent_name);
}
