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

    public static void main (String args[]){
        MatchController temp=new MatchController();
        GamePolicy p1= new GamePolicy("Israel");
        List<Match> answer= p1.scheduleMatches("2");
        for (Match match : answer){
            temp.insertMatch(match);
        }
        Match elem = answer.get(3);
    }
    UserController userController=new UserController();
    RefereeController refereeController = new RefereeController();
    TeamController teamController=new TeamController();
    public User sign_in( String UserName, String Password ) {
        User user = userController.sign_in(UserName,Password);
        System.out.println(user);
        return user;
    }
    public void insertReferee (String Name, String UserName, String Password ) {
        refereeController.insertReferee(Name, UserName, Password);
    }
    public ArrayList<String> getMatches(Referee referee) {
        ArrayList<String> matches = refereeController.getMatches(referee);
        return matches;
    }
    public  ArrayList<String> scudualeMaches(String Country){
        System.out.println(teamController.getTeams(Country));
        return null;
    }


}
