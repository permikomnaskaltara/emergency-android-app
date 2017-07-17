package com.pk.eager.ReportObject;

import java.util.ArrayList;

/**
 * Created by kimpham on 7/9/17.
 */

public class Utils {

    public static Report buildTrapReport(){
        Report trap = new Report("Trapped", new ArrayList<Question>());
        Question q = new Question();
        q.question = "Trapped";
        trap.addReportItem(q);
        return trap;
    }

    public static Report buildMedicalReport(){
        Report medical = new Report("Medical", new ArrayList<Question>());

        Question q1 = new Question();
        q1.question  = "Number of Injured patients";
        Question q2 = new Question();
        q2.question = "Most severe injury";

        medical.addReportItem(q1);
        medical.addReportItem(q2);
        return medical;
    }

    public static Report buildFireReport(){
        Report fire = new Report("Fire", new ArrayList<Question>());

        Question q1 = new Question();
        q1.question = "Number of building on fire";
        Question q2 = new Question();
        q2.question = "Additional Information";

        fire.addReportItem(q1);
        fire.addReportItem(q2);

        return fire;
    }

    public static Report buildPoliceReport() {
        Report police = new Report("Police", new ArrayList<Question>());

        Question q1 = new Question();
        q1.question = "Select appropriate option";
        Question q2 = new Question();
        q2.question = "Additional Information";

        police.addReportItem(q1);
        police.addReportItem(q2);

        return police;
    }

    public static Report buildTrafficReport() {
        Report traffic = new Report("Traffic", new ArrayList<Question>());
        Question q = new Question();
        q.question = "Vehicle Accidents";

        traffic.addReportItem(q);

        return traffic;
    }

    public static Report buildUtilityReport(){
        Report utility = new Report("Utility", new ArrayList<Question>());
        Question q1 = new Question();
        q1.question = "Power";
        Question q2 = new Question();
        q2.question = "Water";
        Question q3 = new Question();
        q3.question = "Gas";
        Question q4 = new Question();
        q4.question = "Telephone";

        utility.addReportItem(q1);
        utility.addReportItem(q2);
        utility.addReportItem(q3);
        utility.addReportItem(q4);

        return utility;
    }

    public static boolean hasReport(IncidentReport incidentReport, int type){
        Report report = incidentReport.getReport(type);
        return !report.isEmpty();
    }

    public static IncidentReport compacitize(IncidentReport incidentReport){
        ArrayList<Report> r = incidentReport.reports;
        IncidentReport report = new IncidentReport();
        report.reports = new ArrayList<Report>();
        for(int i = 0; i < r.size(); i++){
            if(!r.get(i).isEmpty()){
                //remove question without answer
                stripQuestion(r.get(i));
                report.reports.add(r.get(i));
            }
        }
        return report;
    }

    public static void stripQuestion(Report report){
        for(Question q : report.questions){
            if(q.choice.size() == 0)
                report.questions.remove(q);
        }
    }










}
