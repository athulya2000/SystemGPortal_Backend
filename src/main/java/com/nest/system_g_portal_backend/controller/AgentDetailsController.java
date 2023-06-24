package com.nest.system_g_portal_backend.controller;

import com.nest.system_g_portal_backend.entities.AgentDetails;
import com.nest.system_g_portal_backend.service.AgentDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AgentDetailsController {
    @Autowired
    private AgentDetailsService agentDetailsService;

    @CrossOrigin(origins = "*")
    @GetMapping("/agentDetails/{agent_name}")
    public List<AgentDetails> agentDetails(@PathVariable(value="agent_name") String agent_name){
        System.out.println(agent_name);
        return agentDetailsService.agentDetails(agent_name);
    }
}
