import javax.mail.*;
import javax.mail.internet.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

//CONTACT FORM CONTROL CLASS

public class ContactFormControl implements ActionListener {

    ContactForm cfc;
    Person per = new Person();
    Mail mail;
    public ContactFormControl(ContactForm cfc){

        this.cfc=cfc;
        cfc.actionlistener(this);
        mail = new Mail();

    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==cfc.sendButton){
            //SETTING UP THE CONTACT FORM BUTTON TO USE THE JAVA MAIL API
            try{

                mail.setupServerProperties();
                MimeMessage mimeMessage = mail.draftEmail(cfc.subjectArea.getText(),
                        cfc.messageArea.getText() + "\n" + "\n" +
                                "EMAIL:\n" + cfc.emailField.getText() + "\n" + "\n" +
                                "NAME:\n" + cfc.nameField.getText());

                mail.sendEmail(mimeMessage);}
            catch (MessagingException k){
                k.getMessage();
            }
            cfc.ContactFrame.dispose();

        }

    }
}
