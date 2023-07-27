import java.time.ZonedDateTime;

public class Comment {
    private String username, text;
    private ZonedDateTime time;

    public Comment(String username, String text, ZonedDateTime time) {
        this.setUsername(username);
        this.setText(text);
        this.setTime(time);
    }

    public ZonedDateTime getTime() {
        return time;
    }

    public void setTime(ZonedDateTime time) {
        this.time = time;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}