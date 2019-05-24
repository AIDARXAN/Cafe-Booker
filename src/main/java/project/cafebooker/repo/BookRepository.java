package project.cafebooker.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import project.cafebooker.entity.Cafe;

import java.awt.print.Book;
import java.util.Date;

public interface BookRepository extends JpaRepository<Cafe, Long> {
    public Book findByDate(Date Date);
}
