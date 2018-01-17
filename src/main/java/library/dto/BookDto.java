package library.dto;

import java.io.Serializable;

public class BookDto implements Serializable{

    private String title;
    private String publisherId;

    public BookDto(String title, String publisherId) {
        this.title = title;
        this.publisherId = publisherId;
    }

    public BookDto() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(String publisherId) {
        this.publisherId = publisherId;
    }
}
