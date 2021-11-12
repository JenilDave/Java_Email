


//to compile jar file javac -cp .;javax.mail.jar EmailUtility.java
//to run java -cp .;javax.mail.jar EmailUtility
import java.util.Properties;
import javax.mail.Session;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Message;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;
import javax.sql.DataSource;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.activation.*;

public class EmailUtility{
    public static void sendMail(String recepient) throws Exception {
        Properties properties = new Properties();

        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        String email = "ocrproject43@gmail.com";
        String pass = "OCRhindi@123";

        Session session = Session.getInstance(properties, new Authenticator(){
            @Override
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(email, pass);
            }
        });

        Message message = prepareMessage(session,email,recepient);
        //Transport trans = session.getTransport("smtps");
        Transport.send(message);
        System.out.println("Check Mail");

    }

    private static Message prepareMessage(Session session, String email,String reciever) throws Exception {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(email));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(reciever));
            message.setSubject("EMAIL FROM JAVA");
            message.setText("Hey is mini projrct of java");
            return message;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    
}
