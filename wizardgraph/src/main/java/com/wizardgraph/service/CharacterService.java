package com.wizardgraph.service;

import com.wizardgraph.dto.FriendResponse;
import com.wizardgraph.model.Character;
import com.wizardgraph.repository.CharacterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterService {
    private final CharacterRepository characterRepository;

    public CharacterService(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    public List<FriendResponse> getFriends(String name) {
        List<Character> friends = characterRepository.findFriendsByName(name);
        return friends.stream()
            .map(friend -> new FriendResponse(friend.getName(), friend.getHouse()))
            .toList();
    }
}