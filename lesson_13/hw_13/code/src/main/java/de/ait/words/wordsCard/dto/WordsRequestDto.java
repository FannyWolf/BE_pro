package de.ait.words.wordsCard.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class WordsRequestDto {

    String language;
    String word;
    String example;
    String translateLanguage;
    String translation;
    String card_group;

}
