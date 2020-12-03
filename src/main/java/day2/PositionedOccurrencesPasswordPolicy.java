package day2;

import java.util.stream.IntStream;

public class PositionedOccurrencesPasswordPolicy extends PasswordPolicy {

    protected PositionedOccurrencesPasswordPolicy(int firstOccurrencePosition, int secondOccurrencePosition, char mandatorySubString) {
        super(firstOccurrencePosition, secondOccurrencePosition, mandatorySubString);
    }

    @Override
    protected boolean checkPassword(String password) {
        char charAtFirstOccurrencePosition = password.charAt(getFirstOccurrencePosition());
        char charAtSecondOccurrencePosition = password.charAt(getSecondOccurrencePosition());

        long charOccurrencesCount = IntStream.of(charAtFirstOccurrencePosition, charAtSecondOccurrencePosition)
                .filter(c -> c == getMandatorySubString())
                .count();

        return charOccurrencesCount == 1;

    }

    private int getFirstOccurrencePosition() {
        return super.n1;
    }

    private int getSecondOccurrencePosition() {
        return super.n2;
    }

    private char getMandatorySubString() {
        return super.mandatorySubString;
    }
}
