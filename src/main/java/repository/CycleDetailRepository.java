package repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import domain.CycleDetail;
@Repository("cycleRepo")
public class CycleDetailRepository  {
    @PersistenceContext
    private EntityManager em;
    
    @SuppressWarnings("unchecked")
	public List<CycleDetail> findTop10(){
        Query query = this.em.createQuery(" FROM CycleDetail");
        int pageNumber = 1;
        int pageSize = 10;
        query.setFirstResult((pageNumber-1) * pageSize);
        query.setMaxResults(pageSize);
        return query.getResultList();
    };
	
	@SuppressWarnings("unchecked")
	public List<CycleDetail> findBySkuId(Long skuId){
        Query query = this.em.createQuery("SELECT DISTINCT locationName FROM "
        		+ "CycleDetail cycledetail WHERE cycledetail.skuId =:skuId");
        query.setParameter("skuId", skuId );
        return query.getResultList();
	};

}
