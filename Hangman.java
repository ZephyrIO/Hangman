import java.util.*;

public class Hangman {
    public static String[] possibleWords = {"tribute", "freedom", "favorable", "spite", "stake", "childish", "plain", "guerrilla", "sphere",
    "cigarette", "middle", "halt", "load", "pitch", "package", "canvas", "push", "convict", "bulb", "occasion", "blind", "arrogant", "crown",
    "sculpture", "home", "disco", "adopt", "brush", "forge", "penetrate", "conscience", "definition", "reception", "outer", "offense", "ranch",
    "theory", "merchant", "neck", "burial", "salesperson", "rotten", "mature", "regular", "braid", "scratch", "plagiarize", "nationalist", "habit",
    "organ"};

    public static void main (String[] args)
    {
        Scanner user = new Scanner(System.in);
        Random rand = new Random(System.currentTimeMillis());

        while(true)
        {
            int life = 4;
            String word = possibleWords[rand.nextInt(possibleWords.length)];
            char[] display = new char[word.length()];

            for (int i = 0; i < word.length(); i++)
            {
                display[i] = '_';
            } // for

            while(true)
            {
                for (int i = 0; i < word.length() - 1; i++)
                {
                    System.out.print(display[i] + " ");
                } // for
                System.out.println(display[word.length() - 1]);

                System.out.println("Lives Left:\t" + life);
                System.out.print("Please type a letter:\t");

                char input = user.next().charAt(0);
                user.nextLine();
                boolean charFound = false;

                for (int i = 0; i < word.length(); i++)
                {
                    if (input == word.charAt(i))
                    {
                        charFound = true;
                        display[i] = word.charAt(i);
                    } // if
                } // for

                if (!charFound)
                {
                    life--;
                } // if

                if (life <= 0)
                {
                    for (int i = 0; i < word.length() - 1; i++)
                    {
                        System.out.print(display[i] + " ");
                    } // for
                    System.out.println(display[word.length() - 1]);
                    System.out.println("You have lost...");
                    break;
                } // if

                boolean victory = true;
                for (int i = 0; i < word.length(); i++)
                {
                    if (display[i] == '_')
                    {
                        victory = false;
                    } // if
                } // for

                if (victory)
                {
                    for (int i = 0; i < word.length() - 1; i++)
                    {
                        System.out.print(display[i] + " ");
                    } // for
                    System.out.println(display[word.length() - 1]);
                    System.out.println("Congratulations! You have guessed the word!");
                    break;
                } // if
            } // while

            System.out.print("Game Over. Would you like to play again? (y/n)\t");
            String exit = user.next();
            user.nextLine();

            if (exit.equalsIgnoreCase("n"))
            {
                user.close();
                System.exit(0);
            } else {
                System.out.println("Game Resetting...");
                System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            } // if
        } // while
    } // main
} // Hangman