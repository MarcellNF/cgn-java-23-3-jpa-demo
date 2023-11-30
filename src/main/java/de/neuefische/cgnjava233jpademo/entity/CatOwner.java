package de.neuefische.cgnjava233jpademo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CatOwner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long catOwnerId;
    private String name;
    @OneToMany(mappedBy = "owner", fetch = FetchType.EAGER)
    private List<Cat> cats;

}
