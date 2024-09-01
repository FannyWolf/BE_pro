package de.ait.words.wordsGroup.service;

import de.ait.words.wordsCard.entity.Word;
import de.ait.words.wordsCard.repository.WordsRepository;
import de.ait.words.wordsGroup.dto.GroupRequestDto;
import de.ait.words.wordsGroup.dto.GroupResponseDto;
import de.ait.words.wordsGroup.entity.WordsGroup;
import de.ait.words.wordsGroup.repository.GroupRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@AllArgsConstructor
@Service
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;
    private final WordsRepository wordsRepository;
    private final ModelMapper mapper;

    @Override
    public GroupResponseDto createGroup(GroupRequestDto dto) {
        WordsGroup group = new WordsGroup();
        group.setName(dto.getName());

        Set<Word> words = new HashSet<>();
        for (Long wordId : dto.getWordIds()) {
            Optional<Word> word = wordsRepository.findById(wordId);
            word.ifPresent(words::add);
        }
        group.setWords(words);

        WordsGroup savedGroup = groupRepository.save(group);
        return mapper.map(savedGroup, GroupResponseDto.class);
    }

    @Override
    public GroupResponseDto addWordToGroup(Long groupId, Long wordId) {
        WordsGroup group = groupRepository.findById(groupId)
                .orElseThrow(() -> new RuntimeException("Group not found"));

        Word word = wordsRepository.findById(wordId)
                .orElseThrow(() -> new RuntimeException("Word not found"));

        group.addWord(word);
        WordsGroup updatedGroup = groupRepository.save(group);

        return mapper.map(updatedGroup, GroupResponseDto.class);
    }

    @Override
    public GroupResponseDto removeWordFromGroup(Long groupId, Long wordId) {
        WordsGroup group = groupRepository.findById(groupId)
                .orElseThrow(() -> new RuntimeException("Group not found"));

        Word word = wordsRepository.findById(wordId)
                .orElseThrow(() -> new RuntimeException("Word not found"));

        group.removeWord(word);
        WordsGroup updatedGroup = groupRepository.save(group);

        return mapper.map(updatedGroup, GroupResponseDto.class);
    }
}
