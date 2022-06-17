package ramallo.ProyectoHIbernet.services;

import ramallo.ProyectoHIbernet.entity.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService  {
    List <Cliente> listar();
    Optional<Cliente> poId(Long id);
    void guardar(Cliente cliente);
    void eliminar(Long id);
}
