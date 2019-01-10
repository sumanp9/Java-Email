package sample;

import javafx.beans.property.SimpleStringProperty;

public class SentMail {

    SimpleStringProperty date;
    SimpleStringProperty sender;
    SimpleStringProperty to;

    SimpleStringProperty Subject;
    //SimpleStringProperty body;

    public SentMail(String date, String to, String subject/*,String body*/) {
        this.date = new SimpleStringProperty(date);
        this.to = new SimpleStringProperty(to);
        this.Subject = new SimpleStringProperty(subject);
        //this.body = new SimpleStringProperty(body);
    }


    public String getDate() {
        return date.get();
    }



    public String getTo() {
        return to.get();
    }



    public String getSubject() {
        return Subject.get();
    }

    //public String getBody(){return body.get();}


    public void setDate(String date) {
        this.date.set(date);
    }

    public void setTo(String to) {
        this.to.set(to);
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
                "To: "+this.getTo()+"\n"+
                "Subject: "+this.getSubject();

        return  detail;
    }
}
