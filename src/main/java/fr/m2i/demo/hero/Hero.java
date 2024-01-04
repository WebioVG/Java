package fr.m2i.demo.hero;

import java.util.List;

public class Hero {
    private Identity identity;
    private List<Power> powers;

    public Hero(Identity identity, List<Power> powers) {
        this.identity = identity;
        this.powers = powers;
    }

    public String removeCostume() {
        return "Le héros retire son costume et redevient " + identity.getIdentity();
    }

    public void setPowers(List<Power> powers) {
        this.powers = powers;
    }

    public String fight() {
        return "Le héros utilise son pouvoir " + getRandomPower();
    }

    private Power getRandomPower() {
        int index = (int) Math.floor(Math.random() * powers.toArray().length);

        return powers.get(index);
    }
}
