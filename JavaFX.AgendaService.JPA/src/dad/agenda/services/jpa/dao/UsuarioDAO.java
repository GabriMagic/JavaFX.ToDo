package dad.agenda.services.jpa.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import dad.agenda.services.jpa.entities.UsuarioEntity;
import dad.agenda.services.jpa.utils.DAO;
import dad.agenda.services.jpa.utils.DAOCommand;

public class UsuarioDAO extends DAO {

	public UsuarioEntity findByCredentials(String username, String password) {
		UsuarioEntity usuario = execute(new DAOCommand<UsuarioEntity>() {
			@Override
			public UsuarioEntity doAction(EntityManager entityManager) throws PersistenceException {
				Query query = entityManager.createQuery("from UsuarioEntity u where u.username = :username and u.password = :password", UsuarioEntity.class);
				query.setParameter("username", username);
				query.setParameter("password", password);
				try {
					return (UsuarioEntity) query.getSingleResult();
				} catch (NoResultException e) {
					return null;
				}
			}
		});
		return usuario;
	}
	
	public UsuarioEntity findByUsername(String username) {
		UsuarioEntity usuario = execute(new DAOCommand<UsuarioEntity>() {
			@Override
			public UsuarioEntity doAction(EntityManager entityManager) throws PersistenceException {
				return entityManager.find(UsuarioEntity.class, username);
			}
		});
		return usuario;
	}

	public void create(UsuarioEntity usuario) {
		executeInTransaction(new DAOCommand<Void>() {
			@Override
			public Void doAction(EntityManager entityManager) throws PersistenceException {
				entityManager.persist(usuario);
				return null;
			}
		});
	}

	public void delete(UsuarioEntity usuario) {
		executeInTransaction(new DAOCommand<Void>() {
			@Override
			public Void doAction(EntityManager entityManager) throws PersistenceException {
				entityManager.remove(usuario);
				return null;
			}
		});	
	}

	public void update(UsuarioEntity usuario) {
		executeInTransaction(new DAOCommand<Void>() {
			@Override
			public Void doAction(EntityManager entityManager) throws PersistenceException {
				entityManager.merge(usuario);
				return null;
			}
		});
	}
	
}
