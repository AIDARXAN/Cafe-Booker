package project.cafebooker.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import project.cafebooker.entity.Booker;
import project.cafebooker.entity.Cafe;
import project.cafebooker.repo.BookRepository;
import project.cafebooker.repo.CafeRepository;
import project.cafebooker.service.IBookService;

import java.util.Date;
import java.util.List;

@Service
public class BookServiceImpl implements IBookService {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    CafeRepository cafeRepository;

    @Override
    public List<Booker> getAllBooks(){
        List<Booker> list = bookRepository.findAll();
        return list;
    }

    @Override
    public Booker createBook(String customer, Date date, int id, Booker booker){
        booker.setDate(date);
        if (bookRepository.findByDate(booker.getDate()) != null) {
            throw new RuntimeException("This cafe is already busy");
        }
        booker.setCustomer(customer);
        Cafe cafe = cafeRepository.findById(id);
        booker.setCafe(cafe.getName());
        bookRepository.save(booker);
        return booker;
    }

    @Override
    public HttpStatus deleteBook(Date date){
        if (bookRepository.findByDate(date) == null)
            throw new RuntimeException("Record not found");
        Booker booker = bookRepository.findByDate(date);
        bookRepository.delete(booker);
        return HttpStatus.OK;
    }
}
