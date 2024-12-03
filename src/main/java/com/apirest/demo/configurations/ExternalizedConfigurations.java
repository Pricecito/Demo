package com.apirest.demo.configurations;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

//No crea un bean, pero es tratado como uno, por lo que será posible realizar inyeccion de dependencias, para que se carguye de manera prematura
@Configuration
// Con esta indicamos cuales seran las propiedades con las que trabajaremos
// haciendo uso de una prefijo o prefix del configuration properties
@ConfigurationProperties(prefix = "app")
public class ExternalizedConfigurations {

    private String name;
    private String version;
    private String autor;
    private String language;

    public ExternalizedConfigurations(String name, String version, String country, String language) {
        this.name = name;
        this.version = version;
        this.autor = country;
        this.language = language;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String country) {
        this.autor = country;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String toString() {
        return "ExternalizedConfigurations: " + "\n" +
                "name='" + this.name + '\'' + "\n" +
                "version='" + this.version + '\'' + "\n" +
                "country='" + this.autor + '\'' + "\n" +
                "idioma='" + this.language + '\'' + "\n";
    }

}
