package com.wizardgraph.service;

import com.wizardgraph.dto.FriendResponse;
import com.wizardgraph.dto.EnemyResponse;
import com.wizardgraph.model.Character;
import com.wizardgraph.repository.CharacterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service layer for character lookups and related operations.
 */
@Service
public class CharacterService {
    private final CharacterRepository characterRepository;

    /**
     * Create a new CharacterService.
     *
     * @param characterRepository repository used to query character data
     */
    public CharacterService(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    /**
     * Retrieve friends of the character identified by name.
     *
     * @param name the character name to lookup
     * @return a list of friend DTOs with their name and house
     */
    public List<FriendResponse> getFriends(String name) {
        List<Character> friends = characterRepository.findFriendsByName(name);
        return friends.stream()
            .map(friend -> new FriendResponse(friend.getName(), friend.getHouse()))
            .toList();
    }

    /**
     * Retrieve enemies of the character identified by name.
     *
     * @param name the character name to lookup
     * @return a list of enemy DTOs with their name and house
     */
    public List<EnemyResponse> getEnemies(String name) {
        List<Character> enemies = characterRepository.findEnemiesByName(name);
        return enemies.stream()
            .map(enemy -> new EnemyResponse(enemy.getName(), enemy.getHouse()))
            .toList();
    }

    /**
     * Retrieve mutual friends of the characters identified by name and name2.
     *
     * @param name the name of the first character
     * @param name2 the name of the second character
     * @return a list of mutual friend DTOs with their name and house
     */
    public List<FriendResponse> getMutualFriends(String name, String name2) {
        List<Character> mutualFriends = characterRepository.findMutualFriendsByName(name, name2);
        return mutualFriends.stream()
            .map(friend -> new FriendResponse(friend.getName(), friend.getHouse()))
            .toList();
    }
}