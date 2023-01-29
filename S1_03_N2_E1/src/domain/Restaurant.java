package domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor

public class Restaurant {
    public String name;
    public Integer puntuacio;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Restaurant that = (Restaurant) o;
        return name.equals(that.name) && puntuacio.equals(that.puntuacio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, puntuacio);
    }

    @Override
    public String toString() {
        return String.format(name + " " + puntuacio);
    }
}
