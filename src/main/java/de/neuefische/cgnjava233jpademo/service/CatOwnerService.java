package de.neuefische.cgnjava233jpademo.service;

import de.neuefische.cgnjava233jpademo.dto.CatWithoutOwner;
import de.neuefische.cgnjava233jpademo.dto.NewCatOwnerWithoutCats;
import de.neuefische.cgnjava233jpademo.entity.Cat;
import de.neuefische.cgnjava233jpademo.entity.CatOwner;
import de.neuefische.cgnjava233jpademo.entity.CatOwnerWithCatsWithoutOwner;
import de.neuefische.cgnjava233jpademo.repo.CatOwnerRepo;
import de.neuefische.cgnjava233jpademo.repo.CatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CatOwnerService {

    private final CatOwnerRepo catOwnerRepo;
    private final CatRepository catRepository;

    public CatOwner addCatOwner(NewCatOwnerWithoutCats newCatOwnerWithoutCats) {
        return catOwnerRepo.save(
                CatOwner.builder().name(newCatOwnerWithoutCats.name()).cats(new ArrayList<>()).build()
        );
    }

    public CatOwner addCatToOwner(Long catOwnerId, Long catId) {
        CatOwner catOwner = catOwnerRepo.findById(catOwnerId).orElseThrow();
        Cat cat = catRepository.findById(catId).orElseThrow();
        catOwner.getCats().add(cat);
        return catOwnerRepo.save(catOwner);
    }

    public CatOwnerWithCatsWithoutOwner getCatOwnerById(Long id) {
        CatOwner catOwner = catOwnerRepo.findById(id).orElseThrow();
        return new CatOwnerWithCatsWithoutOwner(id, catOwner.getName(),
                catOwner.getCats().stream().map(cat -> new CatWithoutOwner(cat.getCatId(), cat.getName())).toList());
    }

    public List<CatOwner> getAllCatOwners() {
        return catOwnerRepo.findAll();
    }
}
