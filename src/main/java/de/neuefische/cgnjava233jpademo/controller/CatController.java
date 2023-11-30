package de.neuefische.cgnjava233jpademo.controller;

import de.neuefische.cgnjava233jpademo.dto.CatWithCatOwnerWithoutCats;
import de.neuefische.cgnjava233jpademo.dto.CatWithoutOwner;
import de.neuefische.cgnjava233jpademo.dto.NewCatWithoutOwner;
import de.neuefische.cgnjava233jpademo.service.CatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cats")
@RequiredArgsConstructor
public class CatController {

    private final CatService catService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CatWithoutOwner addCat(@RequestBody NewCatWithoutOwner newCatWithoutOwner) {
        return catService.addCat(newCatWithoutOwner);
    }

    @PatchMapping("/add-owner/{catId}/{ownerId}")
    public CatWithCatOwnerWithoutCats addCatToOwner(@PathVariable Long catId, @PathVariable Long ownerId) {
        return catService.addOwnerToCat(catId, ownerId);
    }

    @GetMapping("/without-owner")
    public List<CatWithoutOwner> getAllCatsWithoutOwner() {
        return catService.getAllCatsWithoutOwner();
    }

}
