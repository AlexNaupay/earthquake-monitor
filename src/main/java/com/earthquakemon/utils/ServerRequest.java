package com.earthquakemon.utils;

import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class ServerRequest {

    /**
     * Metodo para leer un archivo de texto plano de la Web.
     * No recibe parametros debido a que la unica URL que se
     * Consultara es la de sismos mayores a 2.5 grados
     *
     * @return El JSON en un String
     */
    public static String request(String urlRequest) {
        String resultado = "";
        try {
            //Lógica de Lectura usando la clase URL y un StringBuilder
            URL url = new URL(urlRequest);
            URLConnection conection = url.openConnection();
            String strLine;
            BufferedReader reader = new BufferedReader(new InputStreamReader(conection.getInputStream()));
            StringBuilder builder = new StringBuilder();

            while ((strLine = reader.readLine()) != null) {
                builder.append(strLine).append("\n");
            }

            resultado = builder.toString();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    public static String requestString(String urlRequest){
        RestTemplate restTemplate = new RestTemplate();
        return   restTemplate.getForObject(urlRequest, String.class);
    }

}
