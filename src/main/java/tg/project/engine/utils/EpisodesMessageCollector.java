package tg.project.engine.utils;

import java.util.EnumSet;
import java.util.Set;
import java.util.StringJoiner;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class EpisodesMessageCollector implements Collector<String, StringJoiner, String> {

    private final String serialName;

    public EpisodesMessageCollector(String serialName) {
        this.serialName = serialName;
    }

    @Override
    public Supplier<StringJoiner> supplier() {
        return () -> new StringJoiner("\n");
    }

    @Override
    public BiConsumer<StringJoiner, String> accumulator() {
        return StringJoiner::add;
    }

    @Override
    public BinaryOperator<StringJoiner> combiner() {
        return StringJoiner::merge;
    }

    @Override
    public Function<StringJoiner, String> finisher() {
        return stringJoiner -> {
            String episodesText = stringJoiner.toString();
            return String.format("%s\nСегодня выходит:\n%s", serialName, episodesText);
        };
    }

    @Override
    public Set<Characteristics> characteristics() {
        return EnumSet.of(Collector.Characteristics.UNORDERED);
    }
}