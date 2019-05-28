package project.cafebooker.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import project.cafebooker.entity.Booker;
import project.cafebooker.entity.Cafe;

import java.awt.print.Book;
import java.util.Date;

public interface BookRepository extends JpaRepository<Booker, Long> {
    public Booker findByDate(Date Date);
    public Booker findByCustomer(String customer);
    public Booker findByCafe(String cafe);
    public Booker findById(int id);
}
