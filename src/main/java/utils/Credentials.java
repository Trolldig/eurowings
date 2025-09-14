package utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.util.Properties;

public final class Credentials {
    private static final Properties P = new Properties();

    static {
        try (InputStream in = Credentials.class
                .getClassLoader()
                .getResourceAsStream("credentials.properties")) {
            if (in == null) {
                throw new IllegalStateException(
                        "credentials.properties nicht gefunden. Lege sie unter src/test/resources ab."
                );
            }
            P.load(in);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public static String user() {
        return req("login.user");
    }

    public static String user2() {
        return req("login.user2");
    }


    public static String password() {
        return req("login.password");
    }

    private static String req(String key) {
        String v = P.getProperty(key);
        if (v == null || v.isBlank()) {
            throw new IllegalStateException("Property fehlt oder leer: " + key);
        }

        return v;
    }

    private Credentials() {}
}
