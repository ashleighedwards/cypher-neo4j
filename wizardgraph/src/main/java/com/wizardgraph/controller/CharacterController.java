package com.wizardgraph.controller;

import com.wizardgraph.dto.FriendResponse;
import com.wizardgraph.dto.EnemyResponse;
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

    /**
     * Get the enemies of the character with the given name.
     *
     * @param name the character name from the request path
     * @return a list of enemy responses containing name and house
     */
    @GetMapping("/{name}/enemies")
    public List<EnemyResponse> getEnemies(@PathVariable String name) {
        return characterService.getEnemies(name);
    }

    /**
     * Get the mutual friends of the characters with the given names.
     * 
     * @param name the name of the first character
     * @param name2 the name of the second character
     * @return a list of friend responses containing name and house for mutual friends
     */
    @GetMapping("/{name}/mutual/{name2}")
    public List<FriendResponse> getMutualFriends(@PathVariable String name, @PathVariable String name2) {
        return characterService.getMutualFriends(name, name2);
    }
}