package com.example.languagelearningpro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBHandler extends SQLiteOpenHelper {

    private static final String DB_NAME = "learners_app_db";

    private static final int DB_VERSION = 1;

    private static final String TABLE_NAME = "users_tbl";

    private static final String LESSON_TABLE_NAME = "lessons";

    private static final String ID_COL = "id";


    private static final String LESSON_NAME_COL = "lesson_name";

    private static final String TITLE_COL = "tittle";


    private static final String DESCRIPTION_COL = "description";

    private static final String USER_NAME_COL = "user_name";

    private static final String EMAIL_COL = "email";

    private static final String PASSWORD_COL = "password";



    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    // below method is for creating a database by running a sqlite query
    @Override
    public void onCreate(SQLiteDatabase db) {
        // on below line we are creating
        // an sqlite query and we are
        // setting our column names
        // along with their data types.
        String query = "CREATE TABLE " + LESSON_TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + LESSON_NAME_COL + " TEXT,"
                + TITLE_COL + " TEXT,"
                + DESCRIPTION_COL + " TEXT)";

        // at last we are calling a exec sql
        // method to execute above sql query
        db.execSQL(query);


        query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + USER_NAME_COL + " TEXT,"
                + EMAIL_COL + " TEXT,"
                + PASSWORD_COL + " TEXT)";

        db.execSQL(query);
    }

    public void addNewLesson(String lessonName, String title, String description) {


        SQLiteDatabase db = this.getWritableDatabase();


        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put(LESSON_NAME_COL, lessonName);
        values.put(TITLE_COL, title);
        values.put(DESCRIPTION_COL, description);


        // after adding all values we are passing
        // content values to our table.
        db.insert(LESSON_TABLE_NAME, null, values);

        // at last we are closing our
        // database after adding database.
        db.close();
    }

    public void addNewUser(String userName, String email, String password) {

        SQLiteDatabase db = this.getWritableDatabase();


        ContentValues values = new ContentValues();

        values.put(USER_NAME_COL, userName);
        values.put(EMAIL_COL, email);
        values.put(PASSWORD_COL, password);

        db.insert(TABLE_NAME, null, values);

        db.close();
    }

    // we have created a new method for reading all the courses.
    public ArrayList<LessonItem> readLessons() {
        // on below line we are creating a
        // database for reading our database.
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursorLessons = db.rawQuery("SELECT * FROM " + LESSON_TABLE_NAME, null);

        // on below line we are creating a new array list.
        ArrayList<LessonItem> lessonItemModalArrayList = new ArrayList<>();

        // moving our cursor to first position.
        if (cursorLessons.moveToFirst()) {
            do {
                // on below line we are adding the data from cursor to our array list.
                lessonItemModalArrayList.add(new LessonItem(cursorLessons.getString(0),
                        cursorLessons.getString(1),
                        cursorLessons.getString(2),
                cursorLessons.getString(3)));
            } while (cursorLessons.moveToNext());
            // moving our cursor to next.
        }

        // at last closing our cursor
        // and returning our array list.
        cursorLessons.close();
        return lessonItemModalArrayList;
    }


    public ArrayList<User> readUsers() {
        // on below line we are creating a
        // database for reading our database.
        SQLiteDatabase db = this.getReadableDatabase();

        // on below line we are creating a cursor with query to read data from database.
        Cursor cursorMeals = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        // on below line we are creating a new array list.
        ArrayList<User> useArrayList = new ArrayList<>();

        // moving our cursor to first position.
        if (cursorMeals.moveToFirst()) {
            do {
                // on below line we are adding the data from cursor to our array list.
                useArrayList.add(new User(cursorMeals.getString(0),
                        cursorMeals.getString(1),
                        cursorMeals.getString(2),
                        cursorMeals.getString(3)));
            } while (cursorMeals.moveToNext());
            // moving our cursor to next.
        }

        // at last closing our cursor
        // and returning our array list.
        cursorMeals.close();
        return useArrayList;
    }



    public int deleteUser(String cropName) {

        SQLiteDatabase db = this.getWritableDatabase();

        String whereClause = ID_COL + " = ?";
        String[] whereArgs = new String[]{String.valueOf(cropName)};

//for multiple condition, join them with AND
//String whereClause = KEY_NAME1 + " = ? AND " + KEY_NAME2 + " = ?";
//String[] whereArgs = new String[]{String.valueOf(KEY_VALUE1), String.valueOf(KEY_VALUE2)};

        int numRowsDeleted = db.delete(TABLE_NAME, whereClause, whereArgs);
        db.close();

        return numRowsDeleted;
    }

    public void deleteAll() {

        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, null, null);
        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // this method is called to check if the table exists already.
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}

