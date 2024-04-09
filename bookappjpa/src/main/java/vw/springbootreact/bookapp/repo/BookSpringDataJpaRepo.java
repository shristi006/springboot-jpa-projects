package vw.springbootreact.bookapp.repo;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;
import vw.springbootreact.bookapp.model.Book;


@Repository
public interface BookSpringDataJpaRepo extends JpaRepository<Book,Integer>{

	@Transactional
	Book deleteById(int id);
	
}
