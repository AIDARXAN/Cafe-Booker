package project.cafebooker.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import project.cafebooker.entity.Cafe;

public interface CafeRepository extends JpaRepository<Cafe, Long> {
    public Cafe findByName(String name);
    public Cafe findById(int id);
}
