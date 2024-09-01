package de.ait.words.wordsGroup.controller;

import de.ait.words.wordsGroup.dto.GroupRequestDto;
import de.ait.words.wordsGroup.dto.GroupResponseDto;
import de.ait.words.wordsGroup.service.GroupService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/groups")
public class GroupController {    // !!!!!!

    private final GroupService groupService;

    @PostMapping
    public GroupResponseDto createGroup(@RequestBody GroupRequestDto dto) {
        return groupService.createGroup(dto);
    }

    @PostMapping("/{groupId}/words/{wordId}")
    public GroupResponseDto addWordToGroup(@PathVariable Long groupId, @PathVariable Long wordId) {
        return groupService.addWordToGroup(groupId, wordId);
    }

    @DeleteMapping("/{groupId}/words/{wordId}")
    public GroupResponseDto removeWordFromGroup(@PathVariable Long groupId, @PathVariable Long wordId) {
        return groupService.removeWordFromGroup(groupId, wordId);
    }
}

