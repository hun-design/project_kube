package org.springframework.samples.petclinic.config;

public class DockerDbConfig {

    private String required(String name) {
        String value = System.getenv(name);
        if (value == null || value.isEmpty()) {
            throw new IllegalStateException(
                "Missing environment variable: " + name
            );
        }
        return value;
    }

    public String getDbHost() {
        return required("DB_HOST");
    }

    public String getDbName() {
        return required("DB_NAME");
    }

    public String getDbUsername() {
        return required("DB_USERNAME");
    }

    public String getDbPassword() {
        return required("DB_PASSWORD");
    }

    public String getJdbcUrl() {
        return "jdbc:mysql://" + getDbHost()
                + ":3306/" + getDbName()
                + "?useUnicode=true"
                + "&characterEncoding=UTF-8"
                + "&useSSL=false&allowPublicKeyRetrieval=true"
                + "&serverTimezone=UTC";
    }
}
