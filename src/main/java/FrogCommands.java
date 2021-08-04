public class FrogCommands {
    public static FrogCommand jumpCommand(Frog frog, int steps) {
        FrogCommand frogCommand = new FrogCommand() {
            @Override
            public boolean doCommand() {
                return frog.jump(steps);
            }

            @Override
            public boolean undoCommand() {
                return frog.jump(steps * (-1));
            }
        };
        return frogCommand;
    }

    public static FrogCommand comeAshoreCommand(Frog frog, int currentPosition) {
        FrogCommand frogCommand = new FrogCommand() {
            @Override
            public boolean doCommand() {
                return frog.comeAshore();
            }

            @Override
            public boolean undoCommand() {
                frog.setPosition(currentPosition);
                return true;
            }
        };
        return frogCommand;
    }


}
