import java.util.*;

public class Main {

    public static void main(String[] args) {
        String test =       "5 4" + "\n" +
                            "0 Monday 4 april 13-15" + "\n" +
                            "1 Tuesday 5 april 10-12" + "\n" +
                            "2 Wednesday 6 april 13-15" + "\n" +
                            "3 Thursday 7 april 8-10" + "\n" +
                            "4 Friday 8 april 10-12" + "\n" +
                            "kalle 0 1 2" + "\n" +
                            "nisse 2 3" + "\n" +
                            "sara 3 0" + "\n" +
                            "ali 0 4";

        String testout =    "0 Monday 4 april 13-15 3" + "\n" +
                            "2 Wednesday 6 april 13-15 2" + "\n" +
                            "3 Thursday 7 april 8-10 2" + "\n" +
                            "1 Tuesday 5 april 10-12 1" + "\n" +
                            "4 Friday 8 april 10-12 1";

        List ts1 = new ArrayList();
        List ts2 = new ArrayList();
        Scanner input = new Scanner(test);
        int m = input.nextInt();
        int d = input.nextInt();
        input.nextLine();
        for (int i = 0; i < m ; i++) {
            ts1.add(new MeetingTime (input.nextLine(),0));
        }
        int[] popArray = new int[m];
        for (int i = 0; i < d; i++) {
            input.next();
            while (input.hasNextInt()) {
                int j = input.nextInt();
                popArray[j] = popArray[j] + 1;
            }
        }
        System.out.println(Arrays.toString(popArray));

        for (int i = 0; i < m ; i++) {
            int j = popArray[i];
            ts2.add(new MeetingTime (ts1.get(i).toString(),j));
        }

        Collections.sort(ts2);
        Iterator itr = ts2.iterator();
        int j = 0;
        Arrays.sort(popArray);
        while(itr.hasNext()){
            Object element = itr.next();
            System.out.print(element + " " + popArray[m-1-j] + "\n");
            j++;

        }

        /*
        List ts1 = new ArrayList();
        ts1.add(new MeetingTime ("Tom",40000));
        ts1.add(new MeetingTime ("Harry",20000));
        ts1.add(new MeetingTime ("Maggie",50000));
        ts1.add(new MeetingTime ("Chris",70000));
        Collections.sort(ts1);
        Iterator itr = ts1.iterator();

        while(itr.hasNext()){
            Object element = itr.next();
            System.out.println(element + "\n");

        }

        System.out.print(test + "\n\n" + testout);
        */

    }


}

class MeetingTime implements Comparable {

    int TimeID;
    String MeetPref;
    int Popularity;
    static int i;

    public MeetingTime() {
        TimeID = i++;
        MeetPref = "dont know";
        Popularity = 0;
    }

    public MeetingTime(String meetpref, int pop) {
        TimeID = i++;
        MeetPref = meetpref;
        Popularity = pop;
    }

    public String toString() {
        return MeetPref;
    }

    public int compareTo(Object o1) {
        if (this.Popularity == ((MeetingTime) o1).Popularity)
            return 0;
        else if ((this.Popularity) > ((MeetingTime) o1).Popularity)
            return -1;
        else
            return 1;
    }
}
