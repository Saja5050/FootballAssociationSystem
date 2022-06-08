package Domain.Game.Policy;

import DataAccess.RefereeDaoSQL;
import Domain.Game.League;
import Domain.Game.Match;
import Domain.Referee;
import Domain.Team;

import java.sql.Date;
import java.util.*;
//import java.time.LocalDate;
import java.lang.Object;
import org.joda.time.*;


public class GamePolicy  {
    private String identified;
    private League l1;
    private ArrayList<Team> toSchedule;
    private int numOfRounds;
    private int gamesPerDay;
    private int season;
    public GamePolicy(String CountryName, int season){
        this.l1= new League(CountryName,season-1900);
        if(CountryName.equalsIgnoreCase("spain")){
            toSchedule=League.spainLeague;

        }else{
            toSchedule=League.israeliLeague;
        }
        this.numOfRounds=toSchedule.size()-1;
        this.gamesPerDay=2;
        this.season=season;
    }

    public List<Match> scheduleMatches(String policy){
        List<Match> temp;
        if(policy.equals("1")){
       temp =scheduleFirstRound(toSchedule);


        }
        else{

            temp=  scheduleFirstRound(toSchedule);
            Collections.reverse(toSchedule);
            temp.addAll(scheduleFirstRound(toSchedule)) ;
            Collections.reverse(toSchedule);
        }

    return temp;
    }
    public void scheduleDateandHours(int matchPerRound, ArrayList<Match> matchesList){
        Calendar c = Calendar.getInstance();
        int round =0;
        int correntIndex=0;



        while(correntIndex<=matchesList.size()-matchPerRound){
            ArrayList<String> refs=getTwoRefs();
            for(int i =0;i<matchPerRound; i ++)
            {
                matchesList.get(correntIndex+i).setDate( l1.getStartDate());
                matchesList.get(correntIndex+i).setTime(l1.getOfficalTime());
                matchesList.get(correntIndex+i).setRef( refs.get(i));

            }
//            int year=l1.startDate.getYear();
//            int month = l1.startDate.getMonth();
//            int day=l1.startDate.getDay();
//            c.setTime(l1.startDate);
//            correntIndex+=matchPerRound;
//            c.add(c.DATE, 7);
            Date sqlDate = l1.getStartDate();
            LocalDate date = new LocalDate(sqlDate.getTime(), DateTimeZone.UTC);
            LocalDate tomorrow = date.plusDays(7);

            DateTime startOfDay = tomorrow.toDateTimeAtStartOfDay(DateTimeZone.UTC);

//            year =c.get(Calendar.YEAR);
//            month=c.get(Calendar.MONTH);
//            day=c.get(Calendar.DAY_OF_MONTH);

            Date d=new Date(startOfDay.getMillis());
            l1.setStartDate(d);
            correntIndex+=2;


        }


    }
//    private void addMatchToTeams(Match match, Team homeTeam, Team awayTeam) {
//        if (match != null && homeTeam != null && awayTeam != null) {
//            homeTeam.setHomeMatches(match);
//            awayTeam.setAwayMatches(match);
//        }
//    }
    private List<Match> scheduleFirstRound(ArrayList<Team> toSchedule) {
        ArrayList<Match> matchesList = new ArrayList<>();

        if (toSchedule.size() > 0) {
            List<Team> teamList = toSchedule;


//            // if number of teams is odd - Whoever is matched against the nullTeam gets a free round.
//            if (teamList.size() % 2 != 0) {
//                teamList.add(new Team("NullTeam", false, false));
//            }

            //creates list without the first team because its place doesn't change while the algorithm
            List<Team> teamListWithoutFirstTeam = new ArrayList<>(teamList);
            teamListWithoutFirstTeam.remove(0);

            int numberOfGamesForEachTeamInRound = teamList.size() - 1;
            Match matchToAdd;

            //Assign matches according to round-robin tournament algorithm - rotates the team clockwise every loop - This is only the FIRST ROUND
            for (int i = 0; i < numberOfGamesForEachTeamInRound; i++) {

                //rotate the team according to the current round
                int teamIndex = i % (teamListWithoutFirstTeam.size());
           ;

                //the first team at index 0 never changes, but every round the homeAway method changes.
                if (!teamListWithoutFirstTeam.get(teamIndex).getName().equals("NullTeam")) {
                    if (i % 2 == 0) {

                        matchToAdd = new Match(null,teamList.get(0).getName(), teamListWithoutFirstTeam.get(teamIndex).getName(), l1.getName(), null,l1.getOfficalTime(),this.season);
                    } else {
                        matchToAdd = new Match(null, teamList.get(0).getName(), teamListWithoutFirstTeam.get(teamIndex).getName(),l1.getName() ,null,l1.getOfficalTime(),this.season);

                    }
                    matchesList.add(matchToAdd);
                }




                //runs over the teamsList ( except the first team at index 0 that we already set ), and schedule matches according to their indexes.
                //every loop the indexes change, so that at the end of the loops every team scheduled against all the other teams.
                for (int j = 1; j < teamList.size() / 2; j++) {

                    int firstTeamIndex = (i + j) % teamListWithoutFirstTeam.size();
                    int secondTeamIndex = (i + teamListWithoutFirstTeam.size() - j) % teamListWithoutFirstTeam.size();

                    Team firstTeam = teamListWithoutFirstTeam.get(firstTeamIndex);
                    Team secondTeam = teamListWithoutFirstTeam.get(secondTeamIndex);

                    //don't add the free game while the league has odd number of teams.
                    if (!firstTeam.getName().equals("NullTeam") && !secondTeam.getName().equals("NullTeam")) {

                        //changes between home and away.
                        if (i % 2 == 0) {
                            matchToAdd = new Match(null, firstTeam.getName(), secondTeam.getName(), l1.getName(), null,l1.getOfficalTime(),this.season);

                        } else {
                            matchToAdd = new Match(null, secondTeam.getName(), firstTeam.getName(), l1.getName(), null,l1.getOfficalTime(),this.season);

                        }

                        matchesList.add(matchToAdd);
                    }



                }
            }
        }
        scheduleDateandHours(2,matchesList);
        matchesList.add(null);
        return matchesList;
    }

//    public List<Match> scheduleMatches( ) {
//        if (l1 != null) {
//            //calculates first round and the rest of the rounds will be based on it.
//            List<Match> matchesList = scheduleFirstRound(toSchedule);
//            Match matchToAdd;
//
//            //add matches according to number of rounds needed - runs over the matchList and changes the HomeAway setting for each match.
//            int totalMatchesLastToAdd = (numOfRounds - 1) * matchesList.size();
//            for (int i = 0; i < totalMatchesLastToAdd; i++) {
//                matchToAdd = new Match(null, matchesList.get(i).getAway(), matchesList.get(i).getHome(), l1.getName(), null,null);
////                addMatchToTeams(matchToAdd, matchesList.get(i).getAwayTeam(), matchesList.get(i).getHomeTeam());
//                matchesList.add(matchToAdd);
//            }
//
//
//            return matchesList;
//        }
//        return null;
//    }
public  ArrayList<String> getTwoRefs()
{
    RefereeDaoSQL referee_dao=RefereeDaoSQL.getInstance();
    ArrayList<String> twoRefs=new ArrayList<String>();
    ArrayList<Referee> allRefs=referee_dao.getAllreferess();

    Random rn = new Random();
    int ran=rn.nextInt(allRefs.size()-2); // Size Returns len of list

    twoRefs.add(allRefs.get(ran).getUsername());
    twoRefs.add(allRefs.get(ran+1).getUsername());

    return twoRefs;

}
}
