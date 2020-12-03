package day2;

public abstract class PasswordPolicy {

    protected final int n1;
    protected final int n2;
    protected final char mandatorySubString;

    protected PasswordPolicy(int n1, int n2, char mandatorySubString) {
        this.n1 = n1;
        this.n2 = n2;
        this.mandatorySubString = mandatorySubString;
    }

    protected abstract boolean checkPassword(String password);
}
