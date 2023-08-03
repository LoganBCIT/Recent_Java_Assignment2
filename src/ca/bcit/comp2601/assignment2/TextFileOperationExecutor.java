package ca.bcit.comp2601.assignment2;

import java.util.ArrayList;
import java.util.List;

/**
 * Models a TextFileOperationExecutor
 *
 * @author Logan Dutton-Anderson
 * @version 1.0
 */
public class TextFileOperationExecutor {
    private final List<TextFileOperation> textFileOperations = new ArrayList<>();

    /**
     * Executes the specified TextFileOperation by adding it to the list and returning the result of the execution.
     *
     * @param textFileOperation the TextFileOperation to be executed
     * @return the result of the execution as a String
     */
    public String executeOperation(TextFileOperation textFileOperation) {
        textFileOperations.add(textFileOperation);
        return textFileOperation.execute();
    }
}
