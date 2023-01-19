/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.kata7;

/**
 *
 * @author Guillermo
 */
import java.util.ArrayList;
import static spark.ExceptionMapper.getInstance;
import static spark.Spark.*;

public class NewProyectKata7 {

    public static void main(String[] args) {
        FlightApp flightApp = new FlightApp();

        get("/flights/all", (req, res) -> {
            return flightApp.getAll();
        });

        get("/flights/day/:day", (req, res) -> {
            return flightApp.getDay(req.params(":day"));
        });

        get("/flights/distance/bigger/:distance", (req, res) -> {
            return "distancia de vuelo " + req.params("distance");
        });

        get("/flights/distance/lower/:distance", (req, res) -> {
            return flightApp.getLowerDistance(req.params(":distance"));
        });

        get("/flights/cancelled", (req, res) -> {
            return flightApp.getCancelled();
        });

        get("/flights/diverted", (req, res) -> {
            return flightApp.getDiverted();
        });

    }

    public static void stop() {
        stop();
    }
}
