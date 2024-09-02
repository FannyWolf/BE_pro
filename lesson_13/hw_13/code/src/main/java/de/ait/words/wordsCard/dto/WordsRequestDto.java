package de.ait.words.wordsCard.dto;

import de.ait.words.wordsGroup.entity.WordsGroup;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class WordsRequestDto {

    private String language;
    private String word;
    private String example;
    private String translateLanguage;
    private String translation;
   // private Set<WordsGroup> groups;
}

