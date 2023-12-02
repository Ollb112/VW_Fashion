package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import model.Pedido;
import model.Produto;

public class PedidoDAO extends DAO{
	public void save(Pedido pedido) throws PersistenciaDacException {
		EntityManager em = getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		try {
			em.persist(pedido);
			transaction.commit();
		} catch (PersistenceException pe) {
			pe.printStackTrace();
			if (transaction.isActive()) {
				transaction.rollback();
			}
			throw new PersistenciaDacException("Ocorreu algum erro ao tentar salvar o Pedido.", pe);
		} finally {
			em.close();
		}
	}

	public Pedido update(Pedido pedido) throws PersistenciaDacException {
		EntityManager em = getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		Pedido resultado = pedido;
		try {
			resultado = em.merge(pedido);
			transaction.commit();
		} catch (PersistenceException pe) {
			pe.printStackTrace();
			if (transaction.isActive()) {
				transaction.rollback();
			}
			throw new PersistenciaDacException("Ocorreu algum erro ao tentar atualizar o pedido.", pe);
		} finally {
			em.close();
		}
		return resultado;
	}

	public void delete(Pedido pedido) throws PersistenciaDacException {
		EntityManager em = getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		try {
			pedido = em.find(Pedido.class, pedido.getIdPedido());
			em.remove(pedido);
			transaction.commit();
		} catch (PersistenceException pe) {
			pe.printStackTrace();
			if (transaction.isActive()) {
				transaction.rollback();
			}
			throw new PersistenciaDacException("Ocorreu algum erro ao tentar remover o pedido.", pe);
		} finally {
			em.close();
		}
	}

	public Pedido getByID(String pedidoID) throws PersistenciaDacException {
		EntityManager em = getEntityManager();
		Pedido resultado = null;
		try {
			resultado = em.find(Pedido.class, pedidoID);
		} catch (PersistenceException pe) {
			pe.printStackTrace();
			throw new PersistenciaDacException("Ocorreu algum erro ao tentar recuperar o pedido com base no ID.", pe);
		} finally {
			em.close();
		}

		return resultado;
	}

	public List<Pedido> getAll() throws PersistenciaDacException {
		EntityManager em = getEntityManager();
		List<Pedido> resultado = null;
		try {
			TypedQuery<Pedido> query = em.createQuery("SELECT p FROM Pedido p", Pedido.class);
			resultado = query.getResultList();
		} catch (PersistenceException pe) {
			pe.printStackTrace();
			throw new PersistenciaDacException("Ocorreu algum erro ao tentar recuperar todos os pedidos.", pe);
		} finally {
			em.close();
		}
		return resultado;
	}
	

}
