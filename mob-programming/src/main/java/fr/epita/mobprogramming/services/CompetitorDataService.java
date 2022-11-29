package fr.epita.mobprogramming.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.epita.mobprogramming.datamodel.Competitor;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class CompetitorDataService {

    private final File file;

    public CompetitorDataService(File file) {
        this.file = file;
    }

    public List<Competitor> readAll() {
        List<Competitor> result = new ArrayList<>();
        try {
            ObjectMapper mapper = new ObjectMapper();

            String content = Files.readString(file.toPath());
            List<Map<String, Object>> data =
                    mapper.readValue(content, new TypeReference<>() {
                    });

            Set<Competitor> competitorSet = new LinkedHashSet<>();
            Set<String> ids = new LinkedHashSet<>();
            for (Map<String, Object> rawContest : data) {
                String weight = String.valueOf(rawContest.get("weight"));
                String age = String.valueOf(rawContest.get("age"));
                Competitor white = new Competitor(
                        String.valueOf(rawContest.get("family_name_white")),
                        String.valueOf(rawContest.get("country_white")),
                        String.valueOf(rawContest.get("given_name_white")),
                        weight,
                        age
                );
                ids.add(String.valueOf(rawContest.get("id_person_blue")));
                Competitor blue = new Competitor(
                        String.valueOf(rawContest.get("family_name_blue")),
                        String.valueOf(rawContest.get("country_blue")),
                        String.valueOf(rawContest.get("given_name_blue")),
                        weight,
                        age
                );
                ids.add(String.valueOf(rawContest.get("id_person_white")));
                competitorSet.add(white);
                competitorSet.add(blue);
            }
            System.out.println("size of unique ids: "+ ids.size());
            return new ArrayList<>(competitorSet);
        } catch (Exception e) {
            e.printStackTrace();
            //TODO handle this exception properly
        }
        return result;
    }


}
