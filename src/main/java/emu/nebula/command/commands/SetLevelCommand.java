package emu.nebula.command.commands;

import emu.nebula.Nebula;
import emu.nebula.command.Command;
import emu.nebula.command.CommandArgs;
import emu.nebula.command.CommandHandler;
import emu.nebula.net.NetMsgId;
import emu.nebula.proto.Public.ChangeInfo;
import emu.nebula.proto.Public.WorldClassUpdate;

@Command(label = "setlevel", permission = "player.setlevel", requireTarget = true, desc = "/setlevel. Set player level")
public class SetLevelCommand implements CommandHandler {

    @Override
    public String execute(CommandArgs args) {
        int level = Integer.parseInt(args.get(0));
        args.getTarget().addNextPackage(
                NetMsgId.world_class_change_notify,
                WorldClassUpdate.newInstance()
                        .setCur(level)
                        .setChange(ChangeInfo.newInstance()));
        args.getTarget().setLevel(level);
        return "Level set to " + level;
    }
}
