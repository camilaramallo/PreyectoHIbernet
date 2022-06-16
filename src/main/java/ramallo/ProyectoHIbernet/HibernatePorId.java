package ramallo.ProyectoHIbernet;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import ramallo.ProyectoHIbernet.entity.Cliente;
import ramallo.ProyectoHIbernet.util.JpaUtil;

import java.util.Scanner;

public class HibernatePorId {
    public static void main(String[] args){

        Scanner s = new Scanner(System.in);

        EntityManager em = JpaUtil.getEntityManeger();
        Query query = em.createQuery("Select c from Cliente c where c.id=?1", Cliente.class);//devuelve un obj query

        System.out.println("Ingrese id:" );
        Long pago = s.nextLong();
        query.setParameter(1,pago);
        Cliente c = (Cliente) query.getSingleResult();//c/getSingleResult la consulta devuelve un solo registro
        System.out.println(c);
        em.close();
    }

}
