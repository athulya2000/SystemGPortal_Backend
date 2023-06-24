package com.nest.system_g_portal_backend.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="agent_details")
public class AgentDetails {
    @Id
    @GeneratedValue
    private int id;
    private String agent_name;
    private String agent_id;
    private String phone_number;
    private String email;
    private String place;
    private String department;
    private String image;

    public AgentDetails() {
    }

    public AgentDetails(int id, String agent_name, String agent_id, String phone_number, String email, String place, String department, String image) {
        this.id = id;
        this.agent_name = agent_name;
        this.agent_id = agent_id;
        this.phone_number = phone_number;
        this.email = email;
        this.place = place;
        this.department = department;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAgent_name() {
        return agent_name;
    }

    public void setAgent_name(String agent_name) {
        this.agent_name = agent_name;
    }

    public String getAgent_id() {
        return agent_id;
    }

    public void setAgent_id(String agent_id) {
        this.agent_id = agent_id;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}

