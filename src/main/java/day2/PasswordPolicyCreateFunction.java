package day2;

@FunctionalInterface
public interface PasswordPolicyCreateFunction<T extends PasswordPolicy> {

     T create(int n1, int n2, char mandatorySubString);

}
