package org.example.Servidor1;

import spark.Spark;

import static spark.Spark.*;

import static spark.Spark.port;
import static spark.Spark.get;

public class Main1 {
    public static void main(String[] args) {
        port(getPort());
        secure(getKeStore(), getPasswordKeyStore(), null,null);
        Spark.staticFiles.location("/public");
        get("/local", (req, res) -> "Hola, Servidor 1");
        get("/remote", (req, res) -> "Hola, Servidor 2");

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
        return 5000;
    }

    static String getKeStore() {
        if (System.getenv("KEYSTORE") != null) {
            return System.getenv("KEYSTORE");
        }
        return "certificates/ecikeystore.p12";
    }

    static String getPasswordKeyStore() {
        if (System.getenv("123456") != null) {
            return System.getenv("123456");
        }
        return "123456";
    }
}