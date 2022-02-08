package home.project.tgserialsserver.provider;

import home.project.tgserialsserver.utils.EpisodesMessageCollector;

public class CollectorProvider {

    public static EpisodesMessageCollector toEpisodesMessage(String serialName) {
        return new EpisodesMessageCollector(serialName);
    }
}
