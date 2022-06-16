package ramallo.ProyectoHIbernet;

import jakarta.persistence.EntityManager;
import ramallo.ProyectoHIbernet.entity.Cliente;
import ramallo.ProyectoHIbernet.util.JpaUtil;

import java.util.Scanner;

public class PorIdFind {
    public static void main(String[]args){

        Scanner s = new Scanner(System.in);

        System.out.println("ingrese id: ");
        Long id = s.nextLong();
        EntityManager em = JpaUtil.getEntityManeger();
        Cliente cliente = em.find(Cliente.class,id);

        System.out.println(cliente);
        em.close();
    }
}
