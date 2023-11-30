package de.neuefische.cgnjava233jpademo.repo;

import de.neuefische.cgnjava233jpademo.entity.CatOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatOwnerRepo extends JpaRepository<CatOwner, Long> {
}
