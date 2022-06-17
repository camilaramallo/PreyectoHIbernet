package ramallo.ProyectoHIbernet.repositories;

import java.util.List;

public interface CrudRepository <T>{
    //cuatro metodos de consulta

    List<T> listar();
     T poId(Long id);
     void guardar(T t);
     void eliminar(Long t);

}
