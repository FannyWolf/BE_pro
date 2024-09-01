package de.ait.words.wordsCard.entity;

import de.ait.words.wordsGroup.entity.WordsGroup;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "words")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Word {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "word")
    private String word;

    @Column(name = "language")
    private String language;

    @Column(name = "example")
    private String example;

    @Column(name = "translateLanguage")
    private String translateLanguage;

    @Column(name = "translation")
    private String translation;

    @ManyToMany(mappedBy = "words")
    private Set<WordsGroup> groups = new HashSet<>();
}

