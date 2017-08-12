package com.example.vijayavangapandu.booklistapplication;

/**
 * Created by vijayavangapandu on 8/3/17.
 */

public class Book {

    /** Id of the book */
    private String mId ;

    /** Title of the book */
    private String mTitle;

    /** Author of the book */
    private String mAuthor;

    /** Publisher of the book */
    private String mPublisher;

    /** PreviewLink of the book */
    private String mPreviewLink;

    // Constructs a new Object
    public Book(String mId, String mTitle, String mAuthor, String mPublisher, String mPreviewLink) {
        this.mId = mId;
        this.mTitle = mTitle;
        this.mAuthor = mAuthor;
        this.mPublisher = mPublisher;
        this.mPreviewLink = mPreviewLink;
    }

    // Returns  the id of the book
    public String getmId() {
        return mId;
    }

    // Returns  the preview link of the book
    public String getmPreviewLink() {
        return mPreviewLink;
    }

    // Returns  the title of the book
    public String getmTitle() {
        return mTitle;
    }

    // Returns  the author of the book
    public String getmAuthor() {
        return mAuthor;
    }

    // Returns  the publisher of the book
    public String getmPublisher() {
        return mPublisher;
    }
}
