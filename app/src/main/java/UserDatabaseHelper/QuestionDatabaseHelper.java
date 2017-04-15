package UserDatabaseHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;
import static java.util.Arrays.asList;

import Questions.Questions;
import Tables.QuestionTable;

/**
 * Created by sallyli on 4/15/17.
 */

public class QuestionDatabaseHelper extends SQLiteOpenHelper{
    public QuestionDatabaseHelper(Context context) {
        super(context, "Question", null, 0);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(QuestionTable.CREATE_QUERY);
        questionList(sqLiteDatabase);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int prevVersion, int newVersion) {
        sqLiteDatabase.execSQL(QuestionTable.DROP_QUERY);
        sqLiteDatabase.execSQL(QuestionTable.CREATE_QUERY);
    }

    private void questionList(SQLiteDatabase sqLiteDatabase){
        List<Questions> questions = asList(
                new Questions("Run a 10 mile", "Swim for 30 mins"),
                new Questions("Jump in a bowl of ice cream", "Endure nachos spa treatment"),
                new Questions("Meet Salt Bae", "Meet your high school crush"),
                new Questions("Dark code theme", "Light code theme"));

        for (Questions question : questions) {
            ContentValues values = new ContentValues();
            values.put(QuestionTable.OPTION1, question.getOption1());
            values.put(QuestionTable.OPTION2, question.getOption2());

            sqLiteDatabase.insert(QuestionTable.TABLE_NAME, null, values);
        }
    }

    public Cursor getQuestionCursor() {
        return this.getWritableDatabase().rawQuery(QuestionTable.SElECT_QUERY, null);
    }

    public ArrayList getArrayList() {
        ArrayList<String> questList = null;

        Cursor cursor = null;
        try {
            cursor = this.getWritableDatabase().rawQuery(QuestionTable.SElECT_QUERY, null);
            if (cursor != null && cursor.moveToFirst()) {
                questList = new ArrayList<String>();
                do {
                    questList.add(cursor.getString(0));
                } while (cursor.moveToNext());
            }
        } catch (Exception e) {
            e.printStackTrace();
            questList = null;
        } finally {
            if (cursor != null && !cursor.isClosed()) {
                cursor.deactivate();
                cursor.close();
                cursor = null;
            }
            close();
        }
        return questList;
    }

    public void close(SQLiteDatabase sqLiteDatabase) {
        try {
            if (sqLiteDatabase != null && sqLiteDatabase.isOpen()) {
                sqLiteDatabase.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
