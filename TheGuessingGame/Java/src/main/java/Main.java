import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    private int testCasesTotal;

    private List<TestCase> testCases = new ArrayList<TestCase>();

    public void processInput(Scanner scanner) {
        testCasesTotal = Integer.valueOf(scanner.nextLine());
        for (int i = 0; i < testCasesTotal; ++i) {
            testCases.add(processTestCase(scanner));
        }
    }

    private TestCase processTestCase(Scanner scanner) {
        int k = Integer.valueOf(scanner.nextLine());
        List<Hint> hints = new ArrayList<Hint>();
        for (int i = 0; i < k; ++i) {
            if (scanner.hasNextLine()) {
                String s = scanner.nextLine();
                String[] line = s.split(" ");
                hints.add(new Hint(
                        Hint.Operator.getUsingSymbol(line[0]),
                        Integer.valueOf(line[1]),
                        line[2].equals("Yes")));
            }
        }
        return new TestCase(k, hints);
    }

    public int getTestCasesTotal() {
        return testCasesTotal;
    }

    public TestCase getTestCase(int index) {
        return testCases.get(index);
    }

    public long minimalPossibleNumberOfLiesForTestCase(int index) {
        TestCase testCase = getTestCase(index);
        int minLies = testCase.getHintsTotal();
        for (long n = 1; n <= testCase.getMaxNToSearch(); ++n) {
            int lies = testCase.liesUsingNumber(n);
            if (lies <= minLies) {
                minLies = lies;
            }
        }
        return minLies;
    }

    public static class TestCase {
        private final int hintsTotal;

        private List<Hint> hints;

        public TestCase(int hintsTotal, List<Hint> hints) {
            this.hintsTotal = hintsTotal;
            this.hints = hints;
        }

        public int getHintsTotal() {
            return hintsTotal;
        }

        public List<Hint> getHints() {
            return hints;
        }

        public int liesUsingNumber(long number) {
            int liesTotal = 0;
            for (Hint hint : this.hints) {
                if (!hint.isTrue(number)) {
                    liesTotal++;
                }
            }
            return liesTotal;
        }

        public long getMaxNToSearch() {
            List<Long> hintsGtYes = new ArrayList<Long>();
            for (Hint hint : this.hints) {
                if (hint.operator == Hint.Operator.GREATER_THAN && hint.isYes()) {
                    hintsGtYes.add(hint.getValue());
                }
            }

            if (hintsGtYes.size() > 0) {
                Collections.sort(hintsGtYes);
                return hintsGtYes.get(hintsGtYes.size() - 1) + 1;
            }

            List<Long> hintsGtNo = new ArrayList<Long>();
            for (Hint hint : this.hints) {
                if (hint.operator == Hint.Operator.GREATER_THAN && hint.isNo()) {
                    hintsGtNo.add(hint.getValue());
                }
            }

            if (hintsGtNo.size() > 0) {
                Collections.sort(hintsGtNo);
                return hintsGtNo.get(hintsGtNo.size() - 1);
            }

            List<Long> hintsEq = new ArrayList<Long>();
            for (Hint hint : this.hints) {
                if (hint.operator == Hint.Operator.EQUALS && hint.isYes()) {
                    hintsEq.add(hint.getValue());
                }
            }

            if (hintsEq.size() > 0) {
                Collections.sort(hintsEq);
                return hintsEq.get(hintsEq.size() - 1);
            }

            return 10000000000L;
        }
    }

    public static class Hint {

        public boolean isTrue(long number) {
            if (this.operator == Operator.GREATER_THAN) {
                return (number > this.value) == this.logicalValue;
            }
            else if (this.operator == Operator.LESS_THAN) {
                return (number < this.value) == this.logicalValue;
            }
            else {
                return (number == this.value) == this.logicalValue;
            }
        }

        public boolean isLie(long number) {
            return !isTrue(number);
        }

        public static enum Operator {
            GREATER_THAN(">"), LESS_THAN("<"), EQUALS("=");

            private String op;

            Operator(String op) {
                this.op = op;
            }


            public static Operator getUsingSymbol(String symbol) {
                for (Operator operator : Operator.values()) {
                    if (operator.op.equals(symbol)) {
                        return operator;
                    }
                }
                return null;
            }
        }

        private final Operator operator;

        private final long value;

        private final boolean logicalValue;

        public Hint(Operator operator, long value, boolean logicalValue) {
            this.operator = operator;
            this.value = value;
            this.logicalValue = logicalValue;
        }

        public Operator getOperator() {
            return operator;
        }

        public long getValue() {
            return value;
        }

        public boolean isNo() {
            return !logicalValue;
        }

        public boolean isYes() {
            return !isNo();
        }
    }

    public static void main(String [] args) {
        Main gg = new Main();
        gg.processInput(new Scanner(System.in));
        for (int i = 0; i < gg.getTestCasesTotal(); ++i) {
            System.out.println(gg.minimalPossibleNumberOfLiesForTestCase(i));
        }
    }
}
