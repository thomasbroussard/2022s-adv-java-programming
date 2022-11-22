package fr.epita.starwars.services;

import fr.epita.starwars.datamodel.Planet;
import org.neo4j.driver.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PlanetNeo4JDAO implements PlanetDAO{

    public List<Planet> search(Planet planets){
        Driver driver = GraphDatabase.driver("bolt://localhost:7687/neo4j",
                AuthTokens.basic("neo4j", "test"));
        Session session = driver.session();

        Transaction tx = session.beginTransaction();
        Result result = tx.run("MATCH (p) RETURN p, id(p) as i");

        List<Planet> returnedPlanets = new ArrayList<>();
        while (result.hasNext()) {
            Record row = result.next();
            Value value = row.get("p");
            Value id = row.get("i");
            Map<String, Object> properties = value.asEntity().asMap();
            System.out.println(properties);
            Planet planet = new Planet();
            planet.setName(String.valueOf(properties.get("name")));
            planet.setId(id.asInt());
            returnedPlanets.add(planet);
        }

        return returnedPlanets;


    }
}
