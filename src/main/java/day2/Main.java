package day2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

import static java.util.stream.Collectors.toMap;

public class Main {

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        String part1_test_fileName = "src/main/resources/day2/input_test_1_1.txt";
        String fileName = "src/main/resources/day2/input_1_1.txt";

        System.out.println(main.partOne(part1_test_fileName));           // 2
        System.out.println(main.partOne(fileName));                      // 416

        System.out.println(main.partTwo(part1_test_fileName));          // 1
        System.out.println(main.partTwo(fileName));                     // 688
    }

    private long partOne(String fileName) throws IOException {
        Map<MinMaxOccurrencesPasswordPolicy, String> passwordsDatabase = readEntries(fileName, MinMaxOccurrencesPasswordPolicy::new);
        return countValidPasswordsInDatabase(passwordsDatabase);

    }

    private long partTwo(String fileName) throws IOException {
        Map<PositionedOccurrencesPasswordPolicy, String> passwordsDatabase = readEntries(fileName, PositionedOccurrencesPasswordPolicy::new);
        return countValidPasswordsInDatabase(passwordsDatabase);
    }

    private <T extends PasswordPolicy> long countValidPasswordsInDatabase(Map<T, String> passwordsDatabase) {
        return passwordsDatabase.entrySet().stream()
                .filter(passwordEntry -> passwordEntry.getKey().checkPassword(passwordEntry.getValue()))
                .count();
    }

    private <T extends PasswordPolicy> Map<T, String> readEntries(String fileName, PasswordPolicyCreateFunction<T> function) throws IOException {
        return Files.lines(Paths.get(fileName))
                .collect(toMap(line -> parsePasswordPolicy(line, function), this::parsePassword));
    }

    private String parsePassword(String line) {
        return line.substring(line.indexOf(":") + 1);
    }

    private <T extends PasswordPolicy> T parsePasswordPolicy(String line, PasswordPolicyCreateFunction<T> function) {
        String passwordPolicyString = line.substring(0, line.indexOf(":"));
        String[] passwordPolicyParts = passwordPolicyString.split(" ");
        String[] passwordPolicyOccurrencesRule = passwordPolicyParts[0].split("-");
        int n1 = Integer.parseInt(passwordPolicyOccurrencesRule[0]);
        int n2 = Integer.parseInt(passwordPolicyOccurrencesRule[1]);
        char mandatorySubString = passwordPolicyParts[1].charAt(0);

        return function.create(n1, n2, mandatorySubString);
    }
}