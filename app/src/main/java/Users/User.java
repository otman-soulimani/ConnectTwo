package Users;

/**
 * Created by sallyli on 4/15/17.
 */

public class User {
    private String name;
    private int questionID;
    private int answer; //Option 1 = 1, Option 2 = 2

    public User(String name, Integer questionID, Integer answer){
        this.name = name;
        this.questionID = questionID;
        this.answer = answer;
    }

    public String getName(){
        return name;
    }

    public int getQuestion(){
        return questionID;
    }

    public int getAnswer(){
        return answer;
    }


}
