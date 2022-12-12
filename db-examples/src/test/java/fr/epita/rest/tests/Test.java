package fr.epita.rest.tests;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.epita.starwars.launcher.Main;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Test {

    @org.junit.jupiter.api.Test
    public void testRest() throws IOException {


        //given:
        // - server started
        // - url
        Main.main(null);
        String spec = "http://localhost:8098/test";

        //when call get on the url
        String content = getFromUrl(spec);

        //then
        System.out.println("content:" +  content);
        ObjectMapper mapper = new ObjectMapper();

        List<Map<String, Object>> maps = mapper.readValue(content, new TypeReference<List<Map<String, Object>>>() {
        });

        Assertions.assertEquals("Dagobah", String.valueOf(maps.get(0).get("name")));


    }


    @org.junit.jupiter.api.Test
    public void testRestFailing() throws IOException {


        //given:
        // - server started
        // - url
        Main.main(null);
        String spec = "http://localhost:8098/test2";

        IOException ioe = null;

        try {
            //when call get on the url
            String content = getFromUrl(spec);

        }catch (IOException e){
            ioe = e;
        }

        Assertions.assertTrue(ioe != null);

    }

    private static String getFromUrl(String spec) throws IOException {
        URLConnection urlConnection = new URL(spec).openConnection();
        urlConnection.connect();
        InputStream inputStream = urlConnection.getInputStream();
        String content = "";
        Scanner scanner = new Scanner(inputStream);
        while (scanner.hasNext()){
           content +=  scanner.nextLine();
        }
        return content;
    }
}
