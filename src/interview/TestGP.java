package interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestGP {
  //create teams
  // i/p: no_of_teams
  // 1st team should have most seniority , 1st -> last teams decreasing seniority

  public static void main(String[] args) {
    Team t1 = new Team("Toby", 1.5);
    Team t2 = new Team("John", 7.0);
    Team t3 = new Team("Joe", 3.0);
    Team t4 = new Team("Johny", 6.0);
    Team t5 = new Team("Johnie", 7.0);
    Team t6 = new Team("Jack", 1.0);
    Team t7 = new Team("Joey", 10.0);
    List<Team> teams = new ArrayList<>();
    teams.add(t1);
    teams.add(t2);
    teams.add(t3);
    teams.add(t4);
    teams.add(t5);
    teams.add(t6);
    teams.add(t7);
    int k = 3;
    System.out.println(getTeams(k, teams));
  }

  // 10, 4 , bucket-size : 3
  public static Map<Integer, List<Team>> getTeams(int k, List<Team> teams) {
    Collections.sort(teams, (t1, t2) -> t2.seniority.compareTo(t1.seniority) );
    int buckets = (int)Math.round(teams.size() / k);

    int buckIndx = 0;
    Map<Integer, List<Team>> result = new HashMap<>();
    List<Team> bucketList = new ArrayList<>();
    int listIdx = 0;
    //iterating over teams
    for(int idx = 0; idx < teams.size(); idx+=buckets ) {
      bucketList = new ArrayList<>();
      int count = 0;
          while(count < buckets) {
            bucketList.add(teams.get(buckIndx));
            buckIndx++;
            count++;
          }
          result.put(idx+1, bucketList);
    }
    return result;
  }
}

class Team {
  public String name;
  public Double seniority;

  public Team(String name, Double seniority) {
    this.name = name;
    this.seniority = seniority;
  }

  @Override
  public String toString() {
    return "exams.Team{" +
        "name='" + name + '\'' +
        ", seniority=" + seniority +
        '}';
  }
}

