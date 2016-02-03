/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;



public class DAOUsuario {
    SessionFactory fuck;
    Session sesion;
    Transaction tranza;
    
    public DAOUsuario() {
    fuck=HibernateUtilidades.getSessionFactory();
    sesion=fuck.openSession();
    tranza=sesion.beginTransaction();
    }
    
    public void cerrarTransaccion(){
        sesion.close();
        tranza.commit();
    }
   
    
    public void guardar(Usuario objeto)throws Exception{
        sesion.persist(objeto);
    cerrarTransaccion();
    }
    
    
    public void actualizar(Usuario objeto) throws Exception{
    sesion.update(objeto);
    cerrarTransaccion();
    
}
 public void borrar(Usuario objeto) throws Exception{
sesion.delete(objeto);
cerrarTransaccion();
}

public Usuario buscarPorId(Integer Id) throws Exception{
Usuario objeto=(Usuario)sesion.createCriteria(Usuario.class).add(Restrictions.idEq(id)).uniqueResult();
cerrarTransaccion();
return objeto;
}

public ArrayList<Usuario> buscarTodos()throws Exception{
ArrayList<Usuario> objetos=(Arraylist<Usuario>) sesion.createCriteria(Usuario.class).list();
return objetos;
}