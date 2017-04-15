package UserDatabaseHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.List;
import static java.util.Arrays.asList;

import Users.User;
import Tables.UserTable;

/**
 * Created by sallyli on 4/15/17.
 */

public class UserDatabaseHelper extends SQLiteOpenHelper{
    public UserDatabaseHelper(Context context) {
        super(context, "name", null, 0);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(UserTable.CREATE_QUERY);
        userList(sqLiteDatabase);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int prevVersion, int newVersion) {
        sqLiteDatabase.execSQL(UserTable.DROP_QUERY);
        sqLiteDatabase.execSQL(UserTable.CREATE_QUERY);
    }

    private void userList(SQLiteDatabase sqLiteDatabase){
        List<User> users = asList(
                new User("Sally", 1, 1),
                new User("Allen", 1, 2));

        for (User user : users) {
            ContentValues values = new ContentValues();
            values.put(UserTable.NAME, user.getName());
            values.put(UserTable.QUESTIONID, user.getQuestion());
            values.put(UserTable.ANSWER, user.getAnswer());

            sqLiteDatabase.insert(UserTable.TABLE_NAME, null, values);
        }
    }

    public Cursor getUserCursor() {
        return this.getWritableDatabase().rawQuery(UserTable.SElECT_QUERY, null);
    }

}
