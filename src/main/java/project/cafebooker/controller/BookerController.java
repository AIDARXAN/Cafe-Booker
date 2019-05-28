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
    public List<Booker> getAllBooks(){
        List<Booker> list = bookService.getAllBooks();
        return list;
    }

    @PostMapping(value = "books",
        consumes = "application/json",
            produces = "application/json"
    )
    public Booker createBook(@RequestParam(name = "customer", required = false) String customer,
                             @RequestParam(name = "Date", required = false) Date date,
                             @RequestParam(name = "id", required = false) int id,
                             @RequestBody Booker booker){

        bookService.createBook(customer, date, id, booker);
        return booker;
    }

    @DeleteMapping(value = "books")
    public HttpStatus deleteBook(@RequestParam(name = "id", required = false) int id){
        bookService.deleteBook(id);
        return HttpStatus.OK;
    }
}
