package dev.pages.ahsan40.hmodifier;

import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class Host {
    private String os;
    private String hostsFile;
    private ArrayList<String> hosts;
    private ArrayList<String> comments;

    public Host() throws UnsupportedOperationException {
        init();
        hosts = new ArrayList<>();
        comments = new ArrayList<>();
        readData();
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

    public void readData() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(this.hostsFile));
            String line;
            // read system hosts
            while ((line = br.readLine()) != null) {
                if (!line.startsWith("#") && !line.trim().isEmpty())
                    hosts.add(line);
                else
                    comments.add(line);
            }
            br.close();
        } catch (IOException e) {
            System.err.println(" - Host file read failed!");
            e.printStackTrace();
        }
    }


    public void blockSite(String url) {
        // Blocking single site
        try {
            Files.write(Paths.get(this.hostsFile), (Configs.redirectIP + url + "\n").getBytes(), StandardOpenOption.APPEND);
            hosts.add(Configs.redirectIP + url);
        } catch (IOException e) {
            System.err.println(" - Host file write failed!");
            e.printStackTrace();
        }
    }

    void blockSiteFromFile(ArrayList<String> list, DefaultTableModel model) {
        // Blacking all sites inside 'hosts.txt' file
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(this.hostsFile, true));

            // append all to system hosts file
            for (String url : list) {
                bw.write(url);
                bw.newLine();
                this.hosts.add(url);

                // adding data to table
                String[] d = url.trim().split(" ");
                model.addRow(d);
            }
            bw.close();
        } catch (IOException e) {
            System.err.println(" - Host file write failed!");
            e.printStackTrace();
        }
    }


    public void removeHost(int[] index) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(this.hostsFile));
            ArrayList<String> h = this.hosts;
            ArrayList<String> c = this.comments;

            // removing hosts according to index
            for (int i : index) {
                h.remove(i);
            }

            // adding comments
            for (String l : c) {
                bw.write(l);
                bw.newLine();
            }

            // adding rest of the hosts
            for (String url : h) {
                bw.write(url);
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            System.err.println(" - Host file write failed!");
            e.printStackTrace();
        }
    }


    // Getter-setter
    //<editor-fold defaultstate="collapsed" desc=" Getter-Setter ">
    public ArrayList<String> getHosts() {
        return this.hosts;
    }
    //</editor-fold>
}
