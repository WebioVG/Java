package fr.m2i.demo.hero;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class HeroTestAutoMock {
    @Mock
    private Identity identityMock;
    @Mock
    private Power powerMock;
    @InjectMocks
    private Hero hero;

    @BeforeEach
    public void setUp() {
        List<Power> powers = new ArrayList<>();
        powers.add(powerMock);
        hero.setPowers(powers);
    }

    @Test
    public void testRemoveCostume() {
        String result = hero.removeCostume();

        verify(
                identityMock,
                times(1)
        ).getIdentity();

        assertEquals(
                "Le héros retire son costume et redevient " + identityMock.getIdentity(),
                result
        );
    }
}
