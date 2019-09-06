package com.zikozee.spring5webapp.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Include
    private Long id;

    private String name;
    private String address;

    @OneToOne(mappedBy = "publisher")
    private Book book;

  public Publisher(String name, String address) {
        this.name = name;
        this.address = address;
    }
}
