package com.baeldung.crud.entities;

public class UserFilter {

    private String name;

    public UserFilter() {
        this.name = "";
        this.passportId = "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassportId() {
        return passportId;
    }

    public void setPassportId(String passportId) {
        this.passportId = passportId;
    }

    private String passportId;
}
