package ca.bcit.comp2601.assignment2;

/**
 * Models a SaveTextFileOperation
 *
 * @author Logan Dutton-Anderson
 * @version 1.0
 */
public class SaveTextFileOperation implements TextFileOperation {
    private TextFile textFile;

    /**
     * Constructs a SaveTextFileOperation object with the specified TextFile.
     *
     * @param textFile the TextFile instance on which the save operation will be performed
     */
    public SaveTextFileOperation(TextFile textFile) {
        this.textFile = textFile;
    }

    /**
     * Executes the save operation on the associated TextFile.
     *
     * @return the result of the save operation as a String
     */
    @Override
    public String execute() {
        return textFile.save();
    }
}
