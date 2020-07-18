package net.doriv.onlineshop.daoimpl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.doriv.onlineshop.dao.ItemDAO;
import net.doriv.onlineshop.dto.Item;

@Repository("itemDAO")
@Transactional
public class ItemDAOImpl implements ItemDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Item get(int id) {
		try {
			return sessionFactory.getCurrentSession().get(Item.class, Integer.valueOf(id));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public java.util.List<Item> List() {
		return sessionFactory.getCurrentSession().createQuery("FROM item", Item.class).getResultList();
	}

	@Override
	public boolean add(Item item) {
		try {
			sessionFactory.getCurrentSession().persist(item);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(Item item) {
		try {
			sessionFactory.getCurrentSession().update(item);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(Item item) {
		try {
			item.setActive(false);
			return this.update(item);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public java.util.List<Item> listActiveItems() {
		String SelectActiveItems = "FROM Item WHERE active = :active";
		return sessionFactory.getCurrentSession().createQuery(SelectActiveItems,Item.class).setParameter("active", true).getResultList();
	}

	@Override
	public java.util.List<Item> listActiveItemsByCatalog(int id_catalog) {
		String SelectActiveItemsByCatalog = "FROM Item WHERE active = :active AND id_catalog = :id_catalog";
		return sessionFactory.getCurrentSession().createQuery(SelectActiveItemsByCatalog,Item.class).setParameter("active", true).setParameter("id_catalog",id_catalog).getResultList();
	}

	@Override
	public java.util.List<Item> getLatestActiveItems(int count) {
		String SelectActiveItemsOrderly = "FROM Item WHERE active = :active ORDER BY id_item";
		return sessionFactory.getCurrentSession().createQuery(SelectActiveItemsOrderly,Item.class).setParameter("active", true).setFirstResult(0).setMaxResults(count).getResultList();
	}

}
