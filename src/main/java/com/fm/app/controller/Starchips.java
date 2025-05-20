package com.fm.app.controller;

public class Starchips
{
    /// <summary>
    /// Card cost in starchips
    /// </summary>
    public int Cost ;
    /// <summary>
    /// Password for the card
    /// </summary>
    public int Password ;
    /// <summary>
    /// Password representation as string
    /// </summary>
    public String PasswordStr ;

    public int getCost() {
        return Cost;
    }

    public void setCost(int cost) {
        Cost = cost;
    }

    public int getPassword() {
        return Password;
    }

    public void setPassword(int password) {
        Password = password;
    }

    public String getPasswordStr() {
        return PasswordStr;
    }

    public void setPasswordStr(String passwordStr) {
        PasswordStr = passwordStr;
    }
}