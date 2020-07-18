package net.doriv.onlineshop.daoimpl;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.doriv.onlineshop.dao.CatalogDAO;
import net.doriv.onlineshop.dto.Catalog;

@Repository("catalogDAO")
@Transactional
public class CatalogDAOImpl implements CatalogDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public java.util.List<Catalog> List() {
		String selectActiveCatalog = "FROM Catalog where active = :active";
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCatalog);
		query.setParameter("active", true);
		return query.getResultList();
	}

	//Get unique catalog
	@Override
	public Catalog get(int id) {
		return sessionFactory.getCurrentSession().get(Catalog.class, Integer.valueOf(id));
	}

	@Override
	public boolean add(Catalog catalog) {
		try {
			sessionFactory.getCurrentSession().persist(catalog);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Catalog catalog) {
		try {
			sessionFactory.getCurrentSession().update(catalog);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Catalog catalog) {
		catalog.setActive(false);
		try {
			sessionFactory.getCurrentSession().update(catalog);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

}
