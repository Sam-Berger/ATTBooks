
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Book {

    private String title;
    private String date;
    private String author;
    private int length;

    public Book() {}

    public Book(String title, String date, String author, int length) {
        this.title = title;
        this.date = date;
        this.author = author;
        this.length = length;
    }


    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public LocalDate processedDate(){
        //I would be interested in using the Date class rather than LocalDate, but for some reason the parse function
        // is not working for me, so I used a work around.

        //This should work, but it doesn't. I am open to help from the reviewer.
//        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
//        return sdf.parse(date);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy", Locale.ENGLISH);
        LocalDate processedDate = LocalDate.parse(date, formatter);
        return processedDate;
    }

    public String getAuthor() {
        return author;
    }

    public int getLength() {
        return length;
    }
}
