package project.cafebooker.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import project.cafebooker.entity.Cafe;
import project.cafebooker.repo.CafeRepository;
import project.cafebooker.service.ICafeService;

public class CafeServiceImpl implements ICafeService {

    @Autowired
    CafeRepository cafeRepository;

    @Override
    public Cafe getCafe(String name){
        if(cafeRepository.findByName(name) == null)
            throw new RuntimeException("NOT FOUND");
        Cafe cafe = cafeRepository.findByName(name);
        return cafe;
    }

    @Override
    public Cafe createCafe(Cafe cafe){
        if (cafeRepository.findByName(cafe.getName()) != null)
            throw new RuntimeException("Entity already in database");
        cafeRepository.save(cafe);
        return cafe;
    }

    @Override
    public HttpStatus deleteCafe(String name){
        if (cafeRepository.findByName(name) == null)
            throw new RuntimeException("Record not found");
        Cafe cafe = cafeRepository.findByName(name);
        cafeRepository.delete(cafe);
        return HttpStatus.OK;
    }

    @Override
    public Cafe updateCafe(String name, Cafe cafe){
        if(cafeRepository.findByName(name) == null)
            throw new RuntimeException("Record not found");
        Cafe cafeInDb = cafeRepository.findByName(name);
        cafeInDb = cafeRepository.save(cafe);
        return cafe;
    }
}
