package de.ait.words.wordsCard.controller;

import de.ait.words.wordsCard.dto.WordsRequestDto;
import de.ait.words.wordsCard.dto.WordsResponseDto;
import de.ait.words.wordsCard.service.WordsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class WordsController {

    private final WordsService service;

    @GetMapping("/words")
    public List<WordsResponseDto> getWords() {
        return service.findAll();
    }

    @GetMapping("/words/{id}")
    public WordsResponseDto getWordsById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping("/words")
    public WordsResponseDto createWords(@RequestBody WordsRequestDto dto) {
        return service.save(dto);
    }

    @GetMapping("/words/language")
    public List<WordsResponseDto> getWordsByLanguage(
            @RequestParam(name = "language") String language,
            @RequestParam(name = "translate_language") String translate_language) {
        return service.findByLanguageAndTranslateLanguage(language, translate_language);
    }

    @GetMapping("/words/word")
    public List<WordsResponseDto> getWordsByWord(@RequestParam(name = "word") String word) {
        return service.findByWord(word);
    }

}
