import java.util.Scanner;

public class Frenchie {

    public static void main(String[] args) {
        /*String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo); */
        String user_input = "";
        int counter = 1;
        String skeleton = "____________________________________________________________\n" +
                " Hello! I'm Frenchie\n" +
                " What can I do for you?\n" +
                "____________________________________________________________\n"
                /* " Bye. Hope to see you again soon!\n" +
                "____________________________________________________________\n" */;
        System.out.println(skeleton);


        Scanner scanner = new Scanner(System.in);
        while(true) {
            String input = scanner.nextLine();

            if(input.equals("bye")){
                System.out.println("____________________________________________________________\n" +
                        " Bye. Hope to see you again soon!\n" +
                        "____________________________________________________________\n");
                break;

            } else if (input.equals("list")) {
                System.out.println(user_input);
            } else {
                user_input += counter + ". " + input + "\n";
                counter += 1;
                input += "\n";
                System.out.println("____________________________________________________________\n" +
                        "added: " + input +
                        "____________________________________________________________\n");
            }
        }
    }
}
