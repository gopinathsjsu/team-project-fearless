package com.hotel.sjsu.hotelbookingservice.model;

public class SearchInput {
    private String from;
    private String to;
    private String location;

//    public SearchInput(String from, String to, String location) {
//        this.from = from;
//        this.to = to;
//        this.location = location;
//    }

    public SearchInput() {

    }

//    public SearchInput() {
//
//    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
