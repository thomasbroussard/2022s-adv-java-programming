package fr.epita.starwars.services;

import fr.epita.starwars.datamodel.Planet;

import java.util.List;

public interface PlanetDAO {

    List<Planet> search(Planet planets);
}
