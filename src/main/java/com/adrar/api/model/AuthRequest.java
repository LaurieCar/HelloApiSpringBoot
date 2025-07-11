package com.adrar.api.model;

import lombok.Data;

public class AuthRequest {

    // Attributs
    private String username;
    private String password;

    // Contructeurs
    public AuthRequest() {}
    public AuthRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getters setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Méthodes
    @Override
    public String toString(){
        return "Username: " + username + " Password: " + password;
    }
}
