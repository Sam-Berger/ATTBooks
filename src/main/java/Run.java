public class Run {
    public static void main(String[] args) {

        Book[] sampleBookList1 = {
                new Book("Carrie", "06/13/1982", "Steven King", 762),
                new Book("The Stand", "01/01/1984", "Steven King", 1200),
                new Book("The Hunger Games", "11/12/2013", "Suzanne Collins", 600),
                new Book("The Jungle Book", "03/21/1898", "Rudyard Kipling", 483),
                new Book("Kim", "02/03/1910", "Rudyard Kipling", 526),
                new Book("I Robot", "08/11/1945", "Isaac Asimov", 474),
                new Book("Firestarter", "04/01/1982", "Steven King", 597)
        };

        Book[] sampleBookList2 = {
                new Book("Carrie", "06/13/1982", "Steven King", 762),
                new Book("I Robot", "08/11/1945", "Isaac Asimov", 474),
                new Book("The Jungle Book", "03/21/1898", "Rudyard Kipling", 483),
                new Book("Kim", "02/03/1910", "Rudyard Kipling", 526),
                new Book("Mockingjay", "08/09/2014", "Suzanne Collins", 642)
        };

        //your book list
//        Book[] yourBookList = {
                //enter in the books you want to use here to run the function
//        };


        System.out.println(BookList.printOldestBookOfMaxAuthor(sampleBookList1));
        System.out.println(BookList.printOldestBookOfMaxAuthor(sampleBookList2));

    }
}
