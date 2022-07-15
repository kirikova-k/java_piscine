package edu.school21.printer.logic.printer;

import edu.school21.printer.logic.renderer.Renderer;
import org.springframework.util.StringUtils;

public class PrinterWithPrefixImpl implements Printer {

    String prefix = "";
    Renderer renderer;

    public PrinterWithPrefixImpl(Renderer renderer) {
        this.renderer = renderer;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    @Override
    public void print(String s) {
        String p = prefix != null ? prefix : "";
        renderer.send(p + " " + s);
    }
}
