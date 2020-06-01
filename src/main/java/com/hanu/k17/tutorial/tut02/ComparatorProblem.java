package com.hanu.k17.tutorial.tut02;

import java.util.*;

// Write your Checker class here
class Checker implements Comparator<Player> {
    public int compare(Player one, Player two) {
        if (one.score < two.score) {
            return 1;
        } else if (one.score > two.score) {
            return -1;
        }
        return one.name.compareTo(two.name);
    }
}

class Player{
    String name;
    int score;
    
    Player(String name, int score){
        this.name = name;
        this.score = score;
    }
}

class SolutionTwo {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Player[] player = new Player[n];
        Checker checker = new Checker();
        
        for(int i = 0; i < n; i++){
            player[i] = new Player(scan.next(), scan.nextInt());
        }
        scan.close();

        Arrays.sort(player, checker);
        for(int i = 0; i < player.length; i++){
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }
    }
}

/**
 * Comparator
 */
public class ComparatorProblem {

    public static void main(String[] args) {
        SolutionTwo.main(args);
    }
}