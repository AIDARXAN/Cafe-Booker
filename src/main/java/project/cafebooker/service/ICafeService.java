package project.cafebooker.service;

import org.springframework.http.HttpStatus;
import project.cafebooker.entity.Cafe;

public interface ICafeService {
    public Cafe createCafe(Cafe cafe);
    public Cafe getCafe(String name);
    public HttpStatus deleteCafe(int id);
    public Cafe updateCafe(Cafe cafe);
}