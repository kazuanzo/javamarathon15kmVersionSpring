package javamarathon15km.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javamarathon15km.domain.Shops;

@Repository
public interface ShopsRepository extends JpaRepository<Shops, Integer>{
	@Query(name = "findByShops")
	public List<Shops> findByNamedQuery(@Param("color") String color,@Param("gender") int gender);
	
@Query(name = "findSelectColor")
public List<String> findBySelectColor(@Param("gender") int gender);
}



