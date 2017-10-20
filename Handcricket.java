package handcricket;

import java.util.Random;
import java.util.Scanner;

public class Handcricket {

    int max = 6;
    int systemnum;
    int batcount;
    int balcount;
    int flag1 = 0;
    int flag2 = 0;
    int f1 = 0;
    int f2 = 0;
    Random rand = new Random();
    Scanner scan = new Scanner(System.in);

    public int toss() {
        int res = Math.abs(rand.nextInt()) % 2;
        System.out.println("Enter your choice --> HEAD or TAILS");
        System.out.println("0.HEAD");
        System.out.println("1,TAILS");
        int ch = scan.nextInt();
        if(ch >1){
            System.out.println("Invalid Toss");
            System.out.println("pleaase try again.....");
            System.exit(0);
        }
         if (ch == res) {
            System.out.println("You won the toss");
            return 1;
        } else {
            System.out.println("Computer won the toss");
            return 0;
        }

    }

    public int victorycheck() {
        if (batcount > balcount) {
            return 1;
        } else if (batcount == balcount) {
            return 2;
        } else if (batcount < balcount) {
            return 3;
        }
        return -1;
    }

    public int randnum() {

        max = 6;
        systemnum = Math.abs(rand.nextInt()) % (max + 1);

        return systemnum;
    }

    public void BattingFunct() {
        int res;
        int bres;
        System.out.println("You choose to Bat");

        while (true) {

            if (flag2 == 1) {
                res = victorycheck();
                if (res == 1) {
                    System.out.println("Hurrah We Won the Match");
                    System.out.println("Your Score is : " + batcount);
                    System.out.println("Computer Score is : " + balcount);
                    System.exit(0);
                }
                if (res == 2 && f1 == 1) {
                    System.out.println(".......DRAW MATCH.......");
                    System.out.println("Ohh It's really a close match");
                    System.out.println("Your Score is : " + batcount);
                    System.out.println("Computer Score is : " + balcount);
                    System.exit(0);
                }

            }
            int num2 = randnum();
            System.out.println("rand num is :" + systemnum);

            System.out.println("Enter your number");
            int num = scan.nextInt();
            if (num > 6 || num < 0) {

                System.out.println("YOU MADE A WRONG ENTRY");
                System.out.println("PLEASE TRY AGAIN........");
                System.exit(0);

            }

            //int num2 = randnum();
            bres = batting(num, num2);
            if (bres == 0) {
                break;
            }

        }
        flag1 = 1;
    }

    public void BowlingFunct() {

        System.out.println("You choose to Bowl");
        int res;

        while (true) {
            if (flag1 == 1) {
                res = victorycheck();
                if (res == 3) {
                    System.out.println("Oops Computer Won the Match");
                    System.out.println("Your Score is : " + batcount);
                    System.out.println("Computer Score is : " + balcount);
                   // System.exit(0);
                }
                if (res == 2 && f2==1) {
                    System.out.println(".......DRAW MATCH.......");
                    System.out.println("Ohh It's really a close match");
                    System.out.println("Your Score is : " + batcount);
                    System.out.println("Computer Score is : " + balcount);
                    System.exit(0);
                }

            }
            int num2 = randnum();
            System.out.println("rand num is :" + systemnum);

            System.out.println("Enter your number");
            int num = scan.nextInt();
            if (num > 6 || num < 0) {

                System.out.println("YOU MADE A WRONG ENTRY");
                System.out.println("PLEASE TRY AGAIN........");
                System.exit(0);

            }

            //int num2=randnum();
            int bres = bowling(num, num2);
            if (bres == 0) {
                break;
            }
        }
        flag2 = 1;

    }

    public int batting(int num, int systemnum) {

        System.out.println("Computer : " + systemnum);
        System.out.println("Player : " + num);

        if (num == systemnum) {
            f1=1;
            System.out.println("your score is : " + batcount);
            System.out.println("Sorry buddy You are out......");
            return 0;
        } else {
            batcount = batcount + num;
            System.out.println("your score is : " + batcount);
            return 1;
        }
    }

    public int bowling(int num, int systemnum) {

        System.out.println("Player : " + num);
        System.out.println("Computer : " + systemnum);

        if (num == systemnum) {
            f2=1;
            System.out.println("Computer score is : " + balcount);
            System.out.println();
            System.out.println("Hurrah Computer is out......");
            return 0;
        } else {
            balcount = balcount + systemnum;
            System.out.println("Computer score is : " + balcount);
            return 1;

        }
    }

    public static void main(String[] args) {
        Handcricket hc = new Handcricket();

        int choice;

        System.out.println("Welcome to our HAND - CRICKET GAME");
        System.out.println("==================================");
        int toss = hc.toss();
        if (toss == 1) {
            System.out.println("Enter your choice");
            System.out.println("1.Batting");
            System.out.println("2.Bowling");
            choice = hc.scan.nextInt();
        } else {

            choice = Math.abs(hc.rand.nextInt()) % 2;
            if (choice == 0) {
                choice += 1;
            }
        }

        switch (choice) {

            case 1:
                hc.BattingFunct();

            case 2:
                hc.BowlingFunct();
                hc.BattingFunct();

        }

    }
}
