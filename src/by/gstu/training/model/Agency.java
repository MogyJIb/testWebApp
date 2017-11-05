package by.gstu.training.model;

import java.io.Serializable;

public class Agency extends Entity {
    private String title;
    private String phoneNumber;

    public Agency(int id, String title, String phoneNumber) {
        super(id);
        this.title = title;
        this.phoneNumber = phoneNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return title+" "+ phoneNumber;
    }
}
