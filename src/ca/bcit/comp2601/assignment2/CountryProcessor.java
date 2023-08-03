package ca.bcit.comp2601.assignment2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Models a Country Processor
 *
 * @author Logan Dutton-Anderson
 * @version 1.0
 */
public class CountryProcessor {
    private Map<String, String> countryCapitalMap;

    public static final int NUMBER_OF_PARTS;
    public static final int FIRST_PART_INDEX;
    public static final int SECOND_PART_INDEX;

    static {
        NUMBER_OF_PARTS = 2;
        FIRST_PART_INDEX = 0;
        SECOND_PART_INDEX = 1;
    }

    /**
     * Constructs a new countryCapitalMap.
     */
    public CountryProcessor() {
        countryCapitalMap = new HashMap<>();
    }

    /**
     * Calls all stream functions to process the countries and capitals data.
     */
    public void processCountries() {
        readCountryCapitalsFromFile();
        printLongestCapitalCity();
        printShortestCountryName();
        printAllCountriesStartingWith("z");
        printLongestCombination();
        printHowManyCharactersInCountries();
        printCapitalsWithThisManyLetters(5, 8);
        printAllCountriesThatDoNotEndWith('z');
        printAllCountriesThatContainLetterIntoASingleStringNoSpaces('z');
        Main.main(new String[0]);
    }

    /**
     * Reads the country and capital data from the file and populates the countryCapitalMap.
     */
    private void readCountryCapitalsFromFile() {
        try {
            Path filePath;
            List<String> lines;

            filePath = Paths.get("countries-and-capitals.txt");
            lines = Files.readAllLines(filePath);

            for (String line : lines) {
                String[] parts = line.split(",");
                if (parts.length == NUMBER_OF_PARTS) {
                    String country;
                    String capital;
                    country = parts[FIRST_PART_INDEX].trim();
                    capital = parts[SECOND_PART_INDEX].trim();
                    countryCapitalMap.put(country, capital);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Prints the longest capital city name.
     */
    private void printLongestCapitalCity() {
        String longestCapital = countryCapitalMap.values().stream()
                .max((c1, c2) -> c1.length() - c2.length())
                .orElse("");
        System.out.println("Longest Capital City: " + longestCapital);
    }

    /**
     * Prints the shortest country name.
     */
    private void printShortestCountryName() {
        String shortestCountryName = countryCapitalMap.keySet().stream()
                .min((c1, c2) -> c1.length() - c2.length())
                .orElse("");
        System.out.println("Shortest Country Name: " + shortestCountryName);
    }

    /**
     * Prints all countries starting with the given substring.
     *
     * @param substring the substring to match
     */
    private void printAllCountriesStartingWith(final String substring) {
        List<String> countriesStartingWith = countryCapitalMap.keySet().stream()
                .filter(c -> c.toLowerCase().startsWith(substring.toLowerCase()))
                .collect(Collectors.toList());
        System.out.println("Countries starting with \"" + substring + "\": " + countriesStartingWith);
    }

    /**
     * Prints the longest combination of country name plus capital city name.
     */
    private void printLongestCombination() {
        String longestCombination = countryCapitalMap.entrySet().stream()
                .map(combination -> combination.getKey() + combination.getValue())
                .max((combo1, combo2) -> combo1.length() - combo2.length())
                .orElse("");
        System.out.println("Longest Combination: " + longestCombination);
    }

    /**
     * Prints the total number of characters in all the country names combined.
     */
    private void printHowManyCharactersInCountries() {
        int totalCharacters = countryCapitalMap.keySet().stream()
                .mapToInt(String::length)
                .sum();
        System.out.println("Total Number of Characters in Country Names: " + totalCharacters);
    }

    /**
     * Prints the capitals with the specified number of letters.
     *
     * @param min the minimum number of letters
     * @param max the maximum number of letters
     */
    private void printCapitalsWithThisManyLetters(final int min, final int max) {
        List<String> capitalsWithThisManyLetters = countryCapitalMap.values().stream()
                .filter(c -> c.length() >= min && c.length() <= max)
                .collect(Collectors.toList());
        System.out.println("Capitals with " + min + "-" + max + " letters: " + capitalsWithThisManyLetters);
    }

    /**
     * Prints all countries that do not end with the specified letter.
     *
     * @param letter the letter to exclude from the end of country names
     */
    private void printAllCountriesThatDoNotEndWith(final char letter) {
        List<String> countriesThatDontEndWith = countryCapitalMap.keySet().stream()
                .filter(c -> !c.toLowerCase().endsWith(String.valueOf(letter).toLowerCase()))
                .collect(Collectors.toList());
        System.out.println("Countries that do not end with \"" + letter + "\": " + countriesThatDontEndWith);
    }

    /**
     * Prints all countries that contain the specified letter in a single string without spaces.
     *
     * @param letter the letter to search for in country names
     */
    private void printAllCountriesThatContainLetterIntoASingleStringNoSpaces(final char letter) {
        String allCountriesThatContain = countryCapitalMap.keySet().stream()
                .filter(c -> c.toLowerCase().contains(String.valueOf(letter).toLowerCase()))
                .map(String::trim)
                .map(s -> s.replace(" ", ""))
                .collect(Collectors.joining());
        System.out.println("Countries containing \"" + letter + "\": " + allCountriesThatContain);
    }
}
