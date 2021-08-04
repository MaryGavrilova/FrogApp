import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            Frog frog = new Frog();
            List<FrogCommand> commands = new ArrayList<>();
            int curCommand = -1;
            System.out.println("Варианты команд:\n" +
                    "+N - прыгни на N шагов направо\n" +
                    "-N - прыгни на N шагов налево\n" +
                    "= - выйди на ближайший берег\n" +
                    "<< - отмени последнюю команду\n" +
                    "!! - повтори последнюю команду\n" +
                    "0 - выход");
            print(frog);
            while (true) {
                System.out.println("Введи команду, выбрав из вариантов:");
                String input = scanner.nextLine();
                if (input.equals("0")) {
                    print(frog);
                    break;
                }
                if (input.equals("<<")) {
                    if (curCommand < 0) {
                        System.out.println("Нечего отменять!");
                    } else {
                        FrogCommand cmd = commands.get(curCommand);
                        cmd.undoCommand();
                        commands.remove(curCommand);
                        curCommand--;
                        print(frog);
                    }
                } else if (input.equals("!!")) {
                    if (curCommand < 0) {
                        System.out.println("Нечего повторять!");
                    } else {
                        FrogCommand cmd = commands.get(curCommand);
                        if (cmd.doCommand()) {
                            commands.add(cmd);
                            curCommand++;
                        }
                        print(frog);
                    }
                } else if (input.equals("=")) {
                    FrogCommand cmd = FrogCommands.comeAshoreCommand(frog, frog.getPosition());
                    if (cmd.doCommand()) {
                        commands.add(cmd);
                        curCommand++;
                    }
                    print(frog);
                } else {
                    FrogCommand cmd = FrogCommands.jumpCommand(frog, Integer.parseInt(input));
                    if (cmd.doCommand()) {
                        commands.add(cmd);
                        curCommand++;
                    }
                    print(frog);
                }
            }
        } catch (NumberFormatException exception) {
            System.out.println("Команда для прыжка введена некорректно");
        }
    }

    public static void print(Frog frog) {
        for (int i = Frog.MIN_POSITION; i < Frog.MAX_POSITION + 1; i++) {
            if (i == frog.getPosition()) {
                System.out.print("| (" + i + ") ");
                continue;
            }
            System.out.print("| " + i + " ");
        }
        System.out.println();
    }
}
