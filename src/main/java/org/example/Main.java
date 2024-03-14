package org.example;

import spark.Spark;

import static spark.Spark.*;

import static spark.Spark.port;
import static spark.Spark.get;

public class Main {
    public static void main(String[] args) {
        secure("certificates/ecikeystore.p12", "123456", null, null);
        port(5000);
        Spark.staticFiles.location("/public");
        port(getPort());
        get("hello", (req,res) -> "Hello Docker! :3 ");

        get("/sin/:value", (req, res) -> {
            double value = Double.parseDouble(req.params(":value"));
            return Math.sin(value);
        });

        get("/cos/:value", (req, res) -> {
            double value = Double.parseDouble(req.params(":value"));
            return Math.cos(value);
        });;
    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }
}