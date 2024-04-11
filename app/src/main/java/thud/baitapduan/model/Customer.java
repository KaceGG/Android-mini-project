package thud.baitapduan.model;

import java.io.Serializable;

public class Customer implements Serializable {
    private int customer_id;
    private String customer_name;
    private String customer_password;
    private String customer_email;
    private String customer_phoneNumber;

    public Customer() {
    }

    public Customer(String customer_name, String customer_password, String customer_email, String customer_phoneNumber) {
        this.customer_name = customer_name;
        this.customer_password = customer_password;
        this.customer_email = customer_email;
        this.customer_phoneNumber = customer_phoneNumber;
    }

    public Customer(String customer_name, String customer_phoneNumber) {
        this.customer_name = customer_name;
        this.customer_phoneNumber = customer_phoneNumber;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getCustomer_password() {
        return customer_password;
    }

    public void setCustomer_password(String customer_password) {
        this.customer_password = customer_password;
    }

    public String getCustomer_email() {
        return customer_email;
    }

    public void setCustomer_email(String customer_email) {
        this.customer_email = customer_email;
    }

    public String getCustomer_phoneNumber() {
        return customer_phoneNumber;
    }

    public void setCustomer_phoneNumber(String customer_phoneNumber) {
        this.customer_phoneNumber = customer_phoneNumber;
    }
}