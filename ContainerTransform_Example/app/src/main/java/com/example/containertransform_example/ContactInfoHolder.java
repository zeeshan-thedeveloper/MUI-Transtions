package com.example.containertransform_example;

public class ContactInfoHolder {
    String name,phone,email,zipCode,street;
    ContactInfoHolder(String name, String phone, String email, String zipCode, String street){
        this.email=email;
        this.name=name;
        this.phone=phone;
        this.street=street;
        this.zipCode=zipCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
