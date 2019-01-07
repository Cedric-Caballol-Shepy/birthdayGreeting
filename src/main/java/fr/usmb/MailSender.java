package fr.usmb;

import java.io.IOException;
import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailSender {

    public static void sendBirthdayMessage(Person receiver) throws IOException {
        String mailReceveur = receiver.getMail();
        String subject = "Happy birthday M/Ms " + receiver.getSurname() + " ! ";
        String bodyText = "Hello ! \n We wish you a very happy birthday M/Ms " + receiver.getFirstName()
                + " " + receiver.getSurname() + " !";
        sendMail(mailReceveur,subject,bodyText);
    }

    private static void sendMail(String receiver, String subject, String bodyText) throws IOException {
        // Create a Properties object to contain connection configuration information.
        Properties props = System.getProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.port", AppProperties.getPort());
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");

        // Create a Session object to represent a mail session with the specified properties.
        Session session = Session.getDefaultInstance(props);

        // Create a message with the specified information.
        MimeMessage msg = new MimeMessage(session);
        try {
            msg.setFrom(new InternetAddress(AppProperties.getFrom(),AppProperties.getFromName()));
        msg.setRecipient(Message.RecipientType.TO, new InternetAddress(receiver));
        msg.setSubject(subject);
        msg.setContent(bodyText,"text/html");

        // Create a transport.
        Transport transport = session.getTransport();

        // Send the message.
        try{
            System.out.println("Sending email...");
            // Connect to    using the SMTP username and password you specified above.
            transport.connect(AppProperties.getHost(), AppProperties.getSmtp_Username(), AppProperties.getSmtp_Password());
            // Send the email.
            transport.sendMessage(msg, msg.getAllRecipients());
            System.out.println("Email sent to "+ receiver +" !");
        }
        catch (Exception ex) {
            System.out.println("The email was not sent.");
            System.out.println("Error message: " + ex.getMessage());
        }
        finally{
            // Close and terminate the connection.
            transport.close();
        }
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
