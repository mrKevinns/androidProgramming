package kr.ac.mjc.okhttp_example;

public class Item {
    private String title, link, description;

    private Enclosure enclosure;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Enclosure getEnclosure() { return enclosure; }

    public void setEnclosure(Enclosure enclosure) { this.enclosure = enclosure; }
}
