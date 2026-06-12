package backend;

import java.util.Scanner;

public class OnlineExam {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== ONLINE EXAMINATION =====");

        System.out.print("Enter Username: ");
        String user = sc.nextLine();

        System.out.print("Enter Password: ");
        String pass = sc.nextLine();


        if(user.equals("admin") && pass.equals("1234")){

            System.out.println("Login Successful");

            System.out.println("\nExam Started");

            int score = 0;


            System.out.println("\nQ1. Java is?");
            System.out.println("1. Language");
            System.out.println("2. Database");

            int ans1 = sc.nextInt();

            if(ans1 == 1)
                score++;


            System.out.println("\nQ2. HTML is used for?");
            System.out.println("1. Website");
            System.out.println("2. OS");

            int ans2 = sc.nextInt();

            if(ans2 == 1)
                score++;


            System.out.println("\nQ3. CSS is used for?");
            System.out.println("1. Styling");
            System.out.println("2. Database");

            int ans3 = sc.nextInt();

            if(ans3 == 1)
                score++;



            System.out.println("\nExam Completed");

            System.out.println("Your Score = " + score + "/3");


            System.out.println("Logout Successful");


        }
        else{

            System.out.println("Invalid Login");

        }


        sc.close();

    }
}