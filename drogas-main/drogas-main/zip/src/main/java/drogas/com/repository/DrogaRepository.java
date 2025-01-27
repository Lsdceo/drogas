package drogas.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import drogas.com.model.DrogaModel;

@Repository
public interface DrogaRepository extends JpaRepository <DrogaModel, Long> {
	
}
