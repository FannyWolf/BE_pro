package de.ait.words.wordsGroup.dto;

import de.ait.words.wordsCard.dto.WordsResponseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class GroupResponseDto {

    private Long id;
    private String name;
    private Set<WordsResponseDto> words;

}

