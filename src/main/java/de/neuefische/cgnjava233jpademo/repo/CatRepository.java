package de.neuefische.cgnjava233jpademo.repo;

import de.neuefische.cgnjava233jpademo.entity.Cat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CatRepository extends JpaRepository<Cat, Long> {
    Optional<Cat> findCatByName(String name);
}
