package de.neuefische.cgnjava233jpademo.controller;

import de.neuefische.cgnjava233jpademo.dto.NewCatOwnerWithoutCats;
import de.neuefische.cgnjava233jpademo.entity.CatOwner;
import de.neuefische.cgnjava233jpademo.entity.CatOwnerWithCatsWithoutOwner;
import de.neuefische.cgnjava233jpademo.service.CatOwnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cat-owners")
@RequiredArgsConstructor
public class CatOwnerController {

    private final CatOwnerService catOwnerService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CatOwner addCatOwner(@RequestBody NewCatOwnerWithoutCats newCatOwnerWithoutCats) {
        return catOwnerService.addCatOwner(newCatOwnerWithoutCats);
    }

    @GetMapping
    public List<CatOwner> getAllCatOwners() {
        return catOwnerService.getAllCatOwners();
    }

    @GetMapping("/{id}")
    public CatOwnerWithCatsWithoutOwner getCatOwnerById(@PathVariable Long id) {
        return catOwnerService.getCatOwnerById(id);
    }

}
