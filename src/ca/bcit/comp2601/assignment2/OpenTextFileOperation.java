package ca.bcit.comp2601.assignment2;

/**
 * Models a OpenTextFileOperation
 *
 * @author Logan Dutton-Anderson
 * @version 1.0
 */
public class OpenTextFileOperation implements TextFileOperation {

    public static TextFile textFile;

    /**
     * Constructs an OpenTextFileOperation object with the specified TextFile.
     *
     * @param textFile the TextFile instance on which the open operation will be performed
     */
    public OpenTextFileOperation(TextFile textFile) {
        this.textFile = textFile;
    }

    /**
     * Executes the open operation on the associated TextFile.
     *
     * @return the result of the open operation as a String
     */
    @Override
    public String execute() {
        return textFile.open();
    }
}
