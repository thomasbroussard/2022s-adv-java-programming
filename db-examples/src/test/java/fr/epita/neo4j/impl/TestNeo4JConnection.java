package fr.epita.neo4j.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.neo4j.driver.*;

import java.util.Map;

public class TestNeo4JConnection {


    @Test
    public void test(){
        Driver driver = GraphDatabase.driver("bolt://localhost:7687/starwars",
                AuthTokens.basic("neo4j", "test"));
        Session session = driver.session();
        Assertions.assertTrue(session.isOpen());

        Transaction tx = session.beginTransaction();
        Result result = tx.run("MATCH (p) RETURN p");

        System.out.println(result.stream().count());
        while (result.hasNext()) {
            Record row = result.next();
            Value value = row.get("p");
            Map<String, Object> properties = value.asEntity().asMap();
            System.out.println(properties);
        }




    }

}
