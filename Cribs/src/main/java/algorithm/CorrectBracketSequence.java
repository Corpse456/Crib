package algorithm;

import java.util.HashSet;
import java.util.Set;

public class CorrectBracketSequence {

    private Set<String> resultBrackets;

    public Set<String> writeSequence(int n) {
        resultBrackets = new HashSet<>();
        findPossibleSolutions(n, "", 0, 0);
        return resultBrackets;
    }

    private void findPossibleSolutions(final int n, final String currentOption, final int open, final int close) {
        if (open == n) {
            resultBrackets.add(currentOption + ")".repeat(open - close));
            return;
        }
        findPossibleSolutions(n, currentOption + "(", open + 1, close);
        if (open > close) {
            findPossibleSolutions(n, currentOption + ")", open, close + 1);
        }
    }
}
