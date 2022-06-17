package ramallo.ProyectoHIbernet.repositories;

import jakarta.persistence.EntityManager;
import ramallo.ProyectoHIbernet.entity.Cliente;

import java.util.List;

public class ClienteRepository implements CrudRepository<Cliente> {

    private EntityManager em;

    public ClienteRepository(EntityManager em){
        this.em = em;
    }
    @Override
    public List<Cliente> listar() {
        return em.createQuery("Select c from Cliente c",Cliente.class).getResultList();
    }

    @Override
    public Cliente poId(Long id) {
        return em.find(Cliente.class,id);
    }

    @Override
    public void guardar(Cliente cliente) {

        if(cliente.getId() != null && cliente.getId()> 0){
            em.merge(cliente);
        }else{
            em.persist(cliente);

        }
    }

    @Override
    public void eliminar(Long id) {
        Cliente cliente = poId(id);
        em.remove(cliente);

    }
}
