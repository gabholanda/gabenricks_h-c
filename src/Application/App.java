/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application;

import Views.Principal;

/**
 *
 * @author HOLANDAS
 */
// Este será nosso MAIN
public class App {
    public static void main(String[] args) {
        // Programação defensiva
        try{
        Principal principal = new Principal();
        principal.setVisible(true);
        } catch (RuntimeException e){
            e.getMessage();
        }
    }
}
