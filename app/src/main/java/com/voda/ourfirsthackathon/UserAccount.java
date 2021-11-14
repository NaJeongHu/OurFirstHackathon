package com.voda.ourfirsthackathon;

public class UserAccount {

    private String idToken;
    private String emailId;
    private String password;
    private Boolean auth;

    public UserAccount() { }

    public String getIdToken() { return idToken; }

    public void setIdToken(String idToken) { this.idToken = idToken; }

    public String getEmailId() { return emailId; }

    public void setEmailId(String emailId) { this.emailId = emailId; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public Boolean getauth() {
        return auth;
    }

    public void setauth(Boolean auth) {
        auth = auth;
    }
}
