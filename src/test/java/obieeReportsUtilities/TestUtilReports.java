package obieeReportsUtilities;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;
import obieeReportsBase.TestBaseReports;

public class TestUtilReports extends TestBaseReports {
	
	@DataProvider(name = "dp")
	public Object[] getData(Method m) {

		log.debug("=== TestUtilReports getData ============================");
		//String sheetName = m.getName();

		String sheetName = "Presentation & SA Roles ";
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);

		List<String> roleList = new ArrayList<String>();
        ArrayList<RolePermission> rolePermissionList = new ArrayList<RolePermission>();

		int i = 1;
		// Loop through the Excel Saving the
		for (int rowNum = 2; rowNum <= rows; rowNum++) {
			//log.debug("=== TestUtilReports loop ============================");
			// Create the RolePermission Object we are going to pobluate
			RolePermission aRolePermission = new RolePermission();


            String  aRole = (String)excel.getCellData(sheetName,0,rowNum);
            if (aRole.startsWith("R_") || aRole.startsWith("W_")) {
				//log.debug(i++ + " " + rowNum + " == " + aRole.toString());
				roleList.add(aRole);
				aRolePermission.setRoleName(aRole);
			} else {
            	continue;
			}
			if (aRolePermission.getRoleName().equals("R_AllReports")){
				log.debug("check all");
			}
			for (int colNum = 0; colNum < cols; colNum++) {

				String aDash = (String) excel.getCellData(sheetName, colNum, 1);
				String aDashCheck = (String) excel.getCellData(sheetName, colNum, rowNum);
				if (aDash.startsWith("Dashboard") && aDash.endsWith("Trip & Document Status")) {
					//log.debug("XXX " + aDash + " -- " + aDashCheck.toString());
					if ("x".equalsIgnoreCase(aDashCheck)) {
						aRolePermission.setTripDocumentStatus(true);
						aRolePermission.setRouting_Status(true);
						aRolePermission.setStatus_Summary(true);
						aRolePermission.setDocument_Status_Details(true);
						aRolePermission.setTraveler_Status(true);
						aRolePermission.setUnsubmitted_Vouchers(true);
					}
				} else if (aDash.startsWith("Dashboard") && aDash.endsWith("Document Details")) {
					//log.debug("XXX " + aDash + " -- " + aDashCheck.toString());
					if ("x".equalsIgnoreCase(aDashCheck)) {
						aRolePermission.setDocumentDetails(true);
						aRolePermission.setConstructed_Travel(true);
						aRolePermission.setAdjustments(true);
					}
				} else if (aDash.startsWith("Dashboard") && (aDash.endsWith("Traveler & User Information"))) {
					//log.debug("XXX " + aDash + " -- " + aDashCheck.toString());
					if ("x".equalsIgnoreCase(aDashCheck)) {
						aRolePermission.setTravelerUserInformation(true);
					}
				} else if (aDash.equals("Complete Traveler")) {
					//log.debug("XXX " + aDash + " -- " + aDashCheck.toString());
					if ("x".equalsIgnoreCase(aDashCheck)) {
						aRolePermission.setComplete_Traveler(true);
					}
				} else if (aDash.equals("Separation of Duties")) {
					//log.debug("XXX " + aDash + " -- " + aDashCheck.toString());
					if ("x".equalsIgnoreCase(aDashCheck)) {
						aRolePermission.setSeparation_of_Duties(true);
					}
				} else if (aDash.equals("Read Only Access")) {
					//log.debug("XXX " + aDash + " -- " + aDashCheck.toString());
					if ("x".equalsIgnoreCase(aDashCheck)) {
						aRolePermission.setRead_Only_Access(true);
					}
				} else if (aDash.equals("Audit Trail GOVCC & EFT Data")) {
					//log.debug("XXX " + aDash + " -- " + aDashCheck.toString());
					if ("x".equalsIgnoreCase(aDashCheck)) {
						aRolePermission.setAudit_Trail_GOVCC_EFT_Data(true);
					}
				} else if (aDash.equals("Audit Trail User Data")) {
					//log.debug("XXX " + aDash + " -- " + aDashCheck.toString());
					if ("x".equalsIgnoreCase(aDashCheck)) {
						aRolePermission.setAudit_Trail_User_Data(true);
					}
				} else if (aDash.startsWith("Dashboard") && aDash.endsWith("Audit Trail")) {
					//log.debug("XXX " + aDash + " -- " + aDashCheck.toString());
					if ("x".equalsIgnoreCase(aDashCheck)) {
						aRolePermission.setAuditTrail(true);
						aRolePermission.setAudit_Trail_GOVCC_EFT_Data(true);
						aRolePermission.setAudit_Trail_Traveler_Data(true);
						aRolePermission.setAudit_Trail_User_Data(true);
					} else {
						aRolePermission.setAuditTrail(false);
						//aRolePermission.setTravelerUserInformation(false);
					}
				} else if (aDash.startsWith("Dashboard") && aDash.endsWith("Tickets")) {
					//log.debug("XXX " + aDash + " -- " + aDashCheck.toString());
					if ("x".equalsIgnoreCase(aDashCheck)) {
						aRolePermission.setTickets(true);
					} else {
						aRolePermission.setTickets(false);

					}
				} else if (aDash.equals("Unused Ticket")) {
					//log.debug("XXX " + aDash + " -- " + aDashCheck.toString());
					if ("x".equalsIgnoreCase(aDashCheck)) {
						aRolePermission.setUnusued_Ticket(true);
					}
				} else if (aDash.equals("Partner System Unused Ticket")) {
					//log.debug("XXX " + aDash + " -- " + aDashCheck.toString());
					if ("x".equalsIgnoreCase(aDashCheck)) {
						aRolePermission.setPartner_System_Unusued_Ticket(true);
					}
				} else if (aDash.equals("CTO Fee")) {
					//log.debug("XXX " + aDash + " -- " + aDashCheck.toString());
					if ("x".equalsIgnoreCase(aDashCheck)) {
						aRolePermission.setCTO_Fee(true);
					}
				} else if (aDash.equals("Partner System CTO Fee")) {
					//log.debug("XXX " + aDash + " -- " + aDashCheck.toString());
					if ("x".equalsIgnoreCase(aDashCheck)) {
						aRolePermission.setPartner_System_CTO_Fee(true);
					}
				} else if (aDash.equals("CBA TO")) {
					//log.debug("XXX " + aDash + " -- " + aDashCheck.toString());
					if ("x".equalsIgnoreCase(aDashCheck)) {
						aRolePermission.setCBA_TO(true);
					}
				} else if (aDash.equals("Pending Airline Cancellation")) {
					//log.debug("XXX " + aDash + " -- " + aDashCheck.toString());
					if ("x".equalsIgnoreCase(aDashCheck)) {
						aRolePermission.setPending_Airline_Cancellation(true);
					}
				} else if (aDash.startsWith("Dashboard") && aDash.endsWith("Military Information")) {
					//log.debug("XXX " + aDash + " -- " + aDashCheck.toString());
					if ("x".equalsIgnoreCase(aDashCheck)) {
						aRolePermission.setMilitaryInformation(true);
						aRolePermission.setMilitaryInformation(true);
						aRolePermission.setEnlisted_BAS(true);
						aRolePermission.setFSA(true);
						aRolePermission.setMilitary_Leave(true);
						aRolePermission.setOCONUS(true);
						aRolePermission.setSpecial_Duty(true);
					}
				} else if (aDash.equals("PERSTEMPO")) {
					//log.debug("XXX " + aDash + " -- " + aDashCheck.toString());
					if ("x".equalsIgnoreCase(aDashCheck)) {
						aRolePermission.setPERSTEMPO(true);
					}
				} else if (aDash.startsWith("Dashboard") && aDash.endsWith("Expenses")) {
					//log.debug("XXX " + aDash + " -- " + aDashCheck.toString());
					if ("x".equalsIgnoreCase(aDashCheck)) {
						aRolePermission.setExpenses(true);
					} else {
						aRolePermission.setExpenses(false);

					}
				} else if (aDash.equals("Expense Report by Category")) {
					//log.debug("XXX " + aDash + " -- " + aDashCheck.toString());
					if ("x".equalsIgnoreCase(aDashCheck)) {
						aRolePermission.setExpense_Report_by_Category(true);
					}
				} else if (aDash.equals("Expense Report by Document Name")) {
					//log.debug("XXX " + aDash + " -- " + aDashCheck.toString());
					if ("x".equalsIgnoreCase(aDashCheck)) {
						aRolePermission.setExpense_Report_by_Document_Name(true);
					}
				} else if (aDash.equals("Expense Without Required Receipt")) {
					//log.debug("XXX " + aDash + " -- " + aDashCheck.toString());
					if ("x".equalsIgnoreCase(aDashCheck)) {
						aRolePermission.setExpense_Without_Required_Receipt(true);
					}
				} else if (aDash.equals("Hotel Tax Exempt Locations")) {
					//log.debug("XXX " + aDash + " -- " + aDashCheck.toString());
					if ("x".equalsIgnoreCase(aDashCheck)) {
						aRolePermission.setHotel_Tax_Exempt_Locations(true);
					}
				} else if (aDash.startsWith("Dashboard") && aDash.endsWith("Lodging")) {
					//log.debug("XXX " + aDash + " -- " + aDashCheck.toString());
					if ("x".equalsIgnoreCase(aDashCheck)) {
						aRolePermission.setLodging(true);
						aRolePermission.setFPLP_FEMA(true);
						aRolePermission.setLodging_Non_Use_Reason_Justification(true);
						aRolePermission.setGovernment_Lodging_Programs_Unavailability(true);
					} else {
						aRolePermission.setLodging(false);

					}
				} else if (aDash.startsWith("Dashboard") && aDash.endsWith("Debt Management")) {
					//log.debug("XXX " + aDash + " -- " + aDashCheck.toString());
					if ("x".equalsIgnoreCase(aDashCheck)) {
						aRolePermission.setDebtManagement(true);
					} else {
						aRolePermission.setDebtManagement(false);

					}
				} else if (aDash.equals("Debt Management Summary")) {
					//log.debug("XXX " + aDash + " -- " + aDashCheck.toString());
					if ("x".equalsIgnoreCase(aDashCheck)) {
						aRolePermission.setDebt_Management_Summary(true);
					}
				} else if (aDash.equals("Debt Management Detail")) {
					//log.debug("XXX " + aDash + " -- " + aDashCheck.toString());
					if ("x".equalsIgnoreCase(aDashCheck)) {
						aRolePermission.setDebt_Management_Detail(true);
					}
				} else if (aDash.equals("Debts with Offsets and Collections")) {
					//log.debug("XXX " + aDash + " -- " + aDashCheck.toString());
					if ("x".equalsIgnoreCase(aDashCheck)) {
						aRolePermission.setDebts_with_Offsets_and_Collections(true);
					}
				} else if (aDash.equals("Monthly Debt Summary")) {
					//log.debug("XXX " + aDash + " -- " + aDashCheck.toString());
					if ("x".equalsIgnoreCase(aDashCheck)) {
						aRolePermission.setMonthly_Debt_Summary(true);
					}
				} else if (aDash.startsWith("Dashboard") && aDash.endsWith("Transaction Monitoring")) {
					//log.debug("XXX " + aDash + " -- " + aDashCheck.toString());
					if ("x".equalsIgnoreCase(aDashCheck)) {
						aRolePermission.setTransactionMonitoring(true);
					} else {
						aRolePermission.setTransactionMonitoring(false);

					}
				} else if (aDash.equalsIgnoreCase("\"What's Out\": Totals by System")) {
					if ("x".equalsIgnoreCase(aDashCheck)) {
						aRolePermission.setWhats_Out_Totals_by_System(true);
					}
				} else if (aDash.equalsIgnoreCase("\"What's Out\": Details")) {
					if ("x".equalsIgnoreCase(aDashCheck)) {
						aRolePermission.setWhats_Out_Details(true);
					}
				} else if (aDash.equalsIgnoreCase("Posack Delinquency")) {
					if ("x".equalsIgnoreCase(aDashCheck)) {
						aRolePermission.setPosack_Delinquency(true);
					}
				} else if (aDash.equalsIgnoreCase("Partner System Posack Delinquency")) {
					if ("x".equalsIgnoreCase(aDashCheck)) {
						aRolePermission.setPartner_System_Posack_Delinquency(true);
					}
				} else if (aDash.equals("") ||
						aDash.equals("Subject Areas") ||
						aDash.equals("Audit Trail: Account Data") ||
						aDash.equals("Audit Trail: Person Data") ||
						aDash.equals("Trip Debt") ||
						aDash.equals("Trip Documents") ||
						aDash.equals("Trip Expense Summary") ||
						aDash.equals("Trip Expenses") ||
						aDash.equals("Trip Leave") ||
						aDash.equals("Trip Lodging") ||
						aDash.equals("Trip Special Duty") ||
						aDash.equals("Audity Trail: User Data") ||
						aDash.equals("Trip Legs") ||
						aDash.equals("Trip Summary") ||
						aDash.equals("Trip Tickets") ||
						aDash.equals("Trip Transactions") ||
						aDash.equals("Dashboards & Reports") ||
						aDash.equals("Save to Catalog Folder") ||
						aDash.equals("Shared Folders") ||
						aDash.equals("DTS Reporting") ||
						aDash.equals("DTS Reports") ||
						aDash.equals("Functions") ||
						aDash.equals("Create Analysis") ||
						aDash.equals("Create Dashboard") ||
						aDash.equals("Create BIP Report") ||
						aDash.equals("xxx") ||
				      aDash.equals("xxx")

			        	){
		     	}
                else {
					log.debug("SKIPPED  *** " + aDash);
				}
				//log.debug("column Name - " + aDash);

			}
			//log.debug("=== Role Permision List ============================");
			String sss = aRolePermission.getRoleName();
			//if (sss.contains("R_"))
			rolePermissionList.add(aRolePermission);

		}
		log.debug("Leaving TestUtilReports.getData() Role Permision List size=" + rolePermissionList.size());
		return rolePermissionList.toArray();

	}

}