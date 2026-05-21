package com.wizardgraph.model;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

/**
 * Represents a wizard character stored as a Neo4j node.
 *
 * Each character has a generated database id, a name, and an affiliated house.
 */
@Node
public class Character {

    /** Unique identifier assigned by Neo4j. */
    @Id
    @GeneratedValue
    private Long id;

    /** The character's name. */
    private String name;

    /** The house or faction the character belongs to. */
    private String house;

    /**
     * Default constructor required by Spring Data Neo4j.
     */
    public Character() {}

    /**
     * Creates a new Character with the provided name and house.
     *
     * @param name the character's name
     * @param house the character's house or faction
     */
    public Character(String name, String house) {
        this.name = name;
        this.house = house;
    }

    /**
     * Returns the generated identifier for this character.
     *
     * @return id value assigned by Neo4j
     */
    public Long getId() {
        return id;
    }

    /**
     * Returns the character's name.
     *
     * @return the name of the character
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the house affiliation for this character.
     *
     * @return the house name
     */
    public String getHouse() {
        return house;
    }
}