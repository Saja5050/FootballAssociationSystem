package Service;

import Domain.*;
import Domain.Game.League;
import Domain.Game.Match;

import Domain.Game.MatchController;
import Domain.Game.Policy.GamePolicy;
import Domain.Game.Policy.GamePolicy.*;

import javax.swing.*;
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
    public  List<Match> scudualeMaches(String country,String policy,int season ) //TODO Dont forget to add season */
    {

        if(! (country.equalsIgnoreCase("israel") || country.equalsIgnoreCase("spain")) )
        {
            System.out.println("Country Not Exist!");
            return null;
        }


        if(temp.busyYear(country,season)!=null){
            System.out.println("Seasons Already BUSY!");
            ArrayList<Match> t=temp.busyYear(country,season);

            return null;
        }



        p1= new GamePolicy(country,season);
        List<Match> answer= p1.scheduleMatches(policy);

        for (Match match : answer){
            temp.insertMatch(match);
        }

        return answer;
    }


}
