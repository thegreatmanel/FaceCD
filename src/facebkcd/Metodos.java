/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facebkcd;

import facebook4j.Comment;
import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.PostUpdate;
import facebook4j.ResponseList;
import facebook4j.User;
import facebook4j.auth.AccessToken;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.JOptionPane;

/**
 *
 * @author propa
 */
public class Metodos {

    Facebook facebook = new FacebookFactory().getInstance(new AccessToken("EAA"
            + "CEdEose0cBAPrrsiZBAvdqsMTQMRi0JUUo12Yl6qzkaf8y6RYqu5uI62QX8qEm2"
            + "ZBw45RuQ9oJaH3xQghMoEYHNW9leaezxivEPLKiPpaz74xaNEVZBZCZAeWwx9bv"
            + "INBY1CutN4S0NZBojpd15XupO6nxuWvYhWnObXlfRCKQZDZD"));

    public void miUsuario() throws FacebookException {
        User user = facebook.getMe();
        JOptionPane.showMessageDialog(null, "Mi nombre: \n" + user.getName());
    }

}
