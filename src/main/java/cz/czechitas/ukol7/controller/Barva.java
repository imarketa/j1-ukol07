package cz.czechitas.ukol7.controller;

public enum Barva {
    Bila("bílá"),
    Zluta("žlutá"),
    Cervena("červená"),
    Fialova("fialová"),
    Modra("modrá"),
    Cerna("černá");


    private final String text;

    Barva(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
