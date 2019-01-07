package fr.usmb;

import java.util.ArrayList;

public class todaysBirthdayMessagesSender {
    private ArrayList<Person> people;

    public todaysBirthdayMessagesSender(){
        CSVReader reader = new CSVReader();
        people = reader.toPeople();
    }

    private void send(Person p) {
        if(p.isBirthday()){
            MailSender.sendBirthdayMessage(p);
        }
    }

    public void sendAll() {
        for(Person p : people) {
            send(p);
        }
    }
}
