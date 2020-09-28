package com.Audrius.NamuDarbas.namudarbas.model;

import lombok.Data;


import javax.persistence.*;

@Data
@Entity
@Table(name = "phones")
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String manufacturer;
    private String model;
    private String releaseYear;
// nera geteriu ir seteriu nes naudojam lombok, mapina per @data anotacija

}
