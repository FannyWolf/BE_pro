package de.ait.words.wordsGroup.service;

import de.ait.words.wordsGroup.dto.GroupRequestDto;
import de.ait.words.wordsGroup.dto.GroupResponseDto;

public interface GroupService {

    GroupResponseDto createGroup(GroupRequestDto dto);

    GroupResponseDto addWordToGroup(Long groupId, Long wordId);

    GroupResponseDto removeWordFromGroup(Long groupId, Long wordId);
}


