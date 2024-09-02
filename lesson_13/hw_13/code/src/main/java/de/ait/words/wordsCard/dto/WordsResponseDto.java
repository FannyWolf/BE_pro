package de.ait.words.wordsCard.dto;

import de.ait.words.wordsGroup.entity.WordsGroup;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class WordsResponseDto {

    private Long id;
    private String language;
    private String word;
    private String example;
    private String translateLanguage;
    private String translation;
    //private Set<WordsGroup> groups;
}

