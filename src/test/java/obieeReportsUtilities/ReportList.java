package obieeReportsUtilities;

import java.util.ArrayList;
import java.util.List;

public class ReportList {
    private List<Report> theReports = new ArrayList<Report>();

    public ReportList(){
        theReports.add( new Report("report01","Trip & Document Status","Routing Status","Display the Routing Status Report"));
        theReports.add( new Report("report02","Trip & Document Status","Status Summary","Display the Status Summary Report"));
        theReports.add( new Report("report03","Trip & Document Status","Document Status Details","Display the Document Status Details Report"));
        theReports.add( new Report("report04","Trip & Document Status","Traveler Status","Display the Traveler Status Report"));
        theReports.add( new Report("report05","Trip & Document Status","Unsubmitted Vouchers","Display the Unsubmitted Vouchers Report"));

        theReports.add( new Report("report06","Document Details","Constructed Travel","Display the Constructed Travel report"));
        theReports.add( new Report("report07","Document Details","Adjustments","Display the Adjustments report"));

        theReports.add( new Report("report08","Traveler & User Information","Complete Traveler","Display the Complete Traveler report"));
        theReports.add( new Report("report09","Traveler & User Information","Separation of Duties","Display the Separation of Duty report"));
        theReports.add( new Report("report10","Audit Trail","Audit Trail GOVCC & EFT Data","Display the Audit Trail - GOVCC & EFT Accounts report"));
        theReports.add( new Report("report11","Audit Trail","Audit Trail User Data","Display the Audit Trail - User Data report"));
        theReports.add( new Report("report12","Audit Trail","Audit Trail Traveler Data","Audit Trail - Person Data"));
        theReports.add( new Report("report13","Traveler & User Information","Read Only Access","Display the DTS Read Only Access report"));

        theReports.add( new Report("report14","Tickets","Unused Ticket","Display the Unused Ticket report"));
        theReports.add( new Report("report15","Tickets","Partner System Unused Ticket","Display the Partner System Unused Ticket report"));
        theReports.add( new Report("report16","Tickets","CTO Fee","Display the CTO Fee report"));
        theReports.add( new Report("report17","Tickets","Partner System CTO Fee","Display the Partner System CTO Fee report"));
        theReports.add( new Report("report18","Tickets","CBA TO","Display the CBA TO report"));
        theReports.add( new Report("report19","Tickets","Pending Airline Cancellation","Pending Airline Cancellation"));

        theReports.add( new Report("report20","Military Information","Enlisted BAS","Display the Enlisted BAS report"));
        theReports.add( new Report("report21","Military Information","FSA","Display the FSA  report"));
        theReports.add( new Report("report22","Military Information","Military Leave","Display the Military Leave report"));
        theReports.add( new Report("report23","Military Information","OCONUS","Display the OCONUS report"));
        theReports.add( new Report("report24","Military Information","PERSTEMPO","Display the PERSTEMPO report"));
        theReports.add( new Report("report25","Military Information","Special Duty","Display the Special Duty report"));

        theReports.add( new Report("report26","Expenses","Expense Report by Category","Display the Expense Report by Category report"));
        theReports.add( new Report("report27","Expenses","Expense Report by Document Name","Display the Expense Report by Document Name report"));
        theReports.add( new Report("report28","Expenses","Expense Without Required Receipt","Display the Expense Without Required Receipt report"));
        theReports.add( new Report("report29","Expenses","Hotel Tax Exempt Locations","Display the Hotel Tax Exempt Locations report"));

        theReports.add( new Report("report30","Lodging","FPLP/FEMA","Display the FPLP/FEMA report"));
        theReports.add( new Report("report31","Lodging","Lodging Non-Use Reason Justification","Display the Lodging Non-Use Reason Justification report"));
        theReports.add( new Report("report32","Lodging","Government Lodging Programs Unavailability","Display the Government Lodging Programs Unavailability report"));

        theReports.add( new Report("report33","Debt Management","Debt Management Summary","Display the Debt Management Summary Report"));
        theReports.add( new Report("report34","Debt Management","Debt Management Detail","Display the Debt Management Detail report"));
        theReports.add( new Report("report35","Debt Management","Debts with Offsets and Collections","Display the Debts with Offsets and Collections Report"));
        theReports.add( new Report("report36","Debt Management","Monthly Debt Summary","Display the Debt Summary by Month Report"));

        theReports.add( new Report("report37","Transaction Monitoring","What's Out - Totals by System","Display the What's Out - Totals by System report"));
        theReports.add( new Report("report38","Transaction Monitoring","What's Out - Details","Display the What's Out - Transaction Details"));
        theReports.add( new Report("report39","Transaction Monitoring","Posack Delinquency","Display the Pos Ack Delinquency report"));
        theReports.add( new Report("report40","Transaction Monitoring","Partner System Posack Delinquency","Display the Partner System Pos Ack Delinquency"));

    }

    public List<Report> getTheReports() {
        return theReports;
    }

    public void setTheReports(List<Report> theReports) {
        this.theReports = theReports;
    }

    public List<Report> getReportBySection(String reportGroup){
        List<Report> filteredList = new ArrayList<Report>();
        for(Report aReport : theReports){
            if (aReport.getReportGroup().equals(reportGroup)) {
                filteredList.add(aReport);
            }
        }
        return filteredList;
    }
}
