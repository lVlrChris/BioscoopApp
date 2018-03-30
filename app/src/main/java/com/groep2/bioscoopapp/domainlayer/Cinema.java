package com.groep2.bioscoopapp.domainlayer;

/**
 * Created by Kevin van Loon on 27-3-2018.
 */

public class Cinema {

    private String name;
    private String tel;
    private String mail;
    private String adress;

    public Cinema(String name, String tel, String mail, String adress) {
        this.name = name;
        this.tel = tel;
        this.mail = mail;
        this.adress = adress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }
}
