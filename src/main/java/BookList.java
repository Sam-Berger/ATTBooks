import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class BookList {

    //This is a helper function to determing he author with the most books on the list. One issues not mentioned in
    // the prompt is what to do if there are two authors with the same number of books. I have decided that is an
    // issue worth accounting for. If this were a real-life coding situation, I would simply ask the senior person
    // whether I should take the time to account for this or not. Instead of returning 1 author as a String, it
    // returns an ArrayList of author name Strings. Usually it will just be length 1, but it can be as long as the
    // bookList array.
    static ArrayList<String> maxAuthor(Book[] bookList) {

        //HashMap to how many books each author on the list has.
        HashMap<String, Integer> authorCount = new HashMap<String, Integer>();
        for (int i = 0; i < bookList.length; i++) {
            String author = bookList[i].getAuthor();
            if (authorCount.containsKey(author)) {
                authorCount.replace(author, authorCount.get(author) + 1);
            }
            else {
                authorCount.put(author, 1);
            }
        }

        //iterate through the hashmap to determine which authors book count is equal to the max, and then add to
        // maxAuthors ArrayList.
        int max = Collections.max(authorCount.values());
        ArrayList<String> maxAuthors = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : authorCount.entrySet()) {
            if (entry.getValue() == max) {
                maxAuthors.add(entry.getKey());
            }
        }
        return maxAuthors;
    }

    //This is a helper method to find the older book by an author in the bookList.
    //While having authors tied for first, I think it is unreasonable to think an author is releasing more than 1
    // book on the same day, so I did not take care to print out two books if that is the case, it will take the
    // first one it comes across. Although heres hoping that George RR Martin will surprise us all and release The
    // Winds of Winter and A Dream of Spring at the same time!
    static Book findOldestBook(Book[] bookList, String author) {
        Book oldestBook = new Book();

        for (int i = 0; i < bookList.length; i++) {
            if (bookList[i].getAuthor() == author) {
                //how to deal with first book by the author, which we can't compare dates with
                if (oldestBook.getDate() == null) {
                    oldestBook = bookList[i];
                }
                //compare current book's publish date with the current oldest, and replace if older
                else if (bookList[i].processedDate().isBefore(oldestBook.processedDate())) {
                    oldestBook = bookList[i];
                }
            }
        }
        return oldestBook;
    }

    static String printOldestBookOfMaxAuthor(Book[] bookList) {
        //The prompt wants us to make a program that can handle up to 100 pieces of data ("Books") at the same time,
        // but we want to limit it to less than 100 pieces of data

        if (bookList.length > 100) {
            return "Sorry, this program can only process at most 100 books at a time. Please use a " +
                    "shorter list.";
        }

        // Each author is mapped to a genre. With this few authors, it is easiest to maintain this just by
        // instantiating it and then calling it later for the output desired.
        // I am not a fan of this because it is reductive...it would be better for each book to have a genre and that
        // be used in the output. Steven King has written more than just Horror, and Isaac Asimov is prolific in
        // non-fiction as he is in fiction. While you could say that Asimov is a Science Fiction writer, you could
        // also say he is a non-fiction science author, and you would be correct either way, so mapping the genre to
        // the book would solve these problems.
        Map<String, String> authorGenreMap = Map.of("Steven King", "Horror", "Rudyard Kipling", "Adventure", "Isaac Asimov",
                "Science Fiction", "Suzanne Collins", "YA Fiction");

        //Here we are just running our earlier maxAuthor helper function from above.
        ArrayList<String> maxAuthors = maxAuthor(bookList);

        //since there might be more than one author with the most books, we want to make the output clearer. If there
        // is just one we can output the desires string. But if there is more than one, I want to let the user know
        // how many objects to expect, so we add a custom string about how many, and then return each output string
        // for the appropriate author.
        String multipleOutputs = "";
        if (maxAuthors.size() == 1) {
            Book oldestBook = findOldestBook(bookList, maxAuthors.get(0));
            return oldestBook.getTitle() + ", written by " + authorGenreMap.get(oldestBook.getAuthor()) + " " +
                    "writer " + oldestBook.getAuthor() + " on " + oldestBook.getDate() + " is " + oldestBook.getLength() + " pages long.";

        }
        if (maxAuthors.size() > 1) {
            multipleOutputs += "There are " + maxAuthors.size() + " authors who have tied for the most books on the " +
                    "list. The oldest book for each author is:\n";
            for (int i = 0; i < maxAuthors.size(); i++) {
                Book oldestBook = findOldestBook(bookList, maxAuthors.get(i));
                multipleOutputs += oldestBook.getTitle() + ", written by " + authorGenreMap.get(oldestBook.getAuthor()) + " " +
                        "writer " + oldestBook.getAuthor() + " on " + oldestBook.getDate() + " is " + oldestBook.getLength() + " pages long.\n";

            }
        }
        return multipleOutputs;
    }


    //I can control how the data is entered, per what I will put in the readme.
    // takes arraY? of books, and the processes them to output the oldest book by most cited author
    //this array cant be more than 100 items long.
    //"TITLE, written by GENRE writer AUTHOR on DATE OF PUBLICATION is LENGTH pages long."

}

