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
                    
                    MERGE (harry)-[:FRIENDS_WITH]->(hermione)
                    MERGE (harry)-[:FRIENDS_WITH]->(ron)
                    MERGE (hermione)-[:FRIENDS_WITH]->(ron)
                    MERGE (draco)-[:FRIENDS_WITH]->(luna)
                """);

                System.out.println("Sample data loaded into Neo4j.");
            }
        };
    }
}