import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class OffsideChecker {
    static private List<Integer> offsideList(String passer, int number,
                                             List<Integer> teamA, List<Integer> teamB) {
        List<Integer> friendTeam;
        List<Integer> enemyTeam;
        if (passer.equals("A")) {
            friendTeam = teamA.stream()
                    .map(s -> 110 - s)
                    .collect(Collectors.toList());
            enemyTeam = teamB.stream()
                    .map(s -> 110 - s)
                    .collect(Collectors.toList());
        } else {
            friendTeam = teamB;
            enemyTeam = teamA;
        }
        int position = friendTeam.get(number);
        int second = enemyTeam.stream()
                .sorted(Integer::compareTo)
                .collect(Collectors.toList())
                .get(1);
        return checkOffside(e -> e <= 55 && e < position && e < second, friendTeam);
    }

    static private List<Integer> checkOffside(Predicate<? super Integer> f, List<Integer> list) {
        List<Integer> result = list.stream()
                .filter(f::test)
                .collect(Collectors.toList());
        return result.stream()
                .map(s -> list.indexOf(s) + 1)
                .sorted(Integer::compareTo)
                .collect(Collectors.toList());
    }
}
