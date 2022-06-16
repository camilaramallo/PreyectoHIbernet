package ramallo.ProyectoHIbernet;

import jakarta.persistence.EntityManager;
import ramallo.ProyectoHIbernet.entity.Cliente;
import ramallo.ProyectoHIbernet.util.JpaUtil;

import java.util.List;

public class HibernetListar {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManeger();
        List<Cliente> clientes = em.createQuery("Select c from Cliente c", Cliente.class).getResultList();
        clientes.forEach(  System.out:: println);
        em.close();
    }
}
