package Domain;

public class Coach {
    String Name;
    String Team;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getTeam() {
        return Team;
    }

    public void setTeam(String team) {
        Team = team;
    }

    public Coach(String Name, String Team){
        this.Name = Name;
        this.Team = Team;
    }
}
