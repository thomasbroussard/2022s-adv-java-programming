package fr.epita.starwars.services;

import fr.epita.starwars.datamodel.Planet;

import java.util.Arrays;
import java.util.List;

public class MockPlanetDAO implements PlanetDAO{
    @Override
    public List<Planet> search(Planet planets) {
            return  Arrays.asList(getPlanet(1, "Dagobah"), getPlanet(2, "Tatooine"));
    }

    private static Planet getPlanet(int id, String name) {
        Planet planet = new Planet();
        planet.setId(id);
        planet.setName(name);
        return planet;
    }
}
