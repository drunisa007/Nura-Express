package com.kk.as.nura.negavitionbyarun.activity.model;

/**
 * Created by Aung Thu on 8/2/2017.
 */

public class Gates {
    private int id;
    private String name, route, contact, price;

    public Gates(int id, String name, String route, String contact, String price) {
        this.id = id;
        this.name = name;
        this.route = route;
        this.contact = contact;
        this.price = price;
    }

    public Gates(String name, String route, String contact, String price) {
        this.name = name;
        this.route = route;
        this.contact = contact;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

}
