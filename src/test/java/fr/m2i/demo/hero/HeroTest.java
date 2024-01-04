package fr.m2i.demo.hero;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class HeroTest {
    private Hero hero;

    @BeforeEach
    public void setUp() {
        Identity identityMock = mock(Identity.class);
        when(identityMock.getIdentity()).thenReturn("Youn Michael : Humoriste");

        Power powerMock = mock(Power.class);
        when(powerMock.toString()).thenReturn("Se frotter: aller en prison");

        List<Power> powers = new ArrayList<>();
        powers.add(powerMock);

        hero = new Hero(
                identityMock,
                powers
        );
    }

    @Test
    public void testRemoveCostume() {
        String result = hero.removeCostume();

        assertEquals("Le héros retire son costume et redevient Youn Michael : Humoriste", result);
    }

    @Test
    public void testFight() {
        String result = hero.fight();

        assertEquals(
                "Le héros utilise son pouvoir Se frotter: aller en prison",
                result
        );
    }
}