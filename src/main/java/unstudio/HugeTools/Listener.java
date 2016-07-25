package unstudio.HugeTools;


import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.event.ClickEvent;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.StatCollector;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;

public class Listener {
        @SubscribeEvent
        public void worldLoad(EntityJoinWorldEvent e){
            if (e.entity instanceof EntityPlayer) {
                EntityPlayer p = (EntityPlayer) e.entity;
                if (!HugeTools.haveWarnedVersionOutOfDate && p.worldObj.isRemote
                        && !HugeTools.versionChecker.isLatestVersion()) {
                    ClickEvent versionCheckChatClickEvent = new ClickEvent(ClickEvent.Action.OPEN_URL,
                            HugeTools.versionChecker.getDownloadUrl());
                    ChatStyle clickableChatStyle = new ChatStyle().setChatClickEvent(versionCheckChatClickEvent);
                    ChatComponentText versionWarningChatComponent =
                            new ChatComponentText(StatCollector.translateToLocal("VersionChecker.perfix"));
                    versionWarningChatComponent.setChatStyle(clickableChatStyle);
                    p.addChatMessage(versionWarningChatComponent);

                    ChatComponentText info = new ChatComponentText(StatCollector.translateToLocal("VersionChecker.version").replaceAll("!new", String.valueOf(HugeTools.versionChecker.getLatestVersion())).replaceAll("!old", String.valueOf(HugeTools.OutPutVERSION)));
                    info.setChatStyle(clickableChatStyle);
                    p.addChatMessage(info);
                    System.out.println(StatCollector.translateToLocal("VersionChecker.perfix"));
                    System.out.println(StatCollector.translateToLocal("VersionChecker.version").replaceAll("!new", String.valueOf(HugeTools.versionChecker.getLatestVersion())).replaceAll("!old", String.valueOf(HugeTools.OutPutVERSION)));
                    System.out.println("[VersionChecker]Download Url:" + HugeTools.versionChecker.getDownloadUrl());
                    HugeTools.haveWarnedVersionOutOfDate = true;
                }
            }
        }
}
