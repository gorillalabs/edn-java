package us.bpsm.edn.performance;

import us.bpsm.edn.parser.Parseable;
import us.bpsm.edn.parser.Parser;
import us.bpsm.edn.parser.Parsers;
import us.bpsm.edn.printer.Printers;

import com.google.caliper.Runner;
import com.google.caliper.SimpleBenchmark;

public class CaliperTest extends SimpleBenchmark {

    @SuppressWarnings("unused")
    public void timeStringParsing(int reps) {
        Parseable r = Parsers.newParseable(PerformanceTest.ednString);
        for (int i=0; i<reps; i++) {
            Parser p=Parsers.newParser(Parsers.defaultConfiguration());
            Object o=p.nextValue(r);
        }
    }

    @SuppressWarnings("unused")
    public void timeStringWriting(int reps) {
        for (int i=0; i<reps; i++) {
            String s=Printers.printString(PerformanceTest.ednData);
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        new CaliperTest().run();
    }

    private void run() {
        new Runner().run(new String[] {this.getClass().getCanonicalName()});
    }

}
