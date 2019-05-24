package project.cafebooker.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
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


}
