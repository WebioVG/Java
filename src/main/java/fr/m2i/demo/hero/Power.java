package fr.m2i.demo.hero;

public class Power {
    private String name;
    private String description;

    public Power(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString() {
        return this.name + " : " + this.description;
    }
}
