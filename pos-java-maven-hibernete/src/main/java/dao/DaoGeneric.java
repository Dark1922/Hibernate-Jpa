package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import posjavamavenhibernete.HibernateUtil;

public class DaoGeneric<E> {// e de entidade

	private EntityManager entityManager = HibernateUtil.geEntityManager();

	public void salvar(E entidade) {
		
		EntityTransaction transaction = entityManager.getTransaction(); // transação
		
		transaction.begin(); //inica transação
		
	   entityManager.persist(entidade); //vai persistir a transação
	   
	   transaction.commit();// vai salvar

	}
	
	
public E updateMerge(E entidade) {//salva ou atualiza
		
		EntityTransaction transaction = entityManager.getTransaction(); // transação
		
		transaction.begin(); //inica transação
		
	  E entidadeSalva = entityManager.merge(entidade); //recebe um objeto salva se n existir , se existir atualiza
	   
	   transaction.commit();// vai salvar

	   return entidadeSalva;
	}
	
	
	public E pesquisar(E entidade) {
		
		Object id = HibernateUtil.getPrimaryKey(entidade);
		
		E e = (E) entityManager.find(entidade.getClass(), id); //find buscar
		
		return e; //pesquiso
	}
	
public E pesquisar2(Long id, Class<E> entidade) {
		E e = (E) entityManager.find(entidade, id); //find buscar
		return e; //pesquiso
	}

}
