import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ContactForm {
    JFrame ContactFrame;
    public JPanel panel1;



    JLabel nameLabel;
    JTextField nameField;
    JLabel emailLabel;
    JTextField emailField;
    JLabel subjectLabel;
    JTextField subjectArea;
    JLabel messageLabel;
    JTextArea messageArea;
    JLabel info;
    JButton sendButton;
    JSeparator separator;
    JScrollPane scrollPane;
    public ContactForm(){
        this.ContactFrame = new JFrame();
        this.ContactFrame.setTitle("Contact Us");
        this.ContactFrame.setSize(new Dimension(400,400));


        /*··································································*/
        panel1=new JPanel(new FlowLayout());

        panel1.setBackground(Color.WHITE);

        info = new JLabel("Contact Form");
        info.setFont(new Font("Segoe UI Black",Font.BOLD,20));
        JLabel info_message = new JLabel("Please Let Us Know Your Query");
        info_message.setFont(new Font("Cambria",Font.PLAIN,18));

        nameLabel = new JLabel("Name");
        nameLabel.setFont(new Font("Cambria",Font.BOLD,18));
        nameField = new JTextField();
        nameField.setPreferredSize(new Dimension(300,25));

        emailLabel = new JLabel("Email");
        emailLabel.setFont(new Font("Cambria",Font.BOLD,18));
        emailField=new JTextField();
        emailField.setPreferredSize(new Dimension(300,25));

        subjectLabel =new JLabel("Subject");
        subjectLabel.setFont(new Font("Cambria",Font.BOLD,18));
        subjectArea= new JTextField();
        subjectArea.setPreferredSize(new Dimension(300,25));

        messageLabel = new JLabel("Message");
        messageLabel.setFont(new Font("Cambria",Font.BOLD,18));
        messageArea = new JTextArea();
        messageArea.setPreferredSize(new Dimension(380,100));
        messageArea.setLineWrap(true);
        messageArea.setWrapStyleWord(true);

        sendButton = new JButton("Send");
        sendButton.setBackground(Color.darkGray);

        separator = new JSeparator(SwingConstants.HORIZONTAL);
        separator.setPreferredSize(new Dimension(380, 2));
         scrollPane = new JScrollPane(messageArea);



        panel1.add(info);
        panel1.add(info_message);
        panel1.add(separator);
        panel1.add(nameLabel);
        panel1.add(nameField);
        panel1.add(emailLabel);
        panel1.add(emailField);
        panel1.add(subjectLabel);
        panel1.add(subjectArea);
        panel1.add(messageLabel);
        panel1.add(scrollPane);
        panel1.add(sendButton);

        /*.......................................................................*/
        this.ContactFrame.setLayout(new FlowLayout());
        this.ContactFrame.setContentPane(panel1);
        this.ContactFrame.setLocationRelativeTo(null);
        this.ContactFrame.setResizable(false);
        this.ContactFrame.setVisible(true);
        this.ContactFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void actionlistener(ActionListener listener){
        this.sendButton.addActionListener(listener);
    }




}




