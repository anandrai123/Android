package com.example.kiit.kiitwtpapp;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.strictmode.SqliteObjectLeakedViolation;

public class MyContentProvider extends ContentProvider {
    public MyContentProvider() {
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        Context c=getContext();
        SQLiteDatabase db=c.openOrCreateDatabase("AKR",Context.MODE_PRIVATE,null);
        int i=db.delete("student",selection,selectionArgs);
        return i;

    }

    @Override
    public String getType(Uri uri) {
    return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        Context c=getContext();
        SQLiteDatabase db=c.openOrCreateDatabase("AKR",Context.MODE_PRIVATE,null);
        db.insert("student",null,values);
        return uri;
    }

    @Override
    public boolean onCreate() {
        // TODO: Implement this to initialize your content provider on startup.
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        Context c=getContext();
        SQLiteDatabase db=c.openOrCreateDatabase("AKR",Context.MODE_PRIVATE,null);
        Cursor cur=db.query("student",projection,selection,selectionArgs,sortOrder,null,null);
        return cur;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        Context c=getContext();
        SQLiteDatabase db=c.openOrCreateDatabase("AKR",Context.MODE_PRIVATE,null);
        int i=db.update("student",values,selection,selectionArgs);
        return i;
    }
}
