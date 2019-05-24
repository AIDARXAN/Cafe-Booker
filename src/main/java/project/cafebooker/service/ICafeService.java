package project.cafebooker.service;

import org.springframework.http.HttpStatus;
import project.cafebooker.entity.Cafe;

import java.util.List;

public interface ICafeService {
    public Cafe createCafe(Cafe cafe);
    public Cafe getCafe(String name);
    public List<Cafe> getAllCafes();
    public HttpStatus deleteCafe(String name);
    public Cafe updateCafe(String name, Cafe cafe);
}