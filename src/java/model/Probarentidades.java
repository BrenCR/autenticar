package model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author T-101
 */
public class Probarentidades {
    public static void main (String[] args){
        try{
            DAOUsuario dao=new DAOUsuario();
            Usuario g=new Usuario("Juan", "Campos");
            dao.guardar(g);
        
            System.out.println("Transaccion Exitosa");
    }catch(Exception e){
        System.out.println(e.getMessage());
    }
  }
}
