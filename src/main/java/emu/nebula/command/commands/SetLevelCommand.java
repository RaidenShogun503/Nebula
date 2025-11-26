package emu.nebula.command.commands;

import emu.nebula.Nebula;
import emu.nebula.command.Command;
import emu.nebula.command.CommandArgs;
import emu.nebula.command.CommandHandler;

@Command(label = "setlevel", permission = "player.setlevel", requireTarget = true, desc = "/setlevel. Set player level")
public class SetLevelCommand implements CommandHandler {

    @Override
    public String execute(CommandArgs args) {
        int level = Integer.parseInt(args.get(0));
        args.getTarget().setLevel(level);
        return "Level set to " + level;
    }
}
