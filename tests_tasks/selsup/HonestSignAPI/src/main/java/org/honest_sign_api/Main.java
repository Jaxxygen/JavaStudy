package org.honest_sign_api;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.TimeUnit;
public class Main
{
    public static void main( String[] args ) {
        CrptApi crptApi = new CrptApi(TimeUnit.SECONDS, 1, "https://ismp.crpt.ru/api/v3/lk/documents/create");
        ObjectMapper mapper = new ObjectMapper();
        String sign = "sign";

        try {
            byte[] bytes = Files.readAllBytes(Path.of("src/main/resources/Doc.json"));
            crptApi.createDoc(mapper.readValue(new String(bytes), CrptApi.Document.class), sign);
        } catch (InterruptedException | IOException ex) {
            ex.getStackTrace();
        }
        crptApi.shutdown();
    }
}
