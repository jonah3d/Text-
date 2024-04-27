import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.util.Scanner;

//MAIN CONTROL CLASS

public class Controls implements ActionListener {
    workarea WA;
    win_menubar MB;
    window wdw;
    ContactForm CF;
    Person person = new Person();


    public Controls(workarea WA, win_menubar MB) {
        this.WA = WA;
        this.MB = MB;


        WA.actionlistener(this);
        MB.actionlistener(this);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == WA.fontBox) {
            WA.texteditor.setFont(new Font((String) WA.fontBox.getSelectedItem(), Font.PLAIN, WA.texteditor.getFont().getSize()));
        }
        if (e.getSource() == WA.fontcolorbutton) {
            JColorChooser colorChooser = new JColorChooser();

            Color color = colorChooser.showDialog(null, "Choose A Color", Color.BLACK);
            WA.texteditor.setForeground(color);
        }
        if (e.getSource() == WA.fontstyle) {
            if (WA.fontstyle.isSelected()) {
                WA.texteditor.setFont(new Font(WA.texteditor.getFont().getFamily(), Font.BOLD, WA.texteditor.getFont().getSize()));
            } else
                WA.texteditor.setFont(new Font(WA.texteditor.getFont().getFamily(), Font.PLAIN, WA.texteditor.getFont().getSize()));

        }
        if (e.getSource() == WA.fonstyle_I) {
            if (WA.fontstyle.isSelected()) {
                WA.texteditor.setFont(new Font(WA.texteditor.getFont().getFamily(), Font.ITALIC, WA.texteditor.getFont().getSize()));
            } else
                WA.texteditor.setFont(new Font(WA.texteditor.getFont().getFamily(), Font.PLAIN, WA.texteditor.getFont().getSize()));

        }
        /*EXIT BUTTON LOGIC*/
        if (e.getSource() == MB.Exit) {
            System.exit(0);
        }
        /*SAVE AS BUTTON LOGIC*/
        if (e.getSource() == MB.SaveAs) {

            JFileChooser fileChooser = new JFileChooser();


            int resp = fileChooser.showSaveDialog(null);
            if (resp == JFileChooser.APPROVE_OPTION) {
                PrintWriter fileOut = null;

                WA.setCurrentFile(new File(fileChooser.getSelectedFile().getAbsolutePath()));
                try {
                    fileOut = new PrintWriter(WA.getCurrentFile());
                    String text = WA.getTexteditor().getText();
                    fileOut.println(text);
                } catch (Exception e1) {
                    e1.printStackTrace();
                } finally {
                    if (fileOut != null) {
                        fileOut.close();
                    }
                }
            }
        }

        /*SAVE LOGIC*/
        if (e.getSource() == MB.Save) {

            if (WA.getCurrentFile() != null) {
                PrintWriter fileOut = null;
                try {
                    fileOut = new PrintWriter(WA.getCurrentFile().getAbsolutePath());
                    String text = WA.getTexteditor().getText();
                    fileOut.println(text);
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                } finally {
                    if (fileOut != null) {
                        fileOut.close();
                    }
                }
            } else {
                JFileChooser fileChooser = new JFileChooser();
                int resp = fileChooser.showSaveDialog(null);
                if (resp == JFileChooser.APPROVE_OPTION) {
                    PrintWriter fileOut = null;

                    WA.setCurrentFile(new File(fileChooser.getSelectedFile().getAbsolutePath()));
                    try {
                        fileOut = new PrintWriter(WA.getCurrentFile());
                        String text = WA.getTexteditor().getText();
                        fileOut.println(text);
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    } finally {
                        if (fileOut != null) {
                            fileOut.close();
                        }
                    }
                }

            }
        }
        //*OPEN BUTTON LOGIC*//
        if (e.getSource() == MB.Open) {
            JFileChooser chooser = new JFileChooser();
            int result = chooser.showOpenDialog(null);
            chooser.setVisible(true);
            if (result == JFileChooser.APPROVE_OPTION) {
                //File file = new File(chooser.getSelectedFile().toString());
                WA.setCurrentFile(new File(chooser.getSelectedFile().toString()));
                try {

                    //WA.getTexteditor().setText("");
                    Scanner std = new Scanner(WA.getCurrentFile());
                    if (WA.getCurrentFile().isFile()) {
                        while (std.hasNextLine()) {
                            String data = std.nextLine();
                            WA.getTexteditor().append(data + "\n");
                        }
                    }
                    std.close();
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        }

        /**NEW LOGIC**/
        if (e.getSource() == MB.New) {
            window win = new window();
            win.workspace.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        }

        /**GITHUB LOGIC**/
        if (e.getSource() == MB.Github) {
            try {
                Desktop.getDesktop().browse(new URI("https://github.com/jonah3d/Textplusplus.git"));
            } catch (Exception dk) {
                System.out.println(dk.getMessage());
            }

        }


        /**CONTACT LOGIC**/
        if (e.getSource() == MB.Contact) {

            CF = new ContactForm();
            CF.actionlistener(this);
            ContactFormControl control = new ContactFormControl(CF);
            CF.ContactFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        }


        /**RUN LOGIC**/
        if (e.getSource() == MB.Runcode) {
            File file = WA.getCurrentFile();
            if (file != null) {
                // Extract file name without extension
                String fileName = file.getName();
                int dotIndex = fileName.lastIndexOf('.');
                String programName = (dotIndex == -1) ? fileName : fileName.substring(0, dotIndex);

                try {
                    // Create a temporary batch file
                    File batchFile = File.createTempFile("run", ".bat");
                    PrintWriter writer = new PrintWriter(batchFile);
                    writer.println("@echo off");
                    writer.println("gcc " + file.getAbsolutePath() + " -o " + programName + ".exe");
                    writer.println("if %errorlevel% neq 0 (");
                    writer.println("    echo Compilation failed.");
                    writer.println("    pause");
                    writer.println(") else (");
                    writer.println("    " + programName + ".exe");
                    writer.println("    echo.");
                    writer.println("    pause");
                    writer.println(")");
                    writer.close();



                    // Execute the batch file using cmd.exe
                    Process process = Runtime.getRuntime().exec("cmd /c start cmd.exe /K " + batchFile.getAbsolutePath());
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            } else {
                JOptionPane.showMessageDialog(null, "No file selected.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }




        /**********************************************************************************************************************************/
        /**************************THEME CHANGE*********************************************************************************/
        if (e.getSource() == MB.Theme_black) {
            WA.getInfoArea().setBackground(Color.BLACK);
            WA.docu_dir.setForeground(Color.WHITE);
            WA.char_counter.setForeground(Color.WHITE);
            WA.getFormattingArea().setBackground(Color.BLACK);
            WA.fontsizelabel.setForeground(Color.WHITE);
            WA.fonttype.setForeground(Color.WHITE);
            WA.fontcolor.setForeground(Color.WHITE);
            WA.fontstyle.setForeground(Color.WHITE);
            WA.fonstyle_I.setForeground(Color.WHITE);
            WA.getTexteditor().setBackground(Color.BLACK);
            WA.getTexteditor().setForeground(Color.WHITE);

        } else if (e.getSource() == MB.Theme_white) {
            WA.getInfoArea().setBackground(Color.WHITE);
            WA.docu_dir.setForeground(Color.BLACK);
            WA.char_counter.setForeground(Color.BLACK);
            WA.getFormattingArea().setBackground(Color.WHITE);
            WA.fontsizelabel.setForeground(Color.BLACK);
            WA.fonttype.setForeground(Color.BLACK);
            WA.fontcolor.setForeground(Color.BLACK);
            WA.fontstyle.setForeground(Color.BLACK);
            WA.fonstyle_I.setForeground(Color.BLACK);
            WA.getTexteditor().setBackground(Color.WHITE);
            WA.getTexteditor().setForeground(Color.BLACK);
        }
    }

}

