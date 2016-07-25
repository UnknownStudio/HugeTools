package unstudio.HugeTools.remote;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;

/**
 * Created by trychen on 16/7/19.
 */
public class VersionChecker extends Thread{
    private String nowVersion = null;
    private int projectID = -1;
    private Logger log = null;
    private String latestVersion = null;
    private String downloadUrl = null;
    private String instruction = null;
    private String changelog = null;
    private int date = 0;
    private boolean checked = false;
    protected boolean latest = false;

    public VersionChecker(String nowVersion, int projectID, Logger log) {
        this.nowVersion = nowVersion;
        this.projectID = projectID;
        this.log = log;
    }

    @Override
    public void run() {
        super.run();
        if (!getRemoteVersionModel()) return;
        latest = judgeIfLatest();
        checked = true;
        if (isLatestVersion()) isNewestVersion();
        else findNewVersion();
    }

    public void findNewVersion(){

    }

    public void isNewestVersion(){

    }

    protected boolean getRemoteVersionModel() {
        try {
            String serverReturnStringJsonData = Network.getJsonString("http://mccraft.cn/api/project/" + projectID);
            JsonObject json = new JsonParser().parse(serverReturnStringJsonData).getAsJsonObject().get("latest_version").getAsJsonObject();
            latestVersion = json.get("version").getAsString();
            System.out.println(latestVersion);
            downloadUrl = json.get("download_url").getAsString();
            instruction = json.get("instruction").getAsString();
            changelog = json.get("changelog").getAsString();
            date = json.get("date").getAsInt();
            return true;
        }catch (NullPointerException e){
            latest = true;
            return true;
        } catch (Exception e) {
            log.log(Level.WARN, "Get Update Info Failed!", e);
            return false;
        }
    }

    protected boolean judgeIfLatest() {
        String[] last = latestVersion.split(".");
        String[] old = nowVersion.split(".");
        for (int i = 0; i < last.length; i++) {
            try {
                if (Integer.valueOf(last[i]) > Integer.valueOf(old[i])) {
                    return false;
                }
            } catch (Throwable e){
                return true;
            }
        }
        return true;
    }

    public synchronized boolean isLatestVersion() {
        return latest;
    }

    public boolean isChecked() {
        return checked;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public String getLatestVersion() {
        return latestVersion;
    }

    public Logger getLog() {
        return log;
    }

    public String getInstruction() {
        return instruction;
    }

    public String getChangelog() {
        return changelog;
    }

}
