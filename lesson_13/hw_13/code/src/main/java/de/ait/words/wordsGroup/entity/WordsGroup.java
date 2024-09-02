package de.ait.words.wordsGroup.entity;

import de.ait.words.wordsCard.entity.Word;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "groups")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WordsGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany
    @JoinTable(
            name = "word_group",
            joinColumns = @JoinColumn(name = "group_id"),
            inverseJoinColumns = @JoinColumn(name = "word_id")
    )
    private Set<Word> words = new HashSet<>();

    public void addWord(Word word) {
        if (word != null) {
            words.add(word);
        }
    }

    public void removeWord(Word word) {
        if (word != null) {
            words.remove(word);
        }
    }
}

