package project.cafebooker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import project.cafebooker.entity.Booker;
import project.cafebooker.service.IBookService;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("cafe")
public class BookerController {
    @Autowired
    IBookService bookService;

    @GetMapping(value = "books",
            produces = "application/json"
        )
    public List<Booker> getBooks(@RequestParam(name = "customer", required = false) String customer){
        List<Booker> list = bookService.getBook(customer);
        return list;
    }

    @PostMapping(value = "books",
        consumes = "application/json",
            produces = "application/json"
    )
    public Booker createBook(@RequestParam(name = "customer", required = true) String customer,
                             @RequestParam(name = "Date", required = true)Date date,
                             @RequestParam(name = "id", required = true) int id,
                             @RequestBody Booker booker){

        bookService.createBook(customer, date, id,booker);
        return booker;
    }

    @DeleteMapping(value = "books")
    public HttpStatus deleteBook(@RequestParam(name = "date", required = true) Date date){
        bookService.deleteBook(date);
        return HttpStatus.OK;
    }
}
