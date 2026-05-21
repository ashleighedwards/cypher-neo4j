package com.wizardgraph.dto;

/**
 * Response DTO for an enemy's basic profile information.
 *
 * This class is used to expose an enemy's name and house affiliation
 * without including internal domain or persistence details.
 */
public class EnemyResponse {

    /** The enemy's name. */
    private String name;

    /** The enemy's house affiliation. */
    private String house;

    /**
     * Creates a new EnemyResponse with the specified name and house.
     * 
     * @param name
     * @param house
     */
    public EnemyResponse(String name, String house) {
        this.name = name;
        this.house = house;
    }

    /**
     * Returns the enemy's name.
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the enemy's house affiliation.
     *
     * @return house
     */
    public String getHouse() {
        return house;
    }
}