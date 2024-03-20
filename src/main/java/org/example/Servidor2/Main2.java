package org.example.Servidor2;

import static spark.Spark.*;

public class Main2 {
    public static void main(String[] args) {
        port(getPort());
        secure(getKeStore(), getPasswordKeyStore(), null,null);
        get("/local", (req, res) -> "Hola, Servidor 2");
        get("/remote", (req, res) -> "Hola, Servidor 1");
    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 5001;
    }

    static String getKeStore() {
        if (System.getenv("KEYSTORE") != null) {
            return System.getenv("KEYSTORE");
        }
        return "certificates/ecikeystore2.p12";
    }

    static String getPasswordKeyStore() {
        if (System.getenv("123456") != null) {
            return System.getenv("123456");
        }
        return "123456";
    }
}
