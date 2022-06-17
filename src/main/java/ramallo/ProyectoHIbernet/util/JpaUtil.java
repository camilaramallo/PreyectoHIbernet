package ramallo.ProyectoHIbernet.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaUtil {
    //creamos una constantte EntityManagerFactory
    private static final EntityManagerFactory entityManagerFactory = builderEntityManagerFactory();

    private static EntityManagerFactory builderEntityManagerFactory(){
        return Persistence.createEntityManagerFactory("MySqlHibernet");
    }

    //crea y devuelve EntityManager por cada consulta o hilo // siempre va a usar  o devolver la misma intancia del "entityManagerFactory"
    public static EntityManager getEntityManeger(){
        return entityManagerFactory.createEntityManager();
    }
}
