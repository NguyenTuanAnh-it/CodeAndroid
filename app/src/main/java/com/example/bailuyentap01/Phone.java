package com.example.bailuyentap01;

public class Phone {

    private String Name;
    private String PhoneNumber;

    private int imgPerson;

    private int imgPhone;

    private int imgMessage;

    public Phone() {
    }

    public Phone(String name, String phoneNumber, int imgPerson, int imgPhone, int imgMessage) {
        Name = name;
        PhoneNumber = phoneNumber;
        this.imgPerson = imgPerson;
        this.imgPhone = imgPhone;
        this.imgMessage = imgMessage;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public int getImgPerson() {
        return imgPerson;
    }

    public void setImgPerson(int imgPerson) {
        this.imgPerson = imgPerson;
    }

    public int getImgPhone() {
        return imgPhone;
    }

    public void setImgPhone(int imgPhone) {
        this.imgPhone = imgPhone;
    }

    public int getImgMessage() {
        return imgMessage;
    }

    public void setImgMessage(int imgMessage) {
        this.imgMessage = imgMessage;
    }
}
