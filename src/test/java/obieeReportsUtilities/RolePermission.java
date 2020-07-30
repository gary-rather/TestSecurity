package obieeReportsUtilities;

public class RolePermission {
    String RoleName = null;
    boolean TripDocumentStatus = false;
    boolean DocumentDetails = false;
    boolean TravelerUserInformation = false;
    boolean AuditTrail = false;
    boolean Tickets = false;
    boolean MilitaryInformation = false;
    boolean Expenses = false;
    boolean Lodging = false;
    boolean DebtManagement = false;
    boolean TransactionMonitoring = false;

    public String getRoleName() {
        return RoleName;
    }

    public void setRoleName(String roleName) {
        RoleName = roleName;
    }

    public boolean isTripDocumentStatus() {
        return TripDocumentStatus;
    }

    public void setTripDocumentStatus(boolean tripDocumentStatus) {
        TripDocumentStatus = tripDocumentStatus;
    }

    public boolean isDocumentDetails() {
        return DocumentDetails;
    }

    public void setDocumentDetails(boolean documentDetails) {
        DocumentDetails = documentDetails;
    }

    public boolean isTravelerUserInformation() {
        return TravelerUserInformation;
    }

    public void setTravelerUserInformation(boolean travelerUserInformation) {
        TravelerUserInformation = travelerUserInformation;
    }

    public boolean isAuditTrail() {
        return AuditTrail;
    }

    public void setAuditTrail(boolean auditTrail) {
        AuditTrail = auditTrail;
    }

    public boolean isTickets() {
        return Tickets;
    }

    public void setTickets(boolean tickets) {
        Tickets = tickets;
    }

    public boolean isMilitaryInformation() {
        return MilitaryInformation;
    }

    public void setMilitaryInformation(boolean militaryInformation) {
        MilitaryInformation = militaryInformation;
    }

    public boolean isExpenses() {
        return Expenses;
    }

    public void setExpenses(boolean expenses) {
        Expenses = expenses;
    }

    public boolean isLodging() {
        return Lodging;
    }

    public void setLodging(boolean lodging) {
        Lodging = lodging;
    }

    public boolean isDebtManagement() {
        return DebtManagement;
    }

    public void setDebtManagement(boolean debtManagement) {
        DebtManagement = debtManagement;
    }

    public boolean isTransactionMonitoring() {
        return TransactionMonitoring;
    }

    public void setTransactionMonitoring(boolean transactionMonitoring) {
        TransactionMonitoring = transactionMonitoring;
    }
}
