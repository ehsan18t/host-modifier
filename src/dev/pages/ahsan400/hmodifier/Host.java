package dev.pages.ahsan400.hmodifier;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class Host {
    String os;
    String hostsFile;

    public Host() throws UnsupportedOperationException {
        init();
    }

    public void init() throws UnsupportedOperationException {
        // Get OS name
        this.os = System.getProperty("os.name").toLowerCase();

        // Determine hosts path
        if ((os.contains("win"))) {
            // Doesn't work before Windows 2000
            this.hostsFile = "C:\\Windows\\System32\\drivers\\etc\\hosts";
        } else if ((os.contains("mac"))) {
            // Doesn't work before OS X 10.2
            this.hostsFile = "etc/hosts";
        } else if ((os.contains("nux"))) {
            this.hostsFile = "/etc/hosts";
        } else {
            // Handle error when platform is not Windows, Mac, or Linux
            System.err.println("Sorry, but your OS doesn't support blocking.");
            throw new UnsupportedOperationException("Sorry, but your OS doesn't support blocking.");
        }
    }


    public void blockSite(String url) {
        // Blocking single site
        try {
            Files.write(Paths.get(this.hostsFile), ("127.0.0.1 " + url).getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.err.println(" - Host file write failed!");
            e.printStackTrace();
        }
    }

    void blockSiteFromFile(String path) {
        // Blacking all sites inside 'hosts.txt' file
        ArrayList<String> list = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("hosts.txt"));
            BufferedWriter bw = new BufferedWriter(new FileWriter(this.hostsFile, true));

            String line;

            // read external hosts.txt
            while ((line = br.readLine()) != null) {
                list.add("127.0.0.1 " + line);
            }
            br.close();

            // append all to system hosts file
            for (String url: list) {
                bw.write(url);
                bw.newLine();
            }
            bw.close();
            list.clear();
        } catch (IOException e) {
            System.err.println(" - Host file write failed!");
            e.printStackTrace();
        }
    }
}
