package com.example.practica4.models;

public class Messages extends MessageResponse {
    public String message;
    public String image;
    public String sent;
   // public String _id;
    public String from;
    public String to;
    public String _id;
  //  public String __v;
  //  public boolean ok;

    public Messages( String from, String message, String image, String sent) {
        super();

    }



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


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSent() {
        return sent;
    }

    public void setSent(String sent) {
        this.sent = sent;
    }
}
