package service;

import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import bean.Applicant;
import service_bean.EntityManagerFactoryBean;

@Stateful
public class ApplicantService {
	private EntityManagerFactory factory;

	public ApplicantService(EntityManagerFactoryBean factoryBean) {
		factory = factoryBean.getEntityManagerFactory();
	}

	public List<Applicant> getApplicantsOrdered() {
		EntityManager em = factory.createEntityManager();
        Query query = em.createNamedQuery(
            "Applicant.findAllOrderByScore");
        List<Applicant> ApplicantsOrdered = query.getResultList();
        return ApplicantsOrdered;
	}
	
	public List<Applicant> getApplicants() {
		EntityManager em = factory.createEntityManager();
        Query query = em.createNamedQuery(
            "Applicant.findAll");
        List<Applicant> Applicants = query.getResultList();
        return Applicants;
	}
	
	public List<Applicant> findById(Integer id) {
		EntityManager em = factory.createEntityManager();
        Query query = em.createNamedQuery(
            "Applicant.findById").setParameter("id", id);
        return query.getResultList();
    }
		
	public void update(Applicant applicant) {
		EntityManager em = factory.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		txn.begin();
//		em.persist(applicant);
		applicant.setId(applicant.getId());
		Applicant existingApplicant = em.merge(applicant);
		em.persist(existingApplicant);
        txn.commit();
    }
	
	public Applicant getApplicant (int id) {
		EntityManager em = factory.createEntityManager();
		return em.find(Applicant.class, id);
	}
	
}
