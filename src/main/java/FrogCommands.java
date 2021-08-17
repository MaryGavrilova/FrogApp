public class FrogCommands {
    public static FrogCommand jumpRightCommand(Frog frog, int steps) {
        FrogCommand frogCommand = new FrogCommand() {
            @Override
            public boolean doCommand() {
                return frog.jump(steps);
            }

            @Override
            public boolean undoCommand() {
                return jumpLeftCommand(frog, steps).doCommand();
            }
        };
        return frogCommand;
    }

    public static FrogCommand jumpLeftCommand(Frog frog, int steps) {
        FrogCommand frogCommand = new FrogCommand() {
            @Override
            public boolean doCommand() {
                return frog.jump(-steps);
            }

            @Override
            public boolean undoCommand() {
                return jumpRightCommand(frog, steps).doCommand();
            }
        };
        return frogCommand;
    }
}
