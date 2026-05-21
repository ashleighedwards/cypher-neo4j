package com.wizardgraph.controller;

import com.wizardgraph.dto.FriendResponse;
import com.wizardgraph.model.Character;
import com.wizardgraph.repository.CharacterRepository;
import com.wizardgraph.service.CharacterService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for character-related endpoints.
 */
@RestController
@RequestMapping("/characters")
public class CharacterController {
    private final CharacterService characterService;
    private final CharacterRepository characterRepository;

    /**
     * Create a new CharacterController.
     *
     * @param characterService service layer for character operations
     * @param characterRepository repository for character data access
     */
    public CharacterController(CharacterService characterService, CharacterRepository characterRepository) {
        this.characterService = characterService;
        this.characterRepository = characterRepository;
    }

    /**
     * Get all characters.
     *
     * @return a list of all characters
     */
    @GetMapping
    public List<Character> getAllCharacters() {
        return characterRepository.findAll();
    }

    /**
     * Get the friends of the character with the given name.
     *
     * @param name the character name from the request path
     * @return a list of friend responses containing name and house
     */
    @GetMapping("/{name}/friends")
    public List<FriendResponse> getFriends(@PathVariable String name) {
        return characterService.getFriends(name);
    }
}