import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static final int MIN_VALUE = 1;
    public static final long MAX_VALUE = 10000000000L;
    private int numberOfTestCases;

    private List<TestCase> testCases = new ArrayList<TestCase>();

    public void processInput(Scanner scanner) {
        numberOfTestCases = Integer.valueOf(scanner.nextLine());
        for (int i = 0; i < numberOfTestCases; ++i) {
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

    public int getNumberOfTestCases() {
        return numberOfTestCases;
    }

    public TestCase getTestCase(int index) {
        return testCases.get(index);
    }

    public long minimalPossibleNumberOfLiesForTestCase(int index) {
        TestCase testCase = getTestCase(index);
        int k = testCase.getHintsTotal();
        Set<Long> values = testCase.getValuesToCheck();
        for (Long value : values) {
            int lies = testCase.liesForNumber(value);
            if (lies <= k) {
                k = lies;
            }
        }
        return k;
    }

//    public long minimalPossibleNumberOfLiesForTestCase_v2(int index) {
//        TestCase testCase = getTestCase(index);
//        int k = testCase.getHintsTotal();
//        List<Hint> hints = testCase.getHints();
//        for (Hint hint : hints) {
//            if (Hint.Operator.LESS_THAN == hint.getOperator()) {
//                if (hint.isYes()) {
//                    range[MIN_VALUE : hint.getValue() - 1] += 1;
//                } else {
//                    range[hint.getValue()]
//                }
//            }
//        }
//    }

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

        public Set<Long> getValuesToCheck() {
            Set<Long> values = new HashSet<Long>();
            for (Hint hint : this.hints) {
                values.addAll(hint.getValuesToCheck());
            }
            return values;
        }

        public int liesForNumber(long number) {
            int liesCount = 0;
            for (Hint hint : this.hints) {
                if (!hint.isCorrectFor(number)) {
                    liesCount++;
                }
            }
            return liesCount;
        }
    }

    public static class Hint {

        public Set<Long> getValuesToCheck() {
            Set<Long> values = new HashSet<Long>();
            values.add(this.getValue() == MIN_VALUE ? MIN_VALUE : this.getValue() - 1);
            values.add(this.getValue());
            values.add(this.getValue() + 1);
            return values;
        }

        public boolean isCorrectFor(long number) {
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
        for (int i = 0; i < gg.getNumberOfTestCases(); ++i) {
            System.out.println(gg.minimalPossibleNumberOfLiesForTestCase(i));
        }
    }
}
