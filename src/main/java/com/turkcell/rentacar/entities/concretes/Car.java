package com.turkcell.rentacar.entities.concretes;

import com.turkcell.rentacar.core.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="cars")
public class Car extends BaseEntity {
    @Column(name = "modelYear")
    private int modelYear;

    @Column(name = "minimumFindexScore")
    private int minimumFindexScore;

    @Column(name = "state")//1-Available 2-Rented 3-Under Maintenance
    private int state = 1;

    @Column(name = "dailyPrice")
    private double dailyPrice;

    @ManyToOne
    @JoinColumn(name = "modelId")
    private Model model;

    @OneToMany(mappedBy = "car")
    private List<Maintenance> maintenances;

    @OneToMany(mappedBy = "car")
    private List<Rental> rentals;

}
