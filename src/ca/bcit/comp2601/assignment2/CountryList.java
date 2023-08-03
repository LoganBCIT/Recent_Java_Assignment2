package ca.bcit.comp2601.assignment2;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Represents a JFrame that displays a list of countries and their capitals.
 * The country data is read from a file and displayed in a JList component.
 *
 * @author Logan Dutton-Anderson
 * @version 1.0
 */
public class CountryList extends JFrame {
    public static final String COUNTRIES_CAPITALS_FILE;
    public static final int FRAME_WIDTH;
    public static final int FRAME_HEIGHT;
    public static final int COUNTRY_INDEX;
    public static final int CAPITAL_INDEX;

    private final JList<String> list;
    private final JScrollPane scrollPane;

    static {
        COUNTRIES_CAPITALS_FILE = "countries-and-capitals.txt";
        FRAME_WIDTH = 400;
        FRAME_HEIGHT = 400;
        COUNTRY_INDEX = 0;
        CAPITAL_INDEX = 1;
    }

    /**
     * Constructs a CountryList JFrame.
     */
    public CountryList() {
        list = new JList<>(getCountriesFromFile());
        scrollPane = new JScrollPane(list);
        getContentPane().add(scrollPane);

        setTitle("Country List");
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setLocationRelativeTo(null);
        setVisible(true);
        setAlwaysOnTop(true);

        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                dispose();
                Main.main(new String[0]);
            }
        });
    }

    /**
     * Reads the country data from COUNTRIES_CAPITALS_FILE and returns an array of strings
     * containing the countries and their capitals.
     *
     * @return an array of strings representing the countries and their capitals.
     */
    private String[] getCountriesFromFile() {
        List<String> countries;
        countries = new ArrayList<>();

        Scanner scanner;

        try {
            scanner = new Scanner(new File(COUNTRIES_CAPITALS_FILE));

            while (scanner.hasNextLine()) {
                String[] lineData;
                lineData = scanner.nextLine().split(",");

                String country;
                country = lineData[COUNTRY_INDEX].trim();

                String capital;
                capital = lineData[CAPITAL_INDEX].trim();

                countries.add(country + ": " + capital);
            }
        } catch (FileNotFoundException e) {
            System.out.printf("File '%s' not found in directory.%n", COUNTRIES_CAPITALS_FILE);
        }

        Collections.sort(countries);

        String[] countriesArray;
        countriesArray = new String[countries.size()];

        return countries.toArray(countriesArray);
    }
}
