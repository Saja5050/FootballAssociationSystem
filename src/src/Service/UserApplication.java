package Service;

import Domain.*;
import Domain.Game.League;
import Domain.Game.Match;

import Domain.Game.MatchController;
import Domain.Game.Policy.GamePolicy;
import Domain.Game.Policy.GamePolicy.*;
import java.util.ArrayList;
import java.util.List;

public class UserApplication {


    MatchController temp=new MatchController();

    SystemManagerController userController=new SystemManagerController();
    RefereeController refereeController = new RefereeController();
    TeamController teamController=new TeamController();
    GamePolicy p1;

    public User sign_in( String UserName, String Password ) {
        User user = userController.sign_in(UserName,Password);

        return user;
    }
    public void insertReferee (String Name, String UserName, String Password ) {
        userController.insertReferee(Name, UserName, Password);
    }
    public ArrayList<String> getMatches(Referee referee) {
        ArrayList<String> matches = refereeController.getMatches(referee);
        return matches;
    }
    public  ArrayList<String> scudualeMaches(String country,String policy,int season ) //TODO Dont forget to add season */
    {
        p1= new GamePolicy(country);
        List<Match> answer= p1.scheduleMatches(policy);
        for (Match match : answer){
            temp.insertMatch(match);
        }
        //Match elem = answer.get(3);
        return null;
    }


}
