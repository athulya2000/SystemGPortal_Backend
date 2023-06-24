package com.nest.system_g_portal_backend.repository;

import com.nest.system_g_portal_backend.entities.AgentDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AgentDetailsRepo extends JpaRepository<AgentDetails,Integer> {
    @Query(value="SELECT `id`, `agent_name`, `agent_id`, `phone_number`, `email`, `place`, `department`, `image`  FROM `agent_details` WHERE `agent_name`= :agent_name",nativeQuery = true)
    List<AgentDetails> details(@Param("agent_name") String agent_name);
}
