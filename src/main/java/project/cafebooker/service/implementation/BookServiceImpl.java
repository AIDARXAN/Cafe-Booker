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
        Cafe cafe = cafeRepository.findById(id);
        booker.setCafe(cafe.getName());
        if (bookRepository.findByDate(booker.getDate()) != null && bookRepository.findByCafe(booker.getCafe()) != null) {
            throw new RuntimeException("This cafe is already busy");
        }
        booker.setCustomer(customer);
        bookRepository.save(booker);
        return booker;
    }

    @Override
    public HttpStatus deleteBook(int id){
        if (bookRepository.findById(id) == null)
            throw new RuntimeException("Record not found");
        Booker booker = bookRepository.findById(id);
        bookRepository.delete(booker);
        return HttpStatus.OK;
    }
}
