package ramallo.ProyectoHIbernet;

import jakarta.persistence.EntityManager;
import ramallo.ProyectoHIbernet.entity.Cliente;
import ramallo.ProyectoHIbernet.util.JpaUtil;

import javax.annotation.processing.SupportedOptions;
import java.util.Scanner;

public class HibernateEliminar {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.println("Ingrese el Id del cliente a eliminar: ");
        Long id = s.nextLong();
        EntityManager em = JpaUtil.getEntityManeger();

        try{
            Cliente c = em.find(Cliente.class, id);
            em.getTransaction().begin();
            em.remove(c);
            em.getTransaction().commit();

        }catch(Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        }finally{
            em.close();
        }
    }
}
