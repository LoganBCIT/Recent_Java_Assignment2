package ca.bcit.comp2601.assignment2;

/**
 * Models a NewsChannel
 *
 * @author Logan Dutton-Anderson
 * @version 1.0
 */
public class NewsChannel implements Channel {
    private String news;

    @Override
    public void update(Object news) {
        this.setNews((String) news);
    }

    private void setNews(final String news) {
        this.news = news;
    }

    public String getNews() {
        return news;
    }
}
