package ca.bcit.comp2601.assignment2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Logan Dutton-Anderson
 * @version 1.0
 */
class PersonTest {
    private Person p1;

    @BeforeEach
    void setUp() {
        Date born = new Date(30, 12, 1975);
        Name name = new Name("tiGer", "woODs");
        p1 = new Person(born, name);
    }

    @AfterEach
    void tearDown() {
        p1 = null;
    }

    @Test
    void testNullName() {
        assertThrows(IllegalPersonException.class, () -> {
            p1 = new Person(p1.getDateOfBirth(), null);
        });
    }

    @Test
    void testExceptionMessages() {
        // bad name
        try {
            p1 = new Person(p1.getDateOfBirth(), null);
        } catch (IllegalPersonException e) {
            assertEquals("invalid name", e.getMessage());
        }

        // bad birthdate
        try {
            p1 = new Person(null, p1.getName());
        } catch (IllegalPersonException e) {
            assertEquals("invalid date of birth", e.getMessage());
        }
    }

    @Test
    void testAlive() {
        assertTrue(p1.isAlive());
    }

    @Test
    void testGetDateOfBirth() {
        assertEquals("1975-12-30", p1.getDateOfBirth().getYyyyMmDd());
    }

    @Test
    void testGetYyyyMmDd() {
        p1.die(new Date(16, 10, 2020));
        assertEquals("2020-10-16", p1.getDateOfDeath().getYyyyMmDd());
    }

    @Test
    void testDead() {
        p1.die(new Date(16, 10, 2020));
        assertFalse(p1.isAlive());
    }

    @Test
    void testComparable() {
        Date date1 = new Date(13, 7, 1979);
        Date date2 = new Date(13, 8, 1979);
        Date date3 = new Date(13, 7, 1980);
        Date date4 = new Date(12, 7, 1979);

        Person person1 = new Person(date4, new Name("oldest", "oldest"));
        Person person2 = new Person(date3, new Name("youngest","youngest"));
        Person person3 = new Person(date2, new Name("young", "young"));
        Person person4 = new Person(date1, new Name("older", "older"));
        person4.die(new Date(31, 10, 2000));

        List<Person> people = new ArrayList<>();
        people.add(person1);
        people.add(person2);
        people.add(person3);
        people.add(person4);

        List<Person> sorted = new ArrayList<>();
        sorted.add(person1);
        sorted.add(person4);
        sorted.add(person3);
        sorted.add(person2);

        Collections.sort(people);

        assertEquals(sorted, people);
    }
}
