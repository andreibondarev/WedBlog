package com.weddingwire.wedblog.models;

/**
 * Created by gregloesch on 7/7/14.
 */
public class Post {

    private String mTitle;
    private String mAuthorName;
    private String mBody;

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getAuthorName() {
        return mAuthorName;
    }

    public void setAuthorName(String authorName) {
        mAuthorName = authorName;
    }

    public String getBody() {
        return mBody;
    }

    public void setBody(String body) {
        mBody = body;
    }

    @Override
    public String toString() {
        return mTitle;
    }

}
