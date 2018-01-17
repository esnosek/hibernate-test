package library.dto;

import java.io.Serializable;

public class BookDto implements Serializable{

    private String title;
    private String category;

    public BookDto(String title, String category) {
        this.title = title;
        this.category = category;
    }

    public BookDto() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
