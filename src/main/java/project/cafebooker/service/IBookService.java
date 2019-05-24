package project.cafebooker.service;

import org.springframework.http.HttpStatus;
import project.cafebooker.entity.Booker;

import java.util.Date;

public interface IBookService {
    public Booker createBook(String customer, Date date, String name);
    public HttpStatus deleteBook(String customer, Date date);


}
