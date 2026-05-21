package com.wizardgraph.config;

import org.neo4j.driver.Driver;
import org.neo4j.driver.Session;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader {
    @Bean
    CommandLineRunner loadData(Driver driver) {
        return args -> {
            try (Session session = driver.session()) {

                // Create characters and relationships
                session.run("""
                    MERGE (harry:Character {name: 'Harry Potter', house: 'Gryffindor'})
                    MERGE (hermione:Character {name: 'Hermione Granger', house: 'Gryffindor'})
                    MERGE (ron:Character {name: 'Ron Weasley', house: 'Gryffindor'})
                    MERGE (draco:Character {name: 'Draco Malfoy', house: 'Slytherin'})
                    MERGE (luna:Character {name: 'Luna Lovegood', house: 'Ravenclaw'})
                    MERGE (voldemort:Character {name: 'Lord Voldemort', house: 'Slytherin'})
                    MERGE (snape:Character {name: 'Severus Snape', house: 'Slytherin'})
                    MERGE (dumbledore:Character {name: 'Albus Dumbledore', house: 'Gryffindor'})

                    MERGE (harry)-[:FRIENDS_WITH]->(hermione)
                    MERGE (harry)-[:FRIENDS_WITH]->(ron)
                    MERGE (harry)-[:FRIENDS_WITH]->(snape)
                    MERGE (hermione)-[:FRIENDS_WITH]->(ron)
                    MERGE (hermione)-[:FRIENDS_WITH]->(harry)
                    MERGE (draco)-[:FRIENDS_WITH]->(voldemort)
                    MERGE (dumbledore)-[:FRIENDS_WITH]->(harry)
                    MERGE (luna)-[:FRIENDS_WITH]->(harry)
                    MERGE (luna)-[:FRIENDS_WITH]->(hermione)
                    MERGE (luna)-[:FRIENDS_WITH]->(ron)
                    MERGE (snape)-[:FRIENDS_WITH]->(dumbledore)

                    MERGE (harry)-[:ENEMY_OF]->(draco)
                    MERGE (harry)-[:ENEMY_OF]->(voldemort)
                    MERGE (hermione)-[:ENEMY_OF]->(voldemort)
                    MERGE (ron)-[:ENEMY_OF]->(voldemort)
                    MERGE (draco)-[:ENEMY_OF]->(harry)
                    MERGE (luna)-[:ENEMY_OF]->(draco)

                """);

                System.out.println("Sample data loaded into Neo4j.");
            }
        };
    }
}