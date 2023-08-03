package ca.bcit.comp2601.assignment2;

/**
 * Models a TextFile
 *
 * @author Logan Dutton-Anderson
 * @version 1.0
 */
public class TextFile {

    private String name;

    /**
     * Constructs a TextFile object with the specified name.
     *
     * @param name the name of the text file
     */
    public TextFile(String name) {
        this.name = name;
    }

    /**
     * Opens the text file.
     *
     * @return a message indicating the file being opened
     */
    public String open() {
        return "Opening file " + name;
    }

    /**
     * Saves the text file.
     *
     * @return a message indicating the file being saved
     */
    public String save() {
        return "Saving file " + name;
    }
}
