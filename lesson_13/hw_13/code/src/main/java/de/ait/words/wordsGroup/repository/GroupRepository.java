package de.ait.words.wordsGroup.repository;


import de.ait.words.wordsGroup.entity.WordsGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<WordsGroup, Long> {
}

