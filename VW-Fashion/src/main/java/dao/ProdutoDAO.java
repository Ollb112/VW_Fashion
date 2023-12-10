package dao;

import java.util.List; 

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import model.Produto;


public class ProdutoDAO extends DAO{
	public void save(Produto produto) throws PersistenciaDacException {
		EntityManager em = getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		try {
			em.persist(produto);
			transaction.commit();
		} catch (PersistenceException pe) {
			pe.printStackTrace();
			if (transaction.isActive()) {
				transaction.rollback();
			}
			throw new PersistenciaDacException("Ocorreu algum erro ao tentar salvar o Produto.", pe);
		} finally {
			em.close();
		}
	}

	public Produto update(Produto produto) throws PersistenciaDacException {
		EntityManager em = getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		Produto resultado = produto;
		try {
			resultado = em.merge(produto);
			transaction.commit();
		} catch (PersistenceException pe) {
			pe.printStackTrace();
			if (transaction.isActive()) {
				transaction.rollback();
			}
			throw new PersistenciaDacException("Ocorreu algum erro ao tentar atualizar o produto.", pe);
		} finally {
			em.close();
		}
		return resultado;
	}

	public void delete(Produto produto) throws PersistenciaDacException {
		EntityManager em = getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		try {
			produto = em.find(Produto.class, produto.getId_produto());
			em.remove(produto);
			transaction.commit();
		} catch (PersistenceException pe) {
			pe.printStackTrace();
			if (transaction.isActive()) {
				transaction.rollback();
			}
			throw new PersistenciaDacException("Ocorreu algum erro ao tentar remover o produto.", pe);
		} finally {
			em.close();
		}
	}

	public Produto getByID(String produtoID) throws PersistenciaDacException {
		EntityManager em = getEntityManager();
		Produto resultado = null;
		try {
			resultado = em.find(Produto.class, produtoID);
		} catch (PersistenceException pe) {
			pe.printStackTrace();
			throw new PersistenciaDacException("Ocorreu algum erro ao tentar recuperar o produto com base no ID.", pe);
		} finally {
			em.close();
		}

		return resultado;
	}

	public List<Produto> getAll() throws PersistenciaDacException {
		EntityManager em = getEntityManager();
		List<Produto> resultado = null;
		try {
			TypedQuery<Produto> query = em.createQuery("SELECT p FROM Produto p", Produto.class);
			resultado = query.getResultList();
		} catch (PersistenceException pe) {
			pe.printStackTrace();
			throw new PersistenciaDacException("Ocorreu algum erro ao tentar recuperar todos os produtos.", pe);
		} finally {
			em.close();
		}
		return resultado;
	}

}
