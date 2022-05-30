package tg.project.engine.provider;

import tg.project.engine.utils.EpisodesMessageCollector;

public class CollectorProvider {

    public static EpisodesMessageCollector toEpisodesMessage(String serialName) {
        return new EpisodesMessageCollector(serialName);
    }
}
