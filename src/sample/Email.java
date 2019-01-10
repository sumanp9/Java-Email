package sample;

import javafx.beans.property.SimpleStringProperty;

public class Email {

    SimpleStringProperty date;
    SimpleStringProperty sender;

    SimpleStringProperty Subject;
    //SimpleStringProperty body;

    public Email(String date, String sender,  String subject/*,String body*/) {
        this.date = new SimpleStringProperty(date);
        this.sender = new SimpleStringProperty(sender);
        this.Subject = new SimpleStringProperty(subject);
        //this.body = new SimpleStringProperty(body);
    }


    public String getDate() {
        return date.get();
    }


    public String getSender() {
        return sender.get();
    }


    public String getSubject() {
        return Subject.get();
    }

    //public String getBody(){return body.get();}


    public void setDate(String date) {
        this.date.set(date);
    }

    public void setSender(String sender) {
        this.sender.set(sender);
    }

    public void setSubject(String subject) {
        this.Subject.set(subject);
    }
   /* public void setBody(String body) {
        this.body.set(body);
    }*/

    public String toString(){
        String detail = "";
        detail+="Date: "+this.getDate()+"\n"+
                "Sender: "+this.getSender()+"\n"+
                "Subject: "+this.getSubject();

        return  detail;
    }
}
