package repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;

import domain.CycleDetail;
@Repository("cycleRepo")
public class CycleDetailRepository  {
	
    @PersistenceContext
    private EntityManager em;
    
	public List<CycleDetail> findTop10(){
        TypedQuery<CycleDetail> query = this.em.createQuery(" FROM CycleDetail",CycleDetail.class);
        int pageNumber = 1;
        int pageSize = 10;
        query.setFirstResult((pageNumber-1) * pageSize);
        query.setMaxResults(pageSize);
        return query.getResultList();
    };
	
    @PreAuthorize("hasRole('ROLE_ADMIN')")
	public List<CycleDetail> findBySkuId(Long skuId){
        TypedQuery<CycleDetail> query = this.em.createQuery("SELECT DISTINCT cycledetail FROM "
        		+ "CycleDetail cycledetail WHERE cycledetail.skuId =:skuId",CycleDetail.class);
        query.setParameter("skuId", skuId );
        return query.getResultList();
	};

}
