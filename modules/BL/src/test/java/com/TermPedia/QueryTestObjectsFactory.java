package com.TermPedia;

import com.TermPedia.dto.*;
import com.TermPedia.dto.exceptions.ActionsException;
import com.TermPedia.queries.books.BookQueryResult;
import com.TermPedia.queries.books.RatedBookQueryResult;
import com.TermPedia.queries.books.TagBookQueryResult;
import com.TermPedia.queries.instances.authors.AuthorQueryResult;
import com.TermPedia.queries.instances.tags.RatedTagQueryResult;
import com.TermPedia.queries.instances.tags.TagQueryResult;
import com.TermPedia.queries.instances.terms.TermQueryResult;
import com.TermPedia.queries.instances.types.LitTypesQueryResult;

import java.util.Arrays;
import java.util.Vector;

public class QueryTestObjectsFactory {
    public static Book createAlbum(String[] authors) throws ActionsException {
        Vector<String> _authors = new Vector<>(Arrays.stream(authors).toList());
        return new Book("Kamnem po golove", "Album", 1996, _authors);
    }

    public static Book emptyBook() throws ActionsException {
        Vector authors = new Vector();
        authors.add("Uncle Bob");
        return new Book("Some book", "Some Type", 2022, authors);
    }

    public static TermQueryResult termsVector() {
        Vector<Term> terms = new Vector<>();
        terms.add(new Term("OOP", "PPO"));
        return new TermQueryResult(terms);
    }

    public static TagQueryResult tagsVector() {
        Vector<Tag> tags = new Vector<>();
        tags.add(new Tag("IT"));
        return new TagQueryResult(tags);
    }

    public static RatedTagQueryResult ratedTagsVector() {
        Vector<RatedTag> tags = new Vector<>();
        tags.add(new RatedTag("IT", 3.0, 5, 5));
        return new RatedTagQueryResult(tags);
    }
    public static AuthorQueryResult authorsVector() {
        Vector<String> vector = new Vector<>();
        vector.add("ABC");

        AuthorQueryResult result = new AuthorQueryResult(vector);
        return result;
    }

    public static LitTypesQueryResult litTypesVector() {
        Vector<String> types = new Vector<>();
        types.add("Article");
        return new LitTypesQueryResult(types);
    }


    public static BookQueryResult commonBooks() throws ActionsException {
        Vector<Book> books = new Vector<>();
        Vector<String> authors = QueryTestObjectsFactory.stdAuthors();

        books.add(QueryTestObjectsFactory.commonBook(authors));
        return new BookQueryResult(books);
    }

    public static TagBookQueryResult tagBooks() throws ActionsException {
        Vector<TagBook> books = new Vector<>();
        Vector<String> authors = QueryTestObjectsFactory.stdAuthors();

        books.add(QueryTestObjectsFactory.tagBook(authors));
        return new TagBookQueryResult(books);
    }

    public static RatedBookQueryResult ratedBooks() throws ActionsException {
        Vector<RatedBook> books = new Vector<>();
        Vector<String> authors = QueryTestObjectsFactory.stdAuthors();

        books.add(QueryTestObjectsFactory.ratedBook(authors));
        return new RatedBookQueryResult(books);
    }


    public static Book commonBook(Vector<String> authors) throws ActionsException {
        if (authors == null)
            authors = QueryTestObjectsFactory.stdAuthors();
        return new Book("GOF", "Book", 2020, authors);
    }

    public static TagBook tagBook(Vector<String> authors) throws ActionsException {
        if (authors == null)
            authors = QueryTestObjectsFactory.stdAuthors();
        return new TagBook("GOF", "Book", 2020, authors, 3.0);
    }

    public static RatedBook ratedBook(Vector<String> authors) throws ActionsException {
        if (authors == null)
            authors = QueryTestObjectsFactory.stdAuthors();
        return new RatedBook("GOF", "Book", 2020, authors, 3.0, 5);
    }

    private static Vector<String> stdAuthors() {
        Vector<String> authors = new Vector<>();
        authors.add("ABC");
        return authors;
    }
}
