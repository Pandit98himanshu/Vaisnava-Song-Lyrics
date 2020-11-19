package com.example.android.practice;

public class Song {
    // Store the name of the song
    private String mName;

    // Store the resource ids of the song
    private int mDetailsResourceId, mLyricsResourceId, mTranslationResourceId;

    // Constructor that is used to create an instance of the Song object
    public Song(String mName, int mDetailsResourceId, int mLyricsResourceId, int mTranslationResourceId) {
        this.mName = mName;
        this.mDetailsResourceId = mDetailsResourceId;
        this.mLyricsResourceId = mLyricsResourceId;
        this.mTranslationResourceId = mTranslationResourceId;
    }

    public String getmName() {
        return mName;
    }

    public int getmDetailsResourceId() {
        return mDetailsResourceId;
    }

    public int getmLyricsResourceId() {
        return mLyricsResourceId;
    }

    public int getmTranslationResourceId() {
        return mTranslationResourceId;
    }
}
