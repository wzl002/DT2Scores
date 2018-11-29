package ca.bcit.engineering.project.zilong.dt2scores.feature.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MatchData {

    private static List<Match> matchList = new ArrayList<Match>();

    public static List<Match> getMatchList() {
        if(matchList.size() < 1){
            initMatchList();
        }
        return matchList;
    }

    public static void initMatchList() {
        matchList.add(new Match(11, 28,22, "EHOME", "Newbee.Y"));
        matchList.add(new Match(11, 28,22, "PSG.LGD", "Root"));
        matchList.add(new Match(11, 28,22, "IG", "ASTER"));
        matchList.add(new Match(11, 28,22, "RNG", "VG"));
        matchList.add(new Match(11, 29,0, "FTD", "RNG"));
        matchList.add(new Match(11, 29,0, "Root", "KG"));
        matchList.add(new Match(11, 29,0, "PSD.LGD", "Newbee.Y"));
        matchList.add(new Match(11, 29,0, "VG", "IG"));
        matchList.add(new Match(11, 29,2, "KG", "EHOME"));
        matchList.add(new Match(11, 29,2, "ASTER", "FTG"));
        MatchData.matchList = matchList;
    }
}
