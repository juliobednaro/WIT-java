package pl.wit.lab2;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class PresentationTest {
    private Presentation p;

    @BeforeEach
    void aVoid() {
        this.p = new Presentation("Julian", "Bednarz");
    }

    @Test
    void createObjectWith2Args() {
        this.p = new Presentation("Julian", "Bednarz");

        Assertions.assertEquals("Julian Bednarz", p.getFullName());
    }

    @Test
    void createObjectWithAllArgs() {
        this.p = new Presentation("Julian", "Bednarz", (byte) 14, (byte) 12, (short) 2001);

        Assertions.assertEquals("Julian Bednarz", p.getFullName());
        Assertions.assertEquals("14.12.2001", p.getBirthdayDateAsString());
    }

    @Test
    void getFullName() {
        String name;

        name = this.p.getFullName();

        assertEquals("Julian Bednarz", name);
    }

    @Test
    void getBirthdayDateAsString() {
        String date;

        this.p.setBirthdayDay((byte) 14);
        this.p.setBirthdayMonth((byte) 12);
        this.p.setBirthdayYear((short) 2001);
        date = this.p.getBirthdayDateAsString();

        assertEquals("14.12.2001", date);
    }

    @Test
    void getAge() {
        byte age;

        this.p.setBirthdayDay((byte) 14);
        this.p.setBirthdayMonth((byte) 12);
        this.p.setBirthdayYear((short) 2001);
        age = this.p.getAge();

        assertEquals((byte) 22, age);
    }

    @Test
    void getPresentationStory() {
        String fullDesc;

        this.p.setBirthdayDay((byte) 14);
        this.p.setBirthdayMonth((byte) 12);
        this.p.setBirthdayYear((short) 2001);
        this.p.setPlaceOfBirth("Warszawa");
        this.p.setVisitedPlaces(new String[]{"Berlin", "Madryt"});
        fullDesc = this.p.getPresentationStory();

        Assertions.assertNotNull(this.p.getFullName());
        Assertions.assertNotNull(this.p.getAge());
        Assertions.assertNotNull(this.p.getPlaceOfBirth());
        Assertions.assertNotNull(this.p.getVisitedPlaces());

        Assertions.assertEquals("Nazywam się Julian Bednarz, mam 22 lata a moim miejscem urodzenia jest Warszawa. Mam niewielką liczbę znajomych na FB. W życiu odwiedziłem takie miejsca jak: Berlin, Madryt.", fullDesc);
    }
}