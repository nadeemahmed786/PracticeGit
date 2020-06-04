package org.graphwalker.PageObjectModels;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//Page Object Model Class for Launchpad Page
public class Dashboard {
    private String dashboardHeader, illuminateLogo, assessmentsIcon, viewAssessmentsLink, viewAssessmentsHeader;
    String dir = null;
    Properties properties = new Properties();
    InputStream input = null;
    private static String os = null;

    public Dashboard() {
        try {
            dir = System.getProperty("user.dir");
            dir = dir.replace("ParameterizeTest", "");
            System.out.println("dir: " + dir);
            os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                input = new FileInputStream(dir + "\\Properties\\Dashboard.properties");
            } else {
                input = new FileInputStream(dir + "/Properties/Dashboard.properties");
            }
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public String getDashboardHeader() {
        dashboardHeader = properties.getProperty("DASHBOARD_HEADER");
        return dashboardHeader;
    }

    public String getIlluminateLogo() {
        illuminateLogo = properties.getProperty("ILLUMINATE_LOGO");
        return illuminateLogo;
    }

    public String getAssessmentsIcon() {
        assessmentsIcon = properties.getProperty("ASSESSMENTS_ICON");
        return assessmentsIcon;
    }

    public String getViewAssessmentsLink() {
        viewAssessmentsLink = properties.getProperty("VIEW_ASSESSMENTS_LINK");
        return viewAssessmentsLink;
    }

    public String getViewAssessmentsHeader() {
        viewAssessmentsHeader = properties.getProperty("VIEW_ASSESSMENTS_HEADER");
        return viewAssessmentsHeader;
    }
}