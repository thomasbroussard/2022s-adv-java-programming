package fr.epita.starwars.services;

import fr.epita.starwars.datamodel.Planet;
import org.neo4j.driver.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PlanetNeo4JDAO implements PlanetDAO{

    public List<Planet> search(Planet planets){
        Driver driver = GraphDatabase.driver("bolt://localhost:7687/starwars",
                AuthTokens.basic("neo4j", "test"));
        Session session = driver.session();

        Transaction tx = session.beginTransaction();
        Result result = tx.run("MATCH (p) RETURN p");

        System.out.println(result.stream().count());
        List<Planet> returnedPlanets = new ArrayList<>();
        while (result.hasNext()) {
            Record row = result.next();
            Value value = row.get("p");
            Map<String, Object> properties = value.asEntity().asMap();
            System.out.println(properties);
            Planet planet = new Planet();
            planet.setName(String.valueOf(properties.get("name")));
            planet.setId((Integer)properties.get("id"));
            returnedPlanets.add(planet);
        }

        return returnedPlanets;


    }
}
