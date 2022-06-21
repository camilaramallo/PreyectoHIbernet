package ramallo.ProyectoHIbernet;

import ramallo.ProyectoHIbernet.entity.Cliente;
import ramallo.ProyectoHIbernet.services.ClienteService;
import ramallo.ProyectoHIbernet.services.ClienteServiceImpl;
import ramallo.ProyectoHIbernet.util.JpaUtil;

import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

public class HibernateCrudServis {
    public static void main(String[] args){

        EntityManager em = JpaUtil.getEntityManeger();
        ClienteService service = new ClienteServiceImpl(em);

        System.out.println("========== Listar ==========");
        List<Cliente> clientes = service.listar();
        clientes.forEach(System.out::println);

        System.out.println("===========Obtener por id==========");
        Optional<Cliente> opcionalCliente = service.poId(1L);
        opcionalCliente.ifPresent(System.out::println);
        em.close();

    }
}
