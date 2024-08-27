package de.ait.words.wordsCard.service;

import de.ait.words.wordsCard.dto.WordsRequestDto;
import de.ait.words.wordsCard.dto.WordsResponseDto;

import java.util.List;

public interface WordsService {

    List<WordsResponseDto> findAll();
    WordsResponseDto save(WordsRequestDto dto);
    WordsResponseDto findById(Long id);
    List<WordsResponseDto> findByLanguageAndTranslateLanguage(String language, String translateLanguage);
    List<WordsResponseDto> findByWord(String word);
}
