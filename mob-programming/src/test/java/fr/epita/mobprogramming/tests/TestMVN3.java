package fr.epita.mobprogramming.tests;


import fr.epita.mobprogramming.datamodel.Competitor;
import fr.epita.mobprogramming.services.CompetitorDataService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TestMVN3 {


    public static void main(String... args) {
        // given
        File file = new File("untitled/mob-programming/src/test/resources/contest-tokyo-grand-slam-2017 1.json");
        if (!file.exists()) {
            System.out.println("file does not exist");
            return;
        }
        CompetitorDataService ds = new CompetitorDataService(file);


        //when
        List<Competitor> competitors = ds.readAll();


        //then. assert that Mr. KUKOLJ is in the list
        if (competitors.isEmpty()) {
            System.out.println("the list was empty!");
        }
        System.out.println("list size:" + competitors.size());
        List<Competitor> entries = competitors.stream()
                .filter(c -> {
                    return c.getFamilyName().equals("KUKOLJ") && c.getGivenName().equals("Aleksandar");
                })
                .collect(Collectors.toList());
        if (entries.isEmpty()){
            System.out.println("error while loading the list");
        }

//        Map<String, List<Competitor>> collect = entries.stream().collect(Collectors.groupingBy(c -> c.getFamilyName()));
//        collect
    }
}
