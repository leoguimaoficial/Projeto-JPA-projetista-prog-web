package trabalho.banco;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	private static EntityManagerFactory entityManager;

    public static EntityManager getEntityManager(){
        if(entityManager==null){
            entityManager = Persistence.createEntityManagerFactory("projetos");
        }
        return entityManager.createEntityManager();
    }

}
