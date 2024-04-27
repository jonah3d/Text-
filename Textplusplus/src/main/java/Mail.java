import javax.mail.*;
import javax.mail.internet.*;
import javax.swing.*;
import java.util.Properties;

public class Mail {
    Session newSession = null;

    //JAVA MAIL API CONFIGURATION

    public MimeMessage draftEmail(String emailSubject, String emailBody ) throws MessagingException {
         String emailRecipients = "jonah3d.arthur@gmail.com";


        MimeMessage mimeMessage = new MimeMessage(newSession);
        mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(emailRecipients));
        mimeMessage.setSubject(emailSubject);

        MimeMultipart multipart = new MimeMultipart();
        MimeBodyPart bodyPart = new MimeBodyPart();
        bodyPart.setContent(emailBody, "text/html"); // Corrected content type
        multipart.addBodyPart(bodyPart);
        mimeMessage.setContent(multipart);
        return mimeMessage;

    }

    public void setNewSession(Session newSession) {
        this.newSession = newSession;
    }

    public Session getNewSession() {
        return newSession;
    }

    public void sendEmail(MimeMessage mimeMessage) {
        try {
            String fromUser = "jonathana431@gmail.com";
            String FromUserPassword = "gddysdfxwddinxco";
            String emailHost = "smtp.gmail.com";

            Transport transport = newSession.getTransport("smtp");
            transport.connect(emailHost, fromUser, FromUserPassword);
            transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
            transport.close();
            JOptionPane.showConfirmDialog(null,"MESSAGE SENT SUCCESSFULLY","CONFIRMATION",JOptionPane.OK_OPTION);
        } catch (MessagingException e) {
            e.printStackTrace(); // Print the stack trace for debugging
        }
    }


    public void setupServerProperties() {
        Properties properties = System.getProperties();
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        newSession = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("jonathana431@gmail.com", "gddysdfxwddinxco");
            }
        });
    }
}
