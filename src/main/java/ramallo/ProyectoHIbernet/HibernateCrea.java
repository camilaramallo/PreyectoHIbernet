package ramallo.ProyectoHIbernet;

import jakarta.persistence.EntityManager;
import ramallo.ProyectoHIbernet.entity.Cliente;
import ramallo.ProyectoHIbernet.util.JpaUtil;

import javax.swing.*;

public class HibernateCrea {
    public static void main(String[] args){

        EntityManager em =  JpaUtil.getEntityManeger();

        try{
            //String nombre = JOptionPane.showInputDialog("Ingrese el nombre: ");
            //String apellido = JOptionPane.showInputDialog("Ingrese el apellido: ");
            //String pago = JOptionPane.showInputDialog("Ingrese forma de pago");

            em.getTransaction().begin();//comienza la tranzaccion
            Cliente c = new Cliente();
            c.setNombre("facundo");
            c.setApellido("ramallo");
            c.setFormaPago("efectivo");
            em.persist(c);//metodo persist guarda el objeto Entitie cliente
            em.getTransaction().commit();

            System.out.println("el id del cliente creado es: "+ c.getId());
            c = em.find(Cliente.class,c.getId()); //realizamos una consultadel nuevo cliente
            System.out.println(c);

        }catch(Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();

        }finally{
            em.close();
        }
    }
}
