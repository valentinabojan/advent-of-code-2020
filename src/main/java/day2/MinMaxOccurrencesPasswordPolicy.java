package day2;

public class MinMaxOccurrencesPasswordPolicy extends PasswordPolicy {

    public MinMaxOccurrencesPasswordPolicy(int minOccurrences, int maxOccurrences, char mandatorySubString) {
        super(minOccurrences, maxOccurrences, mandatorySubString);
    }

    @Override
    protected boolean checkPassword(String password) {
        long mandatoryCharOccurrences = password.chars()
                .filter(c -> c == getMandatorySubString())
                .count();

        return mandatoryCharOccurrences >= getMinOccurrences() && mandatoryCharOccurrences <= getMaxOccurrences();

    }

    private int getMinOccurrences() {
        return super.n1;
    }

    private int getMaxOccurrences() {
        return super.n2;
    }

    private char getMandatorySubString() {
        return super.mandatorySubString;
    }
}
