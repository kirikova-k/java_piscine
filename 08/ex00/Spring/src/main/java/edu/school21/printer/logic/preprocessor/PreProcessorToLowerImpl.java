package edu.school21.printer.logic.preprocessor;

import java.util.Locale;

public class PreProcessorToLowerImpl implements PreProcessor {

    @Override
    public String preProcess(String s) {
        return s.toLowerCase();
    }
}
