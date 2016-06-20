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
import facebook4j.conf.ConfigurationBuilder;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.JOptionPane;

/**
 *
 * @author propa
 */
public class Metodos {

    Facebook facebook;

    public Metodos() {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthAppId("1602463666748241")
                .setOAuthAppSecret("cefb5f40109c7ce4ebf0fe790b5f616e")
                .setOAuthAccessToken("EAAWGvIugi90BABU3ZAwuJwhOUdkZCbnAwKxjhZArjcPQPZBd7VVZB0hPzHEQfUZCGV0IynUZCwcXSceYc8Wc95PoIKdZCC0wZBNbdgZAOS7NbXqhIOgfW9NVVm1mrnWizmNiXXhNiKp7VZB3aUrVVoVrM4L9GuZBj6snSwfQdHrurSomyAZDZD")
                .setOAuthPermissions("email,publish_stream,...");
        FacebookFactory ff = new FacebookFactory(cb.build());
        facebook = ff.getInstance();
    }

    public void miUsuario() throws FacebookException {
        User user = facebook.getMe();
        JOptionPane.showMessageDialog(null, "Mi nombre: \n" + user.getName());
    }

    public void buscarPersoa(String nombre) throws FacebookException {
        String ac = "";
        ResponseList<User> results = facebook.searchUsers(nombre);
        //System.out.println("Busqueda de personas con nombre :" + nombre);
        for (int i = 0; i < results.size(); i++) {
            ac = ac + (results.get(i).getName()) + "\n";
        }
        JOptionPane.showMessageDialog(null, "Busqueda de personas con nombre:\n" + nombre + "\n" + ac);
    }

    public void publicarEstado(String comentario) throws FacebookException {
        facebook.postStatusMessage(comentario);
    }

    public void publicarFoto(String rutaImagen) throws MalformedURLException, FacebookException {
        PostUpdate post = new PostUpdate(new URL("http://facebook4j.org"))
                .picture(new URL(rutaImagen))
                .name("Facebook4J - A Java library for the Facebook Graph API")
                .caption("facebook4j.org")
                .description("Facebook4J is a Java library for the Facebook Graph API.");
        facebook.postFeed(post);
    }
    
    public void ComentPhoto(String id, String comentario) throws FacebookException {
        facebook.commentPhoto(id,comentario);
    }

}
