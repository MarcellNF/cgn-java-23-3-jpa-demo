package de.neuefische.cgnjava233jpademo.entity;

import de.neuefische.cgnjava233jpademo.dto.CatWithoutOwner;

import java.util.List;

public record CatOwnerWithCatsWithoutOwner(Long id, String name, List<CatWithoutOwner> cats) {
}
