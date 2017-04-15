package Tables;

import android.provider.BaseColumns;

/**
 * Created by sallyli on 4/15/17.
 */

public class UserTable implements BaseColumns{
    public static final String NAME = "name";
    public static final String QUESTIONID = "questionID";
    public static final String ANSWER = "answer";
    public static final String TABLE_NAME = "User Responses";

    public static final String CREATE_QUERY = "create table " + TABLE_NAME + " (" +
            _ID + " INTEGER, " +
            NAME + " TEXT, " +
            QUESTIONID + "INTEGER" +
            ANSWER + " INTEGER)";

    public static final String DROP_QUERY = "drop table " + TABLE_NAME;
    public static final String SElECT_QUERY = "select * from " + TABLE_NAME;

}
