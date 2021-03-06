package project.cafebooker.service;

import org.springframework.http.HttpStatus;
import project.cafebooker.entity.Booker;

import java.util.Date;
import java.util.List;

public interface IBookService {
    public List<Booker> getAllBooks();
    public Booker createBook(String customer, Date date, int id, Booker booker);
    public HttpStatus deleteBook(int id);


}
