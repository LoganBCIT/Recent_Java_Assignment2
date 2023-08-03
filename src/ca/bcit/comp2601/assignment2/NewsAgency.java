package ca.bcit.comp2601.assignment2;

import java.util.ArrayList;
import java.util.List;

/**
 * Models a NewsAgency
 *
 * @author Logan Dutton-Anderson
 * @version 1.0
 */
public class NewsAgency {
    private String news;
    private List<Channel> channels = new ArrayList<>();

    /**
     * Adds a channel as an observer to the news agency.
     * The channel will receive news updates from the news agency.
     *
     * @param channel the channel to be added as an observer
     */
    public void addObserver(Channel channel) {
        this.channels.add(channel);
    }

    /**
     * Removes a channel from the list of observers in the news agency.
     * The channel will no longer receive news updates from the news agency.
     *
     * @param channel the channel to be removed from the observers
     */
    public void removeObserver(Channel channel) {
        this.channels.remove(channel);
    }

    /**
     * Sets the news in the news agency.
     * The news agency notifies all subscribed channels by calling their update() method with the latest news.
     *
     * @param news the news to be set in the news agency
     */
    public void setNews(String news) {
        this.news = news;
        for (Channel channel : this.channels) {
            channel.update(this.news);
        }
    }
}
