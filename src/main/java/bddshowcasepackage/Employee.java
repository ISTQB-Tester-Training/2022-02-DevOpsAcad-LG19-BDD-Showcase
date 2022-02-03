package bddshowcasepackage;

import tddshowcasepackage.*;

enum EmployeeType {
    MA("tariflicher Mitarbeiter"),
    MALTD ("leitender Angestellter"),
    HR ("Human Ressourcen-Mitarbeiter"),
    PM ("Projektleiter"),
    FK ("Führungskraft");

    public final String label;

    private EmployeeType(String label) {
        this.label = label;
    }
}

public class Employee {

    private String projectName;
    private final EmployeeType employeeType;

    public Employee (String argProjectName, EmployeeType argEmployeeType) {
        projectName = argProjectName;
        employeeType = argEmployeeType;
    }

    public int getPauseTime(String startTime, String endTime) {

        double timeDifference = new TimePair().getTimeDifference(startTime, endTime);
        int pauseTime = 0;

        switch (employeeType) {
            case MALTD:
                pauseTime = 0;

            case MA:
                if (timeDifference <= 6.0) {
                    pauseTime = 0;
                } else if (timeDifference > 6.0 && timeDifference <= 6.5) {
                    pauseTime = (int) ((timeDifference - 6.0)*60);
                } else if (timeDifference > 6.5 && timeDifference <= 9.5) {
                    pauseTime = 30;
                } else if (timeDifference > 9.5 && timeDifference <= 9.75) {
                    pauseTime = (int) ((timeDifference - 9.0)*60);
                } else if (timeDifference > 9.75) {
                    pauseTime = 45;
                }
        }
        return pauseTime;
    }
}