package com.example.demo;

import java.io.Serializable;

public class Firm implements Serializable
{
    private int monthlySalary;
    private int phoneNumber;
    private String firmName;
    private String address;
    private String email;
    
    
    public Firm()
    {}
    
    public int getMonthlySalary()
    {
        return monthlySalary;
    }
    
    public void setMonthlySalary(int monthlySalary)
    {
        this.monthlySalary = monthlySalary;
    }
    
    public int getPhoneNumber()
    {
        return phoneNumber;
    }
    
    public void setPhoneNumber(int phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }
    
    public String getFirmName()
    {
        return firmName;
    }
    
    public void setFirmName(String firmName)
    {
        this.firmName = firmName;
    }
    
    public String getAddress()
    {
        return address;
    }
    
    public void setAddress(String address)
    {
        this.address = address;
    }
    
    public String getEmail()
    {
        return email;
    }
    
    public void setEmail(String email)
    {
        this.email = email;
    }
}

