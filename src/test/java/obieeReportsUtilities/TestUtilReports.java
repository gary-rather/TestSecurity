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


		log.debug("=== TestUtilReports getData 1============================");
		int i = 1;
		// Loop through the Excel Saving the
		for (int rowNum = 2; rowNum <= rows; rowNum++) {
			log.debug("=== TestUtilReports loop ============================");
			// Create the RolePermission Object we are going to pobluate
			RolePermission aRolePermission = new RolePermission();

            String  aRole = (String)excel.getCellData(sheetName,0,rowNum);
            if (aRole.startsWith("R_") || aRole.startsWith("W_")) {
				log.debug(i++ + " " + rowNum + " == " + aRole.toString());
				roleList.add(aRole);
				aRolePermission.setRoleName(aRole);
			} else {
            	continue;
			}
			for (int colNum = 0; colNum < cols; colNum++) {

				String aDash = (String)excel.getCellData(sheetName, colNum, 1);
				String aDashCheck = (String)excel.getCellData(sheetName, colNum, rowNum);
				if (aDash.startsWith("Dashboard") && aDash.endsWith("Trip & Document Status")) {
					log.debug("XXX " + aDash + " -- " + aDashCheck.toString());
					if ("x".equalsIgnoreCase(aDashCheck)){
						aRolePermission.setTripDocumentStatus(true);
					} else {
						aRolePermission.setTripDocumentStatus(false);

					}
				}

				if (aDash.startsWith("Dashboard") && aDash.endsWith("Document Details")) {
					log.debug("XXX " + aDash + " -- " + aDashCheck.toString());
					if ("x".equalsIgnoreCase(aDashCheck)){
						aRolePermission.setDocumentDetails(true);
					} else {
						aRolePermission.setDocumentDetails(false);

					}
				}

				if (aDash.startsWith("Dashboard") && (aDash.endsWith("Traveler & User Information") )) {
					log.debug("XXX " + aDash + " -- " + aDashCheck.toString());
					if ("x".equalsIgnoreCase(aDashCheck)){
						aRolePermission.setTravelerUserInformation(true);
					} else {
						aRolePermission.setTravelerUserInformation(false);

					}
				}

				if (aDash.startsWith("Dashboard") && aDash.endsWith("Audit Trail")) {
					log.debug("XXX " + aDash + " -- " + aDashCheck.toString());
					if ("x".equalsIgnoreCase(aDashCheck)){
						aRolePermission.setAuditTrail(true);
						aRolePermission.setTravelerUserInformation(true);
					} else {
						aRolePermission.setAuditTrail(false);
						//aRolePermission.setTravelerUserInformation(false);
					}
				}

				if (aDash.startsWith("Dashboard") && aDash.endsWith("Tickets")) {
					log.debug("XXX " + aDash + " -- " + aDashCheck.toString());
					if ("x".equalsIgnoreCase(aDashCheck)){
						aRolePermission.setTickets(true);
					} else {
						aRolePermission.setTickets(false);

					}
				}

				if (aDash.startsWith("Dashboard") && aDash.endsWith("Military Information")) {
					log.debug("XXX " + aDash + " -- " + aDashCheck.toString());
					if ("x".equalsIgnoreCase(aDashCheck)){
						aRolePermission.setMilitaryInformation(true);
					} else {
						aRolePermission.setMilitaryInformation(false);

					}
				}

				if (aDash.startsWith("Dashboard") && aDash.endsWith("Expenses")) {
					log.debug("XXX " + aDash + " -- " + aDashCheck.toString());
					if ("x".equalsIgnoreCase(aDashCheck)){
						aRolePermission.setExpenses(true);
					} else {
						aRolePermission.setExpenses(false);

					}
				}
				if (aDash.startsWith("Dashboard") && aDash.endsWith("Lodging")) {
					log.debug("XXX " + aDash + " -- " + aDashCheck.toString());
					if ("x".equalsIgnoreCase(aDashCheck)){
						aRolePermission.setLodging(true);
					} else {
						aRolePermission.setLodging(false);

					}
				}

				if (aDash.startsWith("Dashboard") && aDash.endsWith("Debt Management")) {
					log.debug("XXX " + aDash + " -- " + aDashCheck.toString());
					if ("x".equalsIgnoreCase(aDashCheck)){
						aRolePermission.setDebtManagement(true);
					} else {
						aRolePermission.setDebtManagement(false);

					}
				}

				if (aDash.startsWith("Dashboard") && aDash.endsWith("Transaction Monitoring")) {
					log.debug("XXX " + aDash + " -- " + aDashCheck.toString());
					if ("x".equalsIgnoreCase(aDashCheck)){
						aRolePermission.setTransactionMonitoring(true);
					} else {
						aRolePermission.setTransactionMonitoring(false);

					}
				}

			}
			log.debug("=== Role Permision List ============================");
			rolePermissionList.add(aRolePermission);
		}

		return rolePermissionList.toArray();

	}

}