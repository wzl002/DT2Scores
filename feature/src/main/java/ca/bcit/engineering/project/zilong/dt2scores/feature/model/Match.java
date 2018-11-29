package ca.bcit.engineering.project.zilong.dt2scores.feature.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Match {

    private Date date;
    private Team team1;
    private Team team2;
    private int team1Score;
    private int team2Score;

    public Match(int month, int date, int hour, String team1Name, String team2Name) {
        Calendar cal = Calendar.getInstance();
        int year = Calendar.getInstance().get(Calendar.YEAR);
        cal.set(year, month, date, hour, 0);
        this.date = cal.getTime();
        this.team1 = new Team(team1Name);
        this.team2 = new Team(team2Name);
    }

    public Match(int month, int date, int hour, String team1Name, String team2Name, int team1Score, int team2Score) {
        this(month, date, hour, team1Name, team2Name);
        this.team1Score = team1Score;
        this.team2Score = team2Score;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Team getTeam1() {
        return team1;
    }

    public void setTeam1(Team team1) {
        this.team1 = team1;
    }

    public Team getTeam2() {
        return team2;
    }

    public void setTeam2(Team team2) {
        this.team2 = team2;
    }

    public int getTeam1Score() {
        return team1Score;
    }

    public void setTeam1Score(int team1Score) {
        this.team1Score = team1Score;
    }

    public int getTeam2Score() {
        return team2Score;
    }

    public void setTeam2Score(int team2Score) {
        this.team2Score = team2Score;
    }

    @Override
    public String toString() {
        SimpleDateFormat format = new SimpleDateFormat("MMM dd HH:mm");
        return format.format(date) + "  -  " + team1.getName() + " VS " + team2.getName() + " \n" + team1Score + "\t" + team2Score;
    }

    public String getFormatedDate() {
        SimpleDateFormat format = new SimpleDateFormat("MMM dd HH:mm");
        return format.format(date);
    }
}
