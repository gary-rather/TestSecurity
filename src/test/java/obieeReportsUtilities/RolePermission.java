package obieeReportsUtilities;

public class RolePermission {
    String RoleName = null;
    String userName = null;

   boolean TripDocumentStatus = false;
   boolean DocumentDetails = false;
   boolean TravelerUserInformation = false;
   boolean AuditTrail = false;
   boolean Tickets = false;
   boolean MilitaryInformation = false;
   boolean Expenses = false;
   boolean Lodging = false;
   boolean DebtManagement = false;
   boolean TransactionMonitoring= false;

   boolean Routing_Status  = false;
   boolean Status_Summary = false;
   boolean Document_Status_Details = false;
   boolean Traveler_Status = false;
   boolean Unsubmitted_Vouchers = false;

   boolean Constructed_Travel = false;
   boolean Adjustments = false;

   boolean Complete_Traveler = false;
   boolean Separation_of_Duties = false;
   boolean Audit_Trail_GOVCC_EFT_Data = false;
   boolean Audit_Trail_User_Data = false;
   boolean Audit_Trail_Traveler_Data = false;
   boolean Read_Only_Access = false;

   boolean Unused_Ticket = false;
   boolean Partner_System_Unused_Ticket = false;
   boolean CTO_Fee = false;
   boolean Partner_System_CTO_Fee = false;
   boolean CBA_TO = false;
   boolean Pending_Airline_Cancellation = false;

   boolean Enlisted_BAS = false;
   boolean FSA = false;
   boolean Military_Leave = false;
   boolean OCONUS = false;
   boolean PERSTEMPO = false;
   boolean Special_Duty = false;

   boolean Expense_Report_by_Category = false;
   boolean Expense_Report_by_Document_Name = false;
   boolean Expense_Without_Required_Receipt = false;
   boolean Hotel_Tax_Exempt_Locations = false;

   boolean FPLP_FEMA = false;
   boolean Lodging_Non_Use_Reason_Justification = false;
   boolean Government_Lodging_Programs_Unavailability = false;

   boolean Debt_Management_Summary = false;
   boolean Debt_Management_Detail = false;
   boolean Debts_with_Offsets_and_Collections = false;
   boolean Monthly_Debt_Summary = false;

   boolean Whats_Out_Totals_by_System = false;
   boolean Whats_Out_Details = false;
   boolean Posack_Delinquency = false;
   boolean Partner_System_Posack_Delinquency = false;

    public boolean findPermissionByString(String text){
        boolean value = false;
        switch (text) {
            case "Routing Status": value = Routing_Status;break;
            case "Status Summary": value = Status_Summary;break;

            case "Document Status Details": value = Document_Status_Details;break;
            case "Traveler Status": value = Traveler_Status;break;
            case "Unsubmitted Vouchers": value = Unsubmitted_Vouchers;break;

            case "Constructed Travel": value = Constructed_Travel;break;
            case "Adjustments": value = Adjustments;break;

            case "Complete Traveler": value = Complete_Traveler;break;
            case "Separation of Duties": value = Separation_of_Duties;break;
            case "Audit Trail GOVCC & EFT Data": value = Audit_Trail_GOVCC_EFT_Data;break;
            case "Audit Trail User Data": value = Audit_Trail_User_Data;break;
            case "Audit Trail Traveler Data": value = Audit_Trail_Traveler_Data;break;
            case "Read Only Access": value = Read_Only_Access;break;

            case "Unused Ticket": value = Unused_Ticket;break;
            case "Partner System Unused Ticket": value = Partner_System_Unused_Ticket;break;
            case "CTO Fee": value = CTO_Fee;break;
            case "Partner System CTO Fee": value = Partner_System_CTO_Fee;break;
            case "CBA TO": value = CBA_TO;break;
            case "Pending Airline Cancellation": value = Pending_Airline_Cancellation;break;

            case "Enlisted BAS": value = Enlisted_BAS;break;
            case "FSA": value = FSA;break;
            case "Military Leave": value = Military_Leave;break;
            case "OCONUS": value = OCONUS;break;
            case "PERSTEMPO": value = PERSTEMPO;break;
            case "Special Duty": value = Special_Duty;break;

            case "Expense Report by Category": value = Expense_Report_by_Category;break;
            case "Expense Report by Document Name": value = Expense_Report_by_Document_Name;break;
            case "Expense Without Required Receipt": value = Expense_Without_Required_Receipt;break;
            case "Hotel Tax Exempt Locations": value = Hotel_Tax_Exempt_Locations;break;

            case "FPLP/FEMA": value = FPLP_FEMA;break;
            case "Lodging Non-Use Reason Justification": value = Lodging_Non_Use_Reason_Justification;break;
            case "Government Lodging Programs Unavailability": value = Government_Lodging_Programs_Unavailability;break;

            case "Debt Management Summary": value = Debt_Management_Summary;break;
            case "Debt Management Detail": value = Debt_Management_Detail;break;
            case "Debts with Offsets and Collections": value = Debts_with_Offsets_and_Collections;break;
            case "Monthly Debt Summary": value = Monthly_Debt_Summary;break;

            case "\"What's Out\": Totals by System": value = Whats_Out_Totals_by_System;break;
            case "\"What's Out\": Details": value = Whats_Out_Details;break;
            case "Posack Delinquency": value = Posack_Delinquency;break;
            case "Partner System Posack Delinquency": value = Partner_System_Posack_Delinquency;break;
            default : value = false;
        }
        return value;
    }
    public String getRoleName() {
        return RoleName;
    }

    public void setRoleName(String roleName) {
        RoleName = roleName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean  isTripDocumentStatus() {
        return TripDocumentStatus;
    }

    public void setTripDocumentStatus( boolean tripDocumentStatus) {
        TripDocumentStatus = tripDocumentStatus;
    }

    public boolean  isDocumentDetails() {
        return DocumentDetails;
    }

    public void setDocumentDetails( boolean documentDetails) {
        DocumentDetails = documentDetails;
    }

    public boolean  isTravelerUserInformation() {
        return TravelerUserInformation;
    }

    public void setTravelerUserInformation( boolean travelerUserInformation) {
        TravelerUserInformation = travelerUserInformation;
    }

    public boolean  isAuditTrail() {
        return AuditTrail;
    }

    public void setAuditTrail( boolean auditTrail) {
        AuditTrail = auditTrail;
    }

    public boolean  isTickets() {
        return Tickets;
    }

    public void setTickets( boolean tickets) {
        Tickets = tickets;
    }

    public boolean  isMilitaryInformation() {
        return MilitaryInformation;
    }

    public void setMilitaryInformation( boolean militaryInformation) {
        MilitaryInformation = militaryInformation;
    }

    public boolean  isExpenses() {
        return Expenses;
    }

    public void setExpenses( boolean expenses) {
        Expenses = expenses;
    }

    public boolean  isLodging() {
        return Lodging;
    }

    public void setLodging( boolean lodging) {
        Lodging = lodging;
    }

    public boolean  isDebtManagement() {
        return DebtManagement;
    }

    public void setDebtManagement( boolean debtManagement) {
        DebtManagement = debtManagement;
    }

    public boolean  isTransactionMonitoring() {
        return TransactionMonitoring;
    }

    public void setTransactionMonitoring( boolean transactionMonitoring) {
        TransactionMonitoring = transactionMonitoring;
    }

    public boolean  isRouting_Status() {
        return Routing_Status;
    }

    public void setRouting_Status( boolean routing_Status) {
        Routing_Status = routing_Status;
    }

    public boolean  isStatus_Summary() {
        return Status_Summary;
    }

    public void setStatus_Summary( boolean status_Summary) {
        Status_Summary = status_Summary;
    }

    public boolean  isDocument_Status_Details() {
        return Document_Status_Details;
    }

    public void setDocument_Status_Details( boolean document_Status_Details) {
        Document_Status_Details = document_Status_Details;
    }

    public boolean  isTraveler_Status() {
        return Traveler_Status;
    }

    public void setTraveler_Status( boolean traveler_Status) {
        Traveler_Status = traveler_Status;
    }

    public boolean  isUnsubmitted_Vouchers() {
        return Unsubmitted_Vouchers;
    }

    public void setUnsubmitted_Vouchers( boolean unsubmitted_Vouchers) {
        Unsubmitted_Vouchers = unsubmitted_Vouchers;
    }

    public boolean  isConstructed_Travel() {
        return Constructed_Travel;
    }

    public void setConstructed_Travel( boolean constructed_Travel) {
        Constructed_Travel = constructed_Travel;
    }

    public boolean  isAdjustments() {
        return Adjustments;
    }

    public void setAdjustments( boolean adjustments) {
        Adjustments = adjustments;
    }

    public boolean  isComplete_Traveler() {
        return Complete_Traveler;
    }

    public void setComplete_Traveler( boolean complete_Traveler) {
        Complete_Traveler = complete_Traveler;
    }

    public boolean  isSeparation_of_Duties() {
        return Separation_of_Duties;
    }

    public void setSeparation_of_Duties( boolean separation_of_Duties) {
        Separation_of_Duties = separation_of_Duties;
    }

    public boolean  isAudit_Trail_GOVCC_EFT_Data() {
        return Audit_Trail_GOVCC_EFT_Data;
    }

    public void setAudit_Trail_GOVCC_EFT_Data( boolean audit_Trail_GOVCC_EFT_Data) {
        Audit_Trail_GOVCC_EFT_Data = audit_Trail_GOVCC_EFT_Data;
    }

    public boolean  isAudit_Trail_User_Data() {
        return Audit_Trail_User_Data;
    }

    public void setAudit_Trail_User_Data( boolean audit_Trail_User_Data) {
        Audit_Trail_User_Data = audit_Trail_User_Data;
    }

    public boolean  isAudit_Trail_Traveler_Data() {
        return Audit_Trail_Traveler_Data;
    }

    public void setAudit_Trail_Traveler_Data( boolean audit_Trail_Traveler_Data) {
        Audit_Trail_Traveler_Data = audit_Trail_Traveler_Data;
    }

    public boolean  isRead_Only_Access() {
        return Read_Only_Access;
    }

    public void setRead_Only_Access( boolean read_Only_Access) {
        Read_Only_Access = read_Only_Access;
    }

    public boolean  isUnusued_Ticket() {
        return Unused_Ticket;
    }

    public void setUnusued_Ticket( boolean unusued_Ticket) {
        Unused_Ticket = unusued_Ticket;
    }

    public boolean  isPartner_System_Unusued_Ticket() {
        return Partner_System_Unused_Ticket;
    }

    public void setPartner_System_Unusued_Ticket( boolean partner_System_Unusued_Ticket) {
        Partner_System_Unused_Ticket = partner_System_Unusued_Ticket;
    }

    public boolean  isCTO_Fee() {
        return CTO_Fee;
    }

    public void setCTO_Fee( boolean CTO_Fee) {
        this.CTO_Fee = CTO_Fee;
    }

    public boolean  isPartner_System_CTO_Fee() {
        return Partner_System_CTO_Fee;
    }

    public void setPartner_System_CTO_Fee( boolean partner_System_CTO_Fee) {
        Partner_System_CTO_Fee = partner_System_CTO_Fee;
    }

    public boolean  isCBA_TO() {
        return CBA_TO;
    }

    public void setCBA_TO( boolean CBA_TO) {
        this.CBA_TO = CBA_TO;
    }

    public boolean  isPending_Airline_Cancellation() {
        return Pending_Airline_Cancellation;
    }

    public void setPending_Airline_Cancellation( boolean pending_Airline_Cancellation) {
        Pending_Airline_Cancellation = pending_Airline_Cancellation;
    }

    public boolean  isEnlisted_BAS() {
        return Enlisted_BAS;
    }

    public void setEnlisted_BAS( boolean enlisted_BAS) {
        Enlisted_BAS = enlisted_BAS;
    }

    public boolean  isFSA() {
        return FSA;
    }

    public void setFSA( boolean FSA) {
        this.FSA = FSA;
    }

    public boolean  isMilitary_Leave() {
        return Military_Leave;
    }

    public void setMilitary_Leave( boolean military_Leave) {
        Military_Leave = military_Leave;
    }

    public boolean  isOCONUS() {
        return OCONUS;
    }

    public void setOCONUS( boolean OCONUS) {
        this.OCONUS = OCONUS;
    }

    public boolean isPERSTEMPO() {
        return PERSTEMPO;
    }

    public void setPERSTEMPO( boolean PERSTEMPO) {
        this.PERSTEMPO = PERSTEMPO;
    }

    public boolean isSpecial_Duty() {
        return Special_Duty;
    }

    public void setSpecial_Duty( boolean special_Duty) {
        Special_Duty = special_Duty;
    }

    public boolean isExpense_Report_by_Category() {
        return Expense_Report_by_Category;
    }

    public void setExpense_Report_by_Category( boolean expense_Report_by_Category) {
        Expense_Report_by_Category = expense_Report_by_Category;
    }

    public boolean isExpense_Report_by_Document_Name() {
        return Expense_Report_by_Document_Name;
    }

    public void setExpense_Report_by_Document_Name( boolean expense_Report_by_Document_Name) {
        Expense_Report_by_Document_Name = expense_Report_by_Document_Name;
    }

    public boolean isExpense_Without_Required_Receipt() {
        return Expense_Without_Required_Receipt;
    }

    public void setExpense_Without_Required_Receipt( boolean expense_Without_Required_Receipt) {
        Expense_Without_Required_Receipt = expense_Without_Required_Receipt;
    }

    public boolean isHotel_Tax_Exempt_Locations() {
        return Hotel_Tax_Exempt_Locations;
    }

    public void setHotel_Tax_Exempt_Locations( boolean hotel_Tax_Exempt_Locations) {
        Hotel_Tax_Exempt_Locations = hotel_Tax_Exempt_Locations;
    }

    public boolean isFPLP_FEMA() {
        return FPLP_FEMA;
    }

    public void setFPLP_FEMA( boolean FPLP_FEMA) {
        this.FPLP_FEMA = FPLP_FEMA;
    }

    public boolean isLodging_Non_Use_Reason_Justification() {
        return Lodging_Non_Use_Reason_Justification;
    }

    public void setLodging_Non_Use_Reason_Justification( boolean lodging_Non_Use_Reason_Justification) {
        Lodging_Non_Use_Reason_Justification = lodging_Non_Use_Reason_Justification;
    }

    public boolean isGovernment_Lodging_Programs_Unavailability() {
        return Government_Lodging_Programs_Unavailability;
    }

    public void setGovernment_Lodging_Programs_Unavailability( boolean government_Lodging_Programs_Unavailability) {
        Government_Lodging_Programs_Unavailability = government_Lodging_Programs_Unavailability;
    }

    public boolean isDebt_Management_Summary() {
        return Debt_Management_Summary;
    }

    public void setDebt_Management_Summary( boolean debt_Management_Summary) {
        Debt_Management_Summary = debt_Management_Summary;
    }

    public boolean isDebt_Management_Detail() {
        return Debt_Management_Detail;
    }

    public void setDebt_Management_Detail( boolean debt_Management_Detail) {
        Debt_Management_Detail = debt_Management_Detail;
    }

    public boolean isDebts_with_Offsets_and_Collections() {
        return Debts_with_Offsets_and_Collections;
    }

    public void setDebts_with_Offsets_and_Collections( boolean debts_with_Offsets_and_Collections) {
        Debts_with_Offsets_and_Collections = debts_with_Offsets_and_Collections;
    }

    public boolean isMonthly_Debt_Summary() {
        return Monthly_Debt_Summary;
    }

    public void setMonthly_Debt_Summary( boolean monthly_Debt_Summary) {
        Monthly_Debt_Summary = monthly_Debt_Summary;
    }

    public boolean isWhats_Out_Totals_by_System() {
        return Whats_Out_Totals_by_System;
    }

    public void setWhats_Out_Totals_by_System( boolean whats_Out_Totals_by_System) {
        Whats_Out_Totals_by_System = whats_Out_Totals_by_System;
    }

    public boolean isWhats_Out_Details() {
        return Whats_Out_Details;
    }

    public void setWhats_Out_Details( boolean whats_Out_Details) {
        Whats_Out_Details = whats_Out_Details;
    }

    public boolean isPosack_Delinquency() {
        return Posack_Delinquency;
    }

    public void setPosack_Delinquency( boolean posack_Delinquency) {
        Posack_Delinquency = posack_Delinquency;
    }

    public boolean isPartner_System_Posack_Delinquency() {
        return Partner_System_Posack_Delinquency;
    }

    public void setPartner_System_Posack_Delinquency( boolean partner_System_Posack_Delinquency) {
        Partner_System_Posack_Delinquency = partner_System_Posack_Delinquency;
    }
}
