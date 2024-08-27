package de.ait.code.product.entity;


import jakarta.persistence.*;
import lombok.*;

@ToString
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue
    @Column (name = "id")
    private Long id;

    @Column (name = "word")
    private String word;

    @Column (name = "language")
    private String language;

    @Column (name = "example")
    private String example;

    @Column (name = "translateLanguage")
    private String translateLanguage;

    @Column (name = "translation")
    private String translation;

    @Column (name = "card_group")
    private String card_group;


}
