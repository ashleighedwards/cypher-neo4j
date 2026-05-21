package com.wizardgraph.service;

import com.wizardgraph.dto.FriendResponse;
import com.wizardgraph.dto.EnemyResponse;
import com.wizardgraph.model.Character;
import com.wizardgraph.repository.CharacterRepository;
import org.springframework.stereotype.Service;

import org.neo4j.driver.types.Node;
import org.neo4j.driver.types.Path;

import java.util.List;
import java.util.ArrayList;

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

    /**
     * Retrieve friend recommendations for the character identified by name.
     * 
     * @param name the character name to lookup
     * @return a list of recommended friend DTOs with their name and house
     */
    public List<FriendResponse> getFriendRecommendations(String name) {
        List<Character> recommendations = characterRepository.findFriendRecommendationsByName(name);
        return recommendations.stream()
            .map(friend -> new FriendResponse(friend.getName(), friend.getHouse()))
            .toList();
    }


    /**
     * Retrieve the shortest path of friendships between two characters identified by their names.
     * 
     * @param from the name of the starting character
     * @param to the name of the target character
     * @return a list of character names representing the shortest path
     */
    public List<FriendResponse> getShortestPath(String from, String to) {
        List<Character> path = characterRepository.findShortestPathByName(from, to);

        return path.stream()
            .map(friend -> new FriendResponse(friend.getName(), friend.getHouse()))
            .toList();
    }
}