package pl.wit.lab5;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;


public class LambdaTutorial {
    private Set<Integer> setNumbers = new LinkedHashSet<Integer>();

    private final Predicate<Set<Integer>> isMoreThan10 = set -> set.size() > 10;
    private final Predicate<Set<Integer>> isNotEmpty = set -> !set.isEmpty();
    private final Consumer<Set<Integer>> printSet = n -> System.out.println(String.join(",", n.stream().map(String::valueOf).toArray(CharSequence[]::new)));
    private final Supplier<Integer> getFirstElement = () -> setNumbers.iterator().next();
    private final Function<Set<Integer>, Integer> getMaxElement  = set -> {
        return set.stream().max(Integer::compareTo).orElse(null);
    };

    public void addNumber(int no) {
        setNumbers.add(no);
    }

    public boolean isMoreThan10() {
        return isMoreThan10.test(this.setNumbers);
    }

    public boolean isNotEmpty() {
        return isNotEmpty.test(this.setNumbers);
    }

    public void printSet() {
        printSet.accept(this.setNumbers);
    }

    public Integer getFirstElement() {
        return getFirstElement.get();
    }

    public Integer getMaxElement() {
        return getMaxElement.apply(this.setNumbers);
    }
}
