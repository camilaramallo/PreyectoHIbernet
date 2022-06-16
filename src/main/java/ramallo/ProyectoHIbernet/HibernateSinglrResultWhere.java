package ramallo.ProyectoHIbernet;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import ramallo.ProyectoHIbernet.entity.Cliente;
import ramallo.ProyectoHIbernet.util.JpaUtil;

import java.util.Scanner;

public class HibernateSinglrResultWhere {
    public static void main(String[] args){

        Scanner s = new Scanner(System.in);

        EntityManager em = JpaUtil.getEntityManeger();
        Query query = em.createQuery("Select c from Cliente c where c.formaPago=?1", Cliente.class);//devuelve un obj query

        System.out.println("Ingrese forma de pago:" );
        String pago = s.next();
        query.setParameter(1,pago);
        query.setMaxResults(1);//devuelve el primer registro (uno solo)
        Cliente c = (Cliente) query.getSingleResult();//c/getSingleResult la consulta devuelve un solo registro
        System.out.println(c);
        em.close();
    }

}
