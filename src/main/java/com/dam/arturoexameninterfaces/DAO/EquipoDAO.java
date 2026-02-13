package com.dam.arturoexameninterfaces.DAO;

import com.dam.arturoexameninterfaces.model.Equipo;
import com.dam.arturoexameninterfaces.util.DBConnection;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class EquipoDAO {

    public List<Equipo> findAll() {
        try(Session session = DBConnection.getInstance().getSession()) {
            String hql  = "FROM Equipo";
            Query<Equipo> query = session.createQuery(hql, Equipo.class);
            List<Equipo> list = query.getResultList();
            return list;
        } catch(Exception ex) {
            ex.printStackTrace();
            System.out.println("Error findall");
            return null;
        }
    }

    public boolean crear(Equipo equipo) {
        try(Session session = DBConnection.getInstance().getSession()) {
            Transaction transaction = session.beginTransaction();
            String hql = "FROM Equipo WHERE nombre = :nombre";
            Query<Equipo> query = session.createQuery(hql, Equipo.class);
            query.setParameter("nombre", equipo.getNombre());
            Equipo e = query.uniqueResult();
            if(e == null) {
                session.persist(equipo);
                transaction.commit();
                return true;
            }
            else {
                return false;
            }
        } catch(Exception ex) {
            ex.printStackTrace();
            System.out.println("Error crear");
            return false;
        }
    }

    public boolean editar(Equipo equipo) {
        try(Session session = DBConnection.getInstance().getSession()) {
            Transaction transaction = session.beginTransaction();
            Equipo e = session.find(Equipo.class, equipo.getId());
            if(e == null) {
                return false;
            }
            else {
                session.merge(equipo);
                transaction.commit();
                return true;
            }
        } catch(Exception ex) {
            ex.printStackTrace();
            System.out.println("Error editar");
            return false;
        }
    }

    public boolean eliminar(Equipo equipo) {
        try(Session session = DBConnection.getInstance().getSession()) {
            Transaction transaction = session.beginTransaction();
            Equipo e = session.find(Equipo.class, equipo.getId());
            if(e == null) {
                return false;
            }
            else {
                session.remove(e);
                transaction.commit();
                return true;
            }
        } catch(Exception ex) {
            ex.printStackTrace();
            System.out.println("Error eliminar");
            return false;
        }
    }
}
