package fr.usmb;

import javax.mail.MessagingException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws MessagingException, IOException {
        if(args.length == 2) {
            AppProperties.initProperties(args[0], args[1]);
            sendTodaysBirthdayMessages();
        }
        else{
            throw new IllegalArgumentException("Missing parameters : CSV_File configuration.properties");
        }
    }

    private static void sendTodaysBirthdayMessages() throws IOException, MessagingException {
        CSVReader reader = new CSVReader();
        ArrayList<Person> people = reader.toPeople();
        for(Person p : people) {
            if(p.getBirth_day().getDayOfYear() == LocalDate.now().getDayOfYear()) {
                MailSender.sendBirthdayMessage(p);
            }
        }
    }
}
