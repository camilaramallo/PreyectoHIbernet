package ramallo.ProyectoHIbernet;


import jakarta.persistence.EntityManager;
import ramallo.ProyectoHIbernet.entity.Cliente;
import ramallo.ProyectoHIbernet.util.JpaUtil;

import javax.swing.*;

public class HibernateEditar {
    public static void main(String[]args){

        EntityManager em = JpaUtil.getEntityManeger();

        try{
            Long id = Long.valueOf(JOptionPane.showInputDialog("Ingrese id de cliente: "));
            Cliente c = em.find(Cliente.class, id);

            String nombre = JOptionPane.showInputDialog("Ingrese Nombre: ", c.getNombre());
            String apellido = JOptionPane.showInputDialog("Ingrese Apeliido: ", c.getApellido());
            String pago = JOptionPane.showInputDialog("Ingrese Forma de pago: ", c.getFormaPago());

            em.getTransaction().begin();
            c.setNombre(nombre);
            c.setApellido(apellido);
            c.setFormaPago(pago);
            em.merge(c);
            em.getTransaction().commit();

            System.out.println(c);

        }catch(Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();

        }finally{
            em.close();

        }
    }
}
