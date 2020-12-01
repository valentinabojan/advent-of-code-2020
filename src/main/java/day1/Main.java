package day1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        String part1_test_fileName = "src/main/resources/day1/input_test_1_1.txt";      // 514579
        String fileName = "src/main/resources/day1/input_1_1.txt";

        System.out.println(partOne(part1_test_fileName));       // 514579
        System.out.println(partOne(fileName));                  // 1019371

        System.out.println(partTwo(part1_test_fileName));       // 241861950
        System.out.println(partTwo(fileName));                  // 278064990
    }

    private static int partOne(String fileName) throws IOException {
        List<Integer> entries = readEntries(fileName);

        return getEntriesForGivenSum(entries, 2020)
                .map(tuple -> tuple.getEntry1() * tuple.getEntry2())
                .orElseThrow();
    }

    private static int partTwo(String fileName) throws IOException {
        List<Integer> entries = readEntries(fileName);

        Tuple<Integer> tuple = entries.stream()
                .map(entry -> getEntriesForGivenSum(entries, 2020 - entry))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .findFirst()
                .orElseThrow();

        Integer firstEntry = tuple.getEntry1();
        Integer secondEntry = tuple.getEntry2();
        Integer thirdEntry = 2020 - firstEntry - secondEntry;

        return firstEntry * secondEntry * thirdEntry;
    }

    private static Optional<Tuple<Integer>> getEntriesForGivenSum(List<Integer> entries, int sum) {
        return entries.stream()
                .filter(entry -> entries.contains(sum - entry))
                .map(entry -> new Tuple<>(entry, sum - entry))
                .findFirst();
    }

    private static List<Integer> readEntries(String fileName) throws IOException {
        return Files.lines(Paths.get(fileName))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }

}