package de.ait.words.wordsCard.service;

import de.ait.words.wordsCard.dto.WordsRequestDto;
import de.ait.words.wordsCard.dto.WordsResponseDto;
import de.ait.words.wordsCard.entity.Word;
import de.ait.words.wordsCard.repository.WordsRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class WordsServiceImpl implements WordsService {

    private final WordsRepository repository;
    private final ModelMapper mapper;


    @Override
    public List<WordsResponseDto> findAll() {
        return repository.findAll().stream()
                .map(e -> mapper.map(e, WordsResponseDto.class))
                .toList();
    }

    @Override
    public WordsResponseDto save(WordsRequestDto dto) {
        Word entity = mapper.map(dto, Word.class);
        Word newWord = repository.save(entity);
        return mapper.map(newWord, WordsResponseDto.class);
    }

    @Override
    public WordsResponseDto findById(Long id) {
        Optional<Word> productById = repository.findById(id);
        return productById
                .map(p -> mapper.map(p, WordsResponseDto.class))
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    @Override
    public List<WordsResponseDto> findByLanguageAndTranslateLanguage(String language, String translateLanguage) {
        return repository.findByLanguageAndTranslateLanguage(language, translateLanguage).stream()
                .map(e -> mapper.map(e, WordsResponseDto.class))
                .toList();
    }

    @Override
    public List<WordsResponseDto> findByWord(String word) {
        return repository.findByWord(word).stream()
                .map(e -> mapper.map(e, WordsResponseDto.class))
                .toList();
    }

}
