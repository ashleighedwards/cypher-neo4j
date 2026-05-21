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

    /**
     * Finds all characters that are enemies of the specified character.
     * 
     * @param name the name of the character whose enemies to find
     * @return a list of characters that are enemies of the specified character
     */
    @Query("""
        MATCH (c:Character)-[:ENEMY_OF]->(enemy:Character) 
        WHERE c.name = $name 
        RETURN enemy
        """)
    List<Character> findEnemiesByName(String name);


    /**
     * Finds all characters that are friends with both the specified characters.
     *
     * @param name the name of the first character
     * @param name2 the name of the second character
     * @return a list of characters that are friends with both specified characters
     */
    @Query("""
        MATCH (c:Character)-[:FRIENDS_WITH]->(mutual:Character)<-[:FRIENDS_WITH]-(b:Character) 
        WHERE c.name = $name
        AND b.name = $name2

        RETURN mutual
        """)
    List<Character> findMutualFriendsByName(String name, String name2);
}