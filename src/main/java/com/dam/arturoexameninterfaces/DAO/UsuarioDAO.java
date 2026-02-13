package com.dam.arturoexameninterfaces.DAO;

import com.dam.arturoexameninterfaces.model.Usuario;
import com.dam.arturoexameninterfaces.util.DBConnection;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UsuarioDAO {

    public Usuario login(String nombre, String contrasena){
        try(Session session = DBConnection.getInstance().getSession()){
            Usuario usuarioExiste = session.find(Usuario.class, nombre);
            if(usuarioExiste == null){
                return null;
            }
            else{
                if(usuarioExiste.getPassword().equals(contrasena)){
                    return usuarioExiste;
                }
            }
        } catch(Exception e){
            e.printStackTrace();
            System.out.println("fallo login");
            return null;
        }
        return null;
    }

    public boolean registro(Usuario usuario){
        try(Session session = DBConnection.getInstance().getSession()){
            Transaction transaction = session.beginTransaction();
            Usuario usuarioExiste = session.find(Usuario.class,usuario.getUsername());
            if(usuarioExiste == null){
                session.persist(usuario);
                transaction.commit();
                return true;
            }
            else {
                return false;
            }
        } catch(Exception e){
            e.printStackTrace();
            System.out.println("fallo registro");
            return false;
        }
    }
}
