import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class window  {


    JFrame workspace;
    win_menubar menu;
    workarea panel;
    ImageIcon icon;

    Controls ctrl;

    window(){
        //CREATION OF THE JFRAME AND THE MAIN COMPONENTS FOUND WITHIN
        workspace = new JFrame();
        menu = new win_menubar();
        panel = new workarea();
        icon = new ImageIcon("src/main/resources/textplusplsicon_black-01.png");
        ctrl= new Controls(panel,menu);

        workspace.setTitle("Text++");
        workspace.setSize(1000,1000);
        workspace.setResizable(true);
        workspace.setLocationRelativeTo(null);

        //SETTING OF MENUBAR AND CONTENTPANE IN THE JFRAME
        workspace.setJMenuBar(menu.MenuBar);
        workspace.setContentPane(panel.main_panel);
        workspace.setIconImage(icon.getImage());

        workspace.setVisible(true);
        workspace.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

}
