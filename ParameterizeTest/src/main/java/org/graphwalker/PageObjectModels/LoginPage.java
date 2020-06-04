package org.graphwalker.PageObjectModels;

public class LoginPage extends PageObjectModelBase {
    private String username, password;
    private String signInButton;
    private String illuminatorLoginButton;
    private String samlLoginButton;
    private String googleLoginButton;

    public String getUsername() {
        username = reader.getData("USERNAME");
        return username;
    }

    public String getPassword() {
        password = reader.getData("PASSWORD");
        return password;
    }

    public String getSignInButton() {
        signInButton = reader.getData("signInButton");
        return signInButton;
    }

    public String getIlluminatorLoginButton() {
        return illuminatorLoginButton;
    }

    public String getSamlLoginButton() {
        return samlLoginButton;
    }

    public String getGoogleLoginButton() {
        return googleLoginButton;
    }
}