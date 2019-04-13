package com.company;
import com.company.models.Weather;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;


public class ReceiveData {
    public static void reveive(String ipAdress) throws Exception {

        if (ipAdress == "") {
            System.err.println("Pass the server IP!");
            return;
        }
        try (var socket = new Socket(ipAdress, 8080)) {

            var in = new Scanner(socket.getInputStream()); //read data from socket stream
            var out = new PrintWriter(socket.getOutputStream(), true); // send data


            out.println("Jestem Klientem 1");
            for (;;) {
                ObjectMapper mapper = new ObjectMapper();

                try {
// Convert JSON string to Object

                    String jsonInString =in.nextLine();
                    Weather weather1 = mapper.readValue(jsonInString, Weather.class);
                    //Print JSON text
                    //System.out.println(in.nextLine());\

                    //Convert Timestamp to Date
                    Date date=new Date(weather1.getTime());

                    System.out.println("-------------------------------------------");
                    System.out.println("Data: "+date);
                      System.out.println("Temperatura: "+weather1.getTemperature()+"°C");
                      System.out.println("Wilgotność: "+weather1.getHumidity()+"%");
                      System.out.println("Prędkośc wiatru: "+weather1.getWind()+"km/h");
                    System.out.println("Dodatkowe informacje: ");
                      weather1.getMoreInfo().forEach(arr->System.out.println(arr));
                      System.out.println("-------------------------------------------");

                    //Here if I print prettyStaff1 It should print java object
                    String prettyStaff1 = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(weather1);

                } catch (JsonGenerationException e) { //nvalid JOSN format
                    e.printStackTrace();
                } catch (JsonMappingException e) { //Can't map to java object
                    e.printStackTrace();
                }
//                out.close();
//                in.close();
            }


        } catch(Exception e){
            System.out.println("Error - connection refused");
            return;
        }

    }

}
