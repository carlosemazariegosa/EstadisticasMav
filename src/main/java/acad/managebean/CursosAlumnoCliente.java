/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acad.managebean;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Named;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

/**
 *
 * @author mmarvin
 */
@Named
@javax.faces.view.ViewScoped

public class CursosAlumnoCliente implements Serializable {

    
    public CursosAlumnoCliente() {
    }

    public void onResultadoClass() {
        Client client = ClientBuilder.newClient().register(CursosAlumno.class);
        
        List<CursosAlumno> ListCursos = client.target("http://localhost:8080/Rest3/webresources/entities.acadcuralum/Consulta")
                   .queryParam("SemesAno","12010")
                   .queryParam("Facultad","0900")
                   .queryParam("Anio","00")
                   .queryParam("Carnet","   70")
                   .request(MediaType.APPLICATION_JSON).get(new GenericType<List<CursosAlumno>>(){}); 

        for (CursosAlumno val : ListCursos) {
            System.out.println(val.getCodCarr()+" "+val.getCodCurso()+" "+val.getSeccion()+" "+val.getNombre());
           
        }

    }

    public void onRestultado() {
        try {
            URL url = new URL("http://localhost:8080/Rest3/webresources/entities.acadcursosdet/count");
            HttpURLConnection conn;
            try {
                conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                conn.setRequestProperty("Accept", "application/json");
                if (conn.getResponseCode() != 200) {
                    throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
                }

                BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

                String output;
                System.out.println("Output from Server .... \n");
                while ((output = br.readLine()) != null) {
                    System.out.println(output);
                }

            } catch (IOException ex) {

            }

        } catch (MalformedURLException ex) {

        }

    }

}
