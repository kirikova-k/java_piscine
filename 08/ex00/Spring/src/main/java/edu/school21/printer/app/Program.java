package edu.school21.printer.app;

import edu.school21.printer.logic.preprocessor.PreProcessor;
import edu.school21.printer.logic.preprocessor.PreProcessorToLowerImpl;
import edu.school21.printer.logic.preprocessor.PreProcessorToUpperImpl;
import edu.school21.printer.logic.printer.Printer;
import edu.school21.printer.logic.printer.PrinterWithDateTimeImpl;
import edu.school21.printer.logic.printer.PrinterWithPrefixImpl;
import edu.school21.printer.logic.renderer.Renderer;
import edu.school21.printer.logic.renderer.RendererErrImpl;
import edu.school21.printer.logic.renderer.RendererStandardImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Program {
    public static void main(String[] args) {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml")) {
            Printer prefixPrinter = context.getBean("printerWithPrefix", Printer.class);
            prefixPrinter.print ("Hello!") ;

            Printer dateAndTimePrinter = context.getBean("printerWithDateTime", Printer.class);
            dateAndTimePrinter.print("Hello");
        }

        PreProcessor preProcessor = new PreProcessorToUpperImpl();
        Renderer rendererErr = new RendererErrImpl(preProcessor);
        PrinterWithPrefixImpl prefixPrinter = new PrinterWithPrefixImpl(rendererErr);
        prefixPrinter.setPrefix("Prefix");
        prefixPrinter.print("Hello!");

        PreProcessor preProcessor1 = new PreProcessorToLowerImpl();
        Renderer rendererStd = new RendererStandardImpl(preProcessor1);
        PrinterWithDateTimeImpl dateAndTimePrinter = new PrinterWithDateTimeImpl(rendererStd);
        dateAndTimePrinter.print("Hello");
    }
}
