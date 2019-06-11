/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application;

import Views.PrincipalView;
import Views.TelaLoginView;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

/**
 *
 * @author HOLANDAS
 */
public class App {

    public static void main(String[] args) throws SQLException {

        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
            PrincipalView Login = new PrincipalView ();
            Login.setVisible(true);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
