package com.wizardgraph.repository;

import com.wizardgraph.model.Character;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.List;

public interface CharacterRepository extends Neo4jRepository<Character, Long> {
    /**
     * Finds all characters that are friends with the specified character.
     *
     * @param name the name of the character whose friends to find
     * @return a list of characters that are friends with the specified character
     */
    @Query("""
        MATCH (c:Character)-[:FRIENDS_WITH]->(friend:Character) 
        WHERE c.name = $name 
        RETURN friend
        """)
    List<Character> findFriendsByName(String name);

    @Query("""
        MATCH (c:Character)-[:ENEMY_OF]->(enemy:Character) 
        WHERE c.name = $name 
        RETURN enemy
        """)
    List<Character> findEnemiesByName(String name);
}