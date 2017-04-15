package Tables;

import android.provider.BaseColumns;

/**
 * Created by sallyli on 4/15/17.
 */

public class QuestionTable implements BaseColumns{
    public static final String TABLE_NAME = "Questions";
    public static final String OPTION1 = "answer";
    public static final String OPTION2 = "User Responses";

    public static final String CREATE_QUERY = "create table " + TABLE_NAME + " (" +
            _ID + " INTEGER, " +
            OPTION1 + "STRING"+
            OPTION2 + " STRING)";

    public static final String DROP_QUERY = "drop table " + TABLE_NAME;
    public static final String SElECT_QUERY = "select * from " + TABLE_NAME;

}
