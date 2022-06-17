package ramallo.ProyectoHIbernet.services;

import jakarta.persistence.EntityManager;
import ramallo.ProyectoHIbernet.entity.Cliente;
import ramallo.ProyectoHIbernet.repositories.ClienteRepository;
import ramallo.ProyectoHIbernet.repositories.CrudRepository;

import java.util.List;
import java.util.Optional;

public class ClienteServiceImpl implements ClienteService {

    private EntityManager em;
    private CrudRepository<Cliente> repository;

    public ClienteServiceImpl(EntityManager em){
        this.em = em;
        this.repository = new ClienteRepository(em);
    }
    @Override
    public List<Cliente> listar() {
        return repository.listar() ;
    }

    @Override
    public Optional<Cliente> poId(Long id) {
        return Optional.ofNullable(repository.poId(id));
    }

    @Override
    public void guardar(Cliente cliente) {
        try{
            em.getTransaction().begin();
            repository.guardar(cliente);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(Long id) {
        try{
            em.getTransaction().begin();
            repository.eliminar(id);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }
}
