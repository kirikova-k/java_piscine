package edu.school21.printer.logic.renderer;

import edu.school21.printer.logic.preprocessor.PreProcessor;

public class RendererErrImpl implements Renderer {

    PreProcessor preProcessor;

    public RendererErrImpl(PreProcessor preProcessor) {
        this.preProcessor = preProcessor;
    }

    @Override
    public void send(String s) {
        System.err.println(preProcessor.preProcess(s));
    }
}
