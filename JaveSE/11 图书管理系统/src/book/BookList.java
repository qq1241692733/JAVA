package book;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-01-2021/1/18
 * Time: 9:52
 */
public class BookList {

    private Book[] books;
    private int usedSize;

    public BookList() {
        this.books = new Book[10];
        books[0] = new Book("三国演义", "罗贯中", 12, "小说");
        books[1] = new Book("西游记",   "吴承恩", 20, "小说");
    }

    public void setBooks(int pos, Book book) {
        this.books[pos] = book;
    }

    public Book getBook(int pos) {
        return this.books[pos];
    }
}
