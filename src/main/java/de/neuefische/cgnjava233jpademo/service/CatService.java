package de.neuefische.cgnjava233jpademo.service;

import de.neuefische.cgnjava233jpademo.dto.CatOwnerWithoutCats;
import de.neuefische.cgnjava233jpademo.dto.CatWithCatOwnerWithoutCats;
import de.neuefische.cgnjava233jpademo.dto.CatWithoutOwner;
import de.neuefische.cgnjava233jpademo.dto.NewCatWithoutOwner;
import de.neuefische.cgnjava233jpademo.entity.Cat;
import de.neuefische.cgnjava233jpademo.entity.CatOwner;
import de.neuefische.cgnjava233jpademo.repo.CatOwnerRepo;
import de.neuefische.cgnjava233jpademo.repo.CatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CatService {

    private final CatRepository catRepository;
    private final CatOwnerRepo catOwnerRepo;

    public CatWithoutOwner addCat(NewCatWithoutOwner newCatWithoutOwner) {
        Cat catToSave = Cat.builder().name(newCatWithoutOwner.name()).build();
        Cat savedCat = catRepository.save(catToSave);
        return new CatWithoutOwner(savedCat.getCatId(), savedCat.getName());
    }

    public List<CatWithoutOwner> getAllCatsWithoutOwner() {
        List<Cat> allCats = getAllCats();
        return allCats.stream().map(cat -> new CatWithoutOwner(cat.getCatId(), cat.getName())).toList();
    }

    public CatWithCatOwnerWithoutCats addOwnerToCat(Long catId, Long catOwnerId) {
        Cat cat = getCatById(catId);
        CatOwner catOwner = catOwnerRepo.findById(catOwnerId).orElseThrow();
        catOwner.getCats().add(cat);
        CatOwner savedCatOwner = catOwnerRepo.save(catOwner);
        cat.setOwner(catOwner);
        Cat savedCat = catRepository.save(cat);
        return new CatWithCatOwnerWithoutCats(
                savedCat.getCatId(),
                savedCat.getName(),
                new CatOwnerWithoutCats(savedCatOwner.getCatOwnerId(), savedCatOwner.getName())
        );
    }

    private List<Cat> getAllCats() {
        return catRepository.findAll();
    }

    public Cat getCatById(Long id) {
        return catRepository.findById(id).orElseThrow();
    }

}
