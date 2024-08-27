package de.ait.words.wordsCard.repository;

import de.ait.words.wordsCard.entity.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface WordsRepository extends JpaRepository<Word, Long> {

    List<Word> findByLanguageAndTranslateLanguage(String language, String translateLanguage);

    List<Word> findByWord(String word);

}
