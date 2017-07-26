package com.rohan.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.rohan.model.Vender;

@Repository
@Transactional
public class VenderRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	public void addVender(Vender vender) {
		System.out.println("mile stone 02 "+vender.getCompanyName());
		entityManager.persist(vender);
		return;
	}
	
	public void deleteVender(Vender vender) {
		if(entityManager.contains(vender)) {
			entityManager.remove(vender);
		}else {
			entityManager.remove(entityManager.merge(vender));
		}
		return;
	}
	
	@SuppressWarnings("unchecked")
	public List<Vender> getAllVenders(){
		List<Vender> venders=null;
		try {
		venders= entityManager.createQuery("from Vender").getResultList();
		for(Vender v : venders) {
			System.out.println(v.getCompanyName());
		}
		}catch(Exception ex) {
			System.out.println(ex.toString());
		}
		return venders;
	}
	
	public Vender getVenderById(long id) {
		return entityManager.find(Vender.class, id);
	}
	
	
	public void updateVender(Vender vender) {
		entityManager.merge(vender);
		return;
	}
	
}
