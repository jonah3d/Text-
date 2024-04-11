import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;
import java.io.File;

/*CLASS THAT CONSTRUCTS AND EXTENDS THE JMENUBAR AND ALSO AN ACTIONLISTENER*/
public class win_menubar  {

    /*DECLARATION OF THE MENUBAR, MENU AND MENU ITEMS*/
    JMenuBar MenuBar;
    JMenu File;
    JMenu Edit;
    JMenu Run;
    JMenu Help;


    /*File Menu Items*/
    JMenuItem New;
    JMenuItem Open;
    JMenuItem Save;
    JMenuItem SaveAs;
    JMenuItem Exit;

    /*Edit Menu Items*/
    JMenuItem Theme_white;
    JMenuItem Theme_black;


    /*Run Menu Items*/
    JMenuItem Runcode;
    JMenuItem O_CommandPrompt;
    JMenuItem CompilerDir;

    /*HELP ITEMS*/
    JMenuItem Github;
    JMenuItem Documentation;
    JMenuItem Contact;

    public win_menubar(){

        /*INITIALISING THE MENUS*/
        /*---------------------------------------------------------------------------------------------*/
       MenuBar = new JMenuBar();
       //work = new workarea();

       File = new JMenu();
       Edit =  new JMenu();
       Run = new JMenu();
       Help = new JMenu();

       New = new JMenuItem("New");
       Open = new JMenuItem("Open");
       Save =  new JMenuItem("Save");
       SaveAs = new JMenuItem("Save As");
       Exit = new JMenuItem("Exit");

       Theme_black = new JMenuItem("Black Theme");
       Theme_white = new JMenuItem("White Theme");


       Runcode =  new JMenuItem("Run Code");
       O_CommandPrompt = new JMenuItem("Open CMD");
       CompilerDir = new JMenuItem("Compiler Dir");

       Github =  new JMenuItem("Github");
       Documentation =  new JMenuItem("Documentation");
       Contact =  new JMenuItem("Contact");
       /*----------------------------------------------------------------------------------------------------*/

       /*SETTING THE NAME OF THE JMENU AND ADDING OF ITS ITEMS*/
       File.setText("File");
       Edit.setText("Edit");
       Run.setText("Run");
       Help.setText("Help");

       /*-------------------------------------------------------------------------------------------------------*/
        /*ADDITION OF ITEMS*/
       /*FILE ITEMS*/
        File.add(New);
        File.add(Open);
        File.add(Save);
        File.add(SaveAs);
        File.add(Exit);

        /*EDIT ITEMS*/
        Edit.add(Theme_black);
        Edit.add(Theme_white);


        /*RUN ITEMS*/
        Run.add(Runcode);
        Run.add(O_CommandPrompt);
        Run.add(CompilerDir);

        /*HELP ITEMS*/
        Help.add(Github);
        Help.add(Documentation);
        Help.add(Contact);
        /*-------------------------------------------------------------------------------------------------------*/


       /*ADDING THE JMENUS TO THE MENU BAR*/
       MenuBar.add(File);
       MenuBar.add(Edit);
       MenuBar.add(Run);
       MenuBar.add(Help);

    }

    /*BUTTON FUNCTIONALITIES*/
    public void actionlistener(ActionListener listener){
        this.Exit.addActionListener(listener);
        this.SaveAs.addActionListener(listener);
        this.Save.addActionListener(listener);
        this.New.addActionListener(listener);
        this.Open.addActionListener(listener);

        this.Theme_black.addActionListener(listener);
        this.Theme_white.addActionListener(listener);

        this.Github.addActionListener(listener);
        this.Documentation.addActionListener(listener);

    }

}
