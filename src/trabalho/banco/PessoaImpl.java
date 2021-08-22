package trabalho.banco;

import java.util.List;

import javax.persistence.EntityManager;

import trabalho.entidades.Pessoa;

public class PessoaImpl implements Banco<Pessoa>{
	public void insert(Pessoa pessoa) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(pessoa);
		entityManager.getTransaction().commit();

	}

	public void remove(Pessoa pessoa) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		entityManager.getTransaction().begin();
		entityManager.remove(pessoa);
		entityManager.getTransaction().commit();
	}

	public void update(Pessoa pessoa) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		entityManager.getTransaction().begin();
		entityManager.merge(pessoa);
		entityManager.getTransaction().commit();
	}

	public List<Pessoa> findAll() {
		EntityManager entityManager = JPAUtil.getEntityManager();

		return entityManager.createQuery("SELECT s FROM Pessoa s", Pessoa.class).getResultList();
	}

	public Pessoa findById(long id) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		return entityManager.getReference(Pessoa.class, id);
	}

}
