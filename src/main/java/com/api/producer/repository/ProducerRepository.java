package com.api.producer.repository;

import java.util.List;

import com.api.producer.interfaces.ProducerInterface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.api.producer.entity.Producer;

public interface ProducerRepository extends JpaRepository<Producer, Long> {

	@Query(nativeQuery= true, value=
			" with cte as "
			+ "(select "
			+ " 		m.year, "
			+ "		p.name,"
			+ "		("
			+ " 			SELECT "
			+ " 				m2.year "
			+ " 			FROM "
			+ " 				movie m2 "
			+ " 				INNER JOIN producer p2 "
			+ " 				ON m2.id = p2.movie_id "
			+ " 			WHERE "
			+ " 				p2.name = p.name "
			+ " 				AND m2.winner = true "
			+ " 				AND m2.YEAR > m.YEAR "
			+ " 			ORDER BY m2.year "
			+ " 			LIMIT 1 "
			+ " 		) AS nextYear "
			+ " from "
			+ " 		movie m "
			+ " 		inner join producer p "
			+ " 		on m.id = p.movie_id "
			+ " where "
			+ " 		m.winner = true "
			+ " order by "
			+ " 		p.name, m.year) "
			+ " select "
			+ " 	year, "
			+ " 	name, "
			+ " 	nextYear "
			+ " from "
			+ " 	cte "
			+ " where "
			+ "		nextYear is not null ")
	List<ProducerInterface> getAllProducersByWinner();
	
}
