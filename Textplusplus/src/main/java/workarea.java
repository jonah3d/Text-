import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;

public class workarea {

    /*DECLARING COMPONENTS THAT WILL GO INTO THE MAIN PANEL
    * I HAVE A PANEL CALLED MAIN PANEL SET TO A BORDER LAYOUT. ON THE NORTH SIDE I HAVE A PANEL
    * FOR THE FORMATTING AREA, IN THE CENTRE A JSCROLLPANE THAT CONSISTS OF A JTEXTAREA
    * AND AT THE SOUTH SIDE WHAT I CALL INFO TAB, USED TO VIEW RELEVANT INFORMATION OF YOUR DOCUMENT
    **/
    JPanel main_panel; //Main panel to set the text area and text formatting and info area
    JPanel infoArea;
    JPanel formattingArea;
    JScrollPane scrollPane;
    JTextArea texteditor;
    JLabel char_counter;
    JLabel docu_dir;
    JComboBox fontBox;
    JSpinner fontsizeSpinner;
    JButton fontcolorbutton;
    JCheckBox fontstyle;
    JCheckBox fonstyle_I;
    JLabel fontsizelabel;
    JLabel fonttype;
    JLabel fontcolor;
    private File currentFile;
    public workarea(){
        /*INITIALISATION OF COMPONENETS*/
    main_panel = new JPanel();
    formattingArea = new JPanel();
    texteditor = new JTextArea();
    scrollPane = new JScrollPane(texteditor);
    infoArea =  new JPanel();
    char_counter = new JLabel("Characters");
    docu_dir = new JLabel("                          Current Directory:");//I had to use space for the mean time since i couldnt get the border layout to do what i want, flowworks but the vgap
        //works for both components, and yh im aware i can create panels inside the panels and for what I want its overkill for now, since this is my first project of putting everything togther
        //i dont want to do stuff that will take lot of time. Right now my maxim is Quantity over quality.

        String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        fontBox = new JComboBox(fonts);
        fontsizeSpinner = new JSpinner();
        fontcolorbutton=new JButton("Color");
        fontstyle = new JCheckBox("B");
        fonstyle_I =  new JCheckBox("I");


    /*SETTING OF COMPONENT PROPERTIES*/
    infoArea.setPreferredSize(new Dimension(0,30));
    formattingArea.setPreferredSize(new Dimension(0,35));
    //texteditor.setEditable(true);
    texteditor.setLineWrap(true);

    texteditor.setWrapStyleWord(true);
    texteditor.setFont(new Font("Courier",Font.PLAIN,12));
    scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

    formattingArea.setBackground(Color.lightGray);

    fontsizelabel = new JLabel("Size");
     fonttype = new JLabel("Font");
     fontcolor = new JLabel("Color");
    formattingArea.setLayout(new FlowLayout(FlowLayout.LEFT,10,5));
    formattingArea.add(fonttype);
    formattingArea.add(fontBox);

    fontBox.setSelectedItem("Courier");
        fontsizeSpinner.setPreferredSize(new Dimension(50,25));
        fontsizeSpinner.setValue(11);
        fontsizeSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                texteditor.setFont(new Font(texteditor.getFont().getFamily(),Font.PLAIN,(int)fontsizeSpinner.getValue()));
            }
        });
  ;
        formattingArea.add(fontsizelabel);

        fontstyle.setFocusable(false);
        fonstyle_I.setFocusable(false);

    formattingArea.add(fontsizeSpinner);
    formattingArea.add(fontcolor);
    formattingArea.add(fontcolorbutton);
    formattingArea.add(fontstyle);
    formattingArea.add(fonstyle_I);



    char_counter.setForeground(Color.white);
    docu_dir.setForeground(Color.white);
    infoArea.setLayout(new BorderLayout());
    infoArea.add(char_counter,BorderLayout.WEST);
    infoArea.add(docu_dir,BorderLayout.CENTER);
    infoArea.setBackground(Color.gray);



    /*LAYOUT AND ADDING OF COMPONENTS*/
    main_panel.setLayout(new BorderLayout());
    main_panel.setBackground(Color.RED);

    main_panel.add(infoArea,BorderLayout.SOUTH);
    main_panel.add(formattingArea,BorderLayout.NORTH);
    main_panel.add(scrollPane,BorderLayout.CENTER);

        /* Add a DocumentListener to track changes in the text area
        * since it is an abstract class you must implement the methods
        * it comes with. I just put the update method that gets the lenght of the text
        *in the document listner's methods*/

        // Setting the initial char count
        updateCharCount();
        currentdirectoryDisplay();
        texteditor.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateCharCount();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateCharCount();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateCharCount();
            }
        });

        texteditor.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                currentdirectoryDisplay();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                currentdirectoryDisplay();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                currentdirectoryDisplay();
            }
        });


    }




    /*Method used to count the number of characters in the text area*/
    private void updateCharCount() {
        int charCount = texteditor.getText().length();
        char_counter.setText("Characters: " + charCount);
    }
    public void currentdirectoryDisplay() {
        if (currentFile != null) { // Check if currentFile is not null
            docu_dir.setText("                                              Current Directory: " + currentFile.getAbsolutePath());
        } else {
            docu_dir.setText("                                              Current Directory: ");
        }
    }


    /*****SETTER GETTERS*****/

    public JPanel getMain_panel() {
        return main_panel;
    }

    public void setMain_panel(JPanel main_panel) {
        this.main_panel = main_panel;
    }

    public JPanel getInfoArea() {
        return infoArea;
    }

    public void setInfoArea(JPanel infoArea) {
        this.infoArea = infoArea;
    }

    public JPanel getFormattingArea() {
        return formattingArea;
    }

    public void setFormattingArea(JPanel formattingArea) {
        this.formattingArea = formattingArea;
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public void setScrollPane(JScrollPane scrollPane) {
        this.scrollPane = scrollPane;
    }

    public JTextArea getTexteditor() {
        return texteditor;
    }

    public void setTexteditor(JTextArea texteditor) {
        this.texteditor = texteditor;
    }

    public JLabel getChar_counter() {
        return char_counter;
    }

    public void setChar_counter(JLabel char_counter) {
        this.char_counter = char_counter;
    }

    public JLabel getDocu_dir() {
        return docu_dir;
    }

    public File getCurrentFile() {
        return currentFile;
    }

    public void setCurrentFile(File currentFile) {
        this.currentFile = currentFile;
    }

    public void setDocu_dir(JLabel docu_dir) {
        this.docu_dir = docu_dir;
    }

    public JComboBox getFontBox() {
        return fontBox;
    }

    public void setFontBox(JComboBox fontBox) {
        this.fontBox = fontBox;
    }

    public JSpinner getFontsizeSpinner() {
        return fontsizeSpinner;
    }

    public void setFontsizeSpinner(JSpinner fontsizeSpinner) {
        this.fontsizeSpinner = fontsizeSpinner;
    }

    public JButton getFontcolorbutton() {
        return fontcolorbutton;
    }

    public void setFontcolorbutton(JButton fontcolorbutton) {
        this.fontcolorbutton = fontcolorbutton;
    }

    public JCheckBox getFontstyle() {
        return fontstyle;
    }

    public void setFontstyle(JCheckBox fontstyle) {
        this.fontstyle = fontstyle;
    }

    public JCheckBox getFonstyle_I() {
        return fonstyle_I;
    }

    public void setFonstyle_I(JCheckBox fonstyle_I) {
        this.fonstyle_I = fonstyle_I;
    }
    public void saveText() {
        System.out.println(texteditor.getText());
    }


    /*******************************************/

    public void actionlistener(ActionListener listener){
        this.fontBox.addActionListener(listener);
        this.fontcolorbutton.addActionListener(listener);
        this.fontstyle.addActionListener(listener);
        this.fonstyle_I.addActionListener(listener);
    }


}






