package project.cafebooker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import project.cafebooker.entity.Cafe;
import project.cafebooker.service.ICafeService;

import java.util.List;

@RestController
@RequestMapping("cafe")
public class CafeController {
    @Autowired
    ICafeService cafeService;

    @GetMapping(produces = "application/json")
    public Cafe getCafe(@RequestParam(name = "name", required = false) String name){
        Cafe foundCafe = cafeService.getCafe(name);
        return foundCafe;
    }

    @GetMapping(value = "getAll",
            produces = "application/json")
    public List<Cafe> getAllCafes(){
        List<Cafe> cafes = cafeService.getAllCafes();
        return cafes;
    }
    @PostMapping(
            value = "/admin",
            consumes = "application/json",
            produces = "application/json")
    public Cafe createCafe(@RequestBody Cafe cafe){
        cafeService.createCafe(cafe);
        return cafe;
    }


    @PutMapping(
            value = "/admin",
            consumes = "application/json",
            produces = "application/json")
    public Cafe updateCafe(@RequestParam(name = "name") String name, @RequestBody Cafe cafe){
        cafeService.updateCafe(name, cafe);
        return cafe;
    }

    @DeleteMapping(value = "/admin")
    public HttpStatus deleteCafe(@RequestParam(name = "name", required = false) String name){
        cafeService.deleteCafe(name);
        return HttpStatus.OK;
    }
}
