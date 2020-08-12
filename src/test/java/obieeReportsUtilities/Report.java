package obieeReportsUtilities;

public class Report {

    String reportName = null;
    String reportGroup = null;
    String reportText = null;
    String reportDisplayText = null;
    public Report(String reportName,String reportGroup, String reportText, String reportDisplayText){
        this.reportName = reportName;
        this.reportGroup = reportGroup;
        this.reportText = reportText;
        this.reportDisplayText = reportDisplayText;
    }
    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    public String getReportGroup() {
        return reportGroup;
    }

    public void setReportGroup(String reportGroup) {
        this.reportGroup = reportGroup;
    }

    public String getReportText() {
        return reportText;
    }

    public void setReportText(String reportText) {
        this.reportText = reportText;
    }

    public String getReportDisplayText() {
        return reportDisplayText;
    }

    public void setReportDisplayText(String reportDisplayText) {
        this.reportDisplayText = reportDisplayText;
    }


}
