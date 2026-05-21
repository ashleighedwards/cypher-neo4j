

package com.wizardgraph.dto;

/**
 * Response DTO for a friend's basic profile information.
 *
 * This class is used to expose a friend's name and house affiliation
 * without including internal domain or persistence details.
 */
public class FriendResponse {

    /** The friend's name. */
    private String name;

    /** The friend's house affiliation. */
    private String house;

    /**
     * Creates a new FriendResponse with the specified name and house.
     * 
     * @param name
     * @param house
     */
    public FriendResponse(String name, String house) {
        this.name = name;
        this.house = house;
    }

    /**
     * Returns the friend's name.
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the friend's house affiliation.
     *
     * @return house
     */
    public String getHouse() {
        return house;
    }
}