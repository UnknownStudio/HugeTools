package unstudio.HugeTools;


import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class VersionChecker implements Runnable {
    private static boolean isLatestVersion = false;
    private static String newVersionInfo = "";
    private static String downloadUrl = "";
    private static int latestVersion = 1;
    @Override
    public void run() {

        InputStream version, info , downloadUrl;
        try {
            version = new URL("http://www.mccraft.cn/mod.php?id=0&mod=hugesword").openStream();
            info = new URL("http://www.mccraft.cn/mod.php?id=2&mod=hugesword").openStream();
            downloadUrl = new URL("http://www.mccraft.cn/mod.php?id=3&mod=hugesword").openStream();
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return;
        }
        try {
            latestVersion = Integer.valueOf(IOUtils.readLines(version).get(0));
            this.newVersionInfo = IOUtils.readLines(info).get(0);
            this.downloadUrl = IOUtils.readLines(downloadUrl).get(0);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return;
        } finally{
            IOUtils.closeQuietly(version);
        }

        System.out.println("[HugeTools]Latest mod version = " + latestVersion);
        isLatestVersion = latestVersion == HugeTools.OutPutVERSION;
        if (isLatestVersion) {
            System.out.println("[HugeTools]You are running latest version = " + isLatestVersion);
        }else {
            System.out.println("[HugeTools]Found New version");
        }
    }

    public boolean getisLatestVersion() {
        return isLatestVersion;
    }

    public int getLatestVersion() {
        return latestVersion;
    }

    public static String getNewVersionInfo() {
        return newVersionInfo;
    }

    public static String getDownloadUrl() {
        return downloadUrl;
    }

}