package Composition;

import java.io.Serializable;

public class ToDoEintrag implements Serializable {
    private String text;
    public ToDoEintrag(String text) {
        this.text = text;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
}