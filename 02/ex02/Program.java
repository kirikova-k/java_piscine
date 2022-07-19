package ex02;
import java.io.IOException;
import java.nio.file.*;
import java.util.Scanner;

public class Program {
    private static final int START_PATH_POSITION = 17;
    private static final int DEFAULT_EXIT_CODE = 0;
    public static void main(String[] args) {
        Path startPath;
        if (args.length > 0 && args[0].startsWith("--current-folder=")) {
            startPath = Paths.get(args[0].substring(START_PATH_POSITION));
        } else {
            startPath = Paths.get(System.getenv("HOME"));
        }
        Commands cmds = new Commands(startPath);
        Scanner scan = new Scanner(System.in);
        String inputLine;
        while ((inputLine = scan.nextLine()) != null) {
            try {
                String[] command = inputLine.split(" ");
                switch (command[0]) {
                    case "ls":
                        cmds.ls();
                        break;
                    case "cd":
                        cmds.cd(Paths.get(command[1]));
                        break;
                    case "mv":
                        cmds.mv(Paths.get(command[1]), Paths.get(command[2]));
                        break;
                    case "exit":
                        scan.close();
                        System.exit(DEFAULT_EXIT_CODE);
                    default:
                        System.out.println("Unknown command. Type \"exit\" to quit the program");
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}