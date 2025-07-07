package com.sinse.hiberasync.repository;

import java.util.List;
import javax.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sinse.hiberasync.exception.FoodTypeException;
import com.sinse.hiberasync.hibernate.HibernateConfig;
import com.sinse.hiberasync.model.FoodType;

public class FoodTypeDAO {
	HibernateConfig config = HibernateConfig.getInstance();

	// select All type of food_store
	/*
	 * ORM does not directly approach the table. Therefore, even though the
	 * statement below appears to approach the table, the object in the from clause
	 * is a class, not a table.
	 */
	public List selectAll() throws Exception{
		Transaction tx = null;
		List list = null;
		// After java 7, try~with - resources is supported.. it was fetched to simplify
		// complex code
		// automatically call the close method, but it was not support all of close
		// method .. just closeable
		
		// developer just focus on try sector
		try (Session session = config.getSesstion()) {
			
			tx = session.beginTransaction();
			TypedQuery<FoodType> query = session.createQuery("from FoodType", FoodType.class);
			list = query.getResultList();
			tx.commit();
		}
		catch(Exception e) {
			e.printStackTrace();
			if(tx != null) {
				tx.rollback();
				throw new FoodTypeException("레코드 조회에 실패하였습니다.",e);
			}
		}

		return list;
	}
}
