package obieeReportsUtilities;

import java.io.*;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class WriteResults {
    PrintWriter printWriter = null;

    public WriteResults(String filename,boolean append) {
        try {
            File outDIr = new File("target/out");
            if (!outDIr.exists()) outDIr.mkdir();
            File results = new File("target/out", filename);
            System.out.println("Open File: " + results.getAbsolutePath());
            FileWriter fw = new FileWriter(results, append);
            printWriter = new PrintWriter(fw);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void logTestResults(ArrayList<ResultObject> theTests) {

        StringBuffer sb = new StringBuffer();
        sb.append("<table id='tbl'>");
        for (ResultObject aRow : theTests) {
            if (aRow.theResult) {
                sb.append("<tr><td bgcolor='lightgreen'> Pass </td>");
            } else {
                sb.append("<tr><td bgcolor='red'> Fail </td>");
            }
            sb.append("<td>" + aRow.theTest + "</td></tr>");

        }
        sb.append("</table>");
        printWriter.println(sb.toString());

    }
    public void writeRoleResultsB( String overall,RolePermission rolePermission ) {
        String color = "#00FF00";
        if (overall.equals("FAIL")) {
            color = "#FF0000";
        }
        String rowHtml = "<TD  bgcolor='"+ color +"'>" + overall + "</TD></TR>";
        printWriter.println(rowHtml);
        printWriter.flush();
    }

    public void writeRoleResultsA(int count , RolePermission rolePermission ){

        ZonedDateTime currentDateTime = ZonedDateTime.now();

        DateTimeFormatter format1 = DateTimeFormatter.ofPattern("yyyy-MMM-dd HH:mm:ss z");
        String formatDateTime = currentDateTime.format(format1);


        String userName = rolePermission.userName;
        String roleName = rolePermission.getRoleName();

        String name = roleName + " -- " + userName;


        String rowHtml = "<TR><TD>"+ count +"</TD><TD>" + formatDateTime + "</TD><TD>" + name + "</TD>"  + "<TD> <a target='results' href=\""+ userName +".html\">" + userName + " Results</a> </TD>" ;
        printWriter.println(rowHtml);
        printWriter.flush();
    }
    public void writeRow(String name,boolean visible, int actual, String notes){
        int expectedCount = 0;
        String result = "";
        String color = "#00FF00";
        if (visible) expectedCount = 1;
        if (expectedCount == actual) result = "PASS";
        if (expectedCount != actual) {
            result = "FAIL";
            color = "#FF0000";
        }
        if (expectedCount == 1 && actual == 0) notes = "MISSING";
        if (expectedCount == 1 && actual > 1) notes = "DUPLICATE";
        if (expectedCount == 0 && actual > 0) notes = "SHOULD NOT SHOW";

        String rowHtml = "<TR><TD colspan='2'>" + name + "</TD>"+ "<TD>" + visible + "</TD>" + "<TD  bgcolor='"+ color +"'>" + result + "</TD>"+ "<TD>" + notes + "</TD></TR>";
        printWriter.println(rowHtml);
        printWriter.flush();
    }
    public void writeSectionRow(String name){
        int expectedCount = 0;
        String result = "";
        String color = "#00FF00";

        String rowHtml = "<TR bgcolor='eeeeee'><TD>--</TD><TD>" + name + "</TD><TD>--</TD><TD>--</TD></TR>";
        printWriter.println(rowHtml);
        printWriter.flush();
    }
    public String writeSubRow(String name,boolean visible, int actual, String notes){
        int expectedCount = 0;
        String result = "";
        String color = "#00FF00";
        if (visible) expectedCount = 1;
        if (expectedCount == actual) result = "PASS";
        if (expectedCount != actual) {
            result = "FAIL";
            color = "#FF0000";
        }
        if (expectedCount == 1 && actual == 0) notes = "MISSING";
        if (expectedCount == 1 && actual > 1) notes = "DUPLICATE";
        if (expectedCount == 0 && actual > 0) notes = "SHOULD NOT SHOW";

        String rowHtml = "<TR><TD></TD><TD>" + name + "</TD>"+ "<TD>" + visible + "</TD>" + "<TD  bgcolor='"+ color +"'>" + result + "</TD>"+ "<TD>" + notes + "</TD></TR>";
        printWriter.println(rowHtml);
        printWriter.flush();
        return result;
    }
    public void writeSubRowException(String name, String notes){

        String color = "#F3E42F";
        String rowHtml = "<TR bg><TD></TD><TD>" + name + "</TD>"+ "<TD>" +  "</TD>" + "<TD>&nbsp;</TD>"+ "<TD bgcolor='"+ color +"'>" + notes + "</TD></TR>";
        printWriter.println(rowHtml);
        printWriter.flush();
    }
    public void logSql(ArrayList<SqlObject> theSql) {

        StringBuffer sb = new StringBuffer();
        sb.append("<table id='tbl'>");
        for (SqlObject row : theSql) {
            sb.append("<tr><td>" + row.getLabel() + "</td>" + "<td>" + row.getSql() + "</td></tr>");
        }
        sb.append("</table>");
        printWriter.println(sb.toString());
    }

    public void printDiv(String text) {
        printWriter.println("<div id=\"divtitle\">" + text + "</div>");
        printWriter.flush();
    }
    public void printDiv(String text,String condition, String reason) {
        printWriter.println("<div id=\"divtitle\">" + text + "</div>");

        printWriter.println("<div class=\"container\">");
        printWriter.print("<div class=\"Left\" id=\"divcondition\"> Section: " + condition + "</div>");
        printWriter.println("<div class=\"Right\" id=\"divcondition\"> Reason: " + reason + "</div>");
        printWriter.println("</div>");
        printWriter.flush();
    }

    public void printComment(String text) {
        printWriter.println("<div id=\"divcomment\">" + text + "</div>");
    }

    public void printReason(String reason) {
        printWriter.println("<div id=\"divreason\"> Reason: " + reason + "</div>");
    }

    public void printCondition(String condition) {
        printWriter.println("<div id=\"divcondition\">Condition: " + condition + "</div>");
    }

    public void printYellowDiv(String text) {
        printWriter.println("<div id=\"divyellow\">" + text + "</div>");
    }

    public void openOverAllTable() {
        String tableHtml = "<table id=\"tbl\">\n" +
                "  <tr>\n" +
                "\t<th width='50' >"+"Number " +"</th><th> Timestamp </th>\n" +
                "</th><th> Role  --  UserName </th>\n" +
                "    <th width='300' >Link</th>\n" +

                "    <th width='100'>Status</th>\n" +
                "  </tr>";
        printWriter.println(tableHtml);
        printWriter.flush();

    }
    public void openTable(String role, int roleCount,String userName) {
       String tableHtml = "<table id=\"tbl\">\n" +
               "  <tr>\n" +
               "\t<th width='50' >"+roleCount +"</th><th> "+role+ " -- " + userName +"</th>\n" +
               "    <th width='100' >Expected</th>\n" +
               "\t<th  width='100'>Actual</th>\n" +
               "    <th width='300'>Notes</th>\n" +
               "  </tr>";
       printWriter.println(tableHtml);


    }

    public void closeTable() {
        printWriter.println("</table>");
        printWriter.flush();

    }

    public void closePage() {
        printWriter.println("    </body>");
        printWriter.println("</html>");
        printWriter.flush();
    }

    public void pageHeader() {

        File aFile = new File("src/test/resources/format/pageHeader.txt");
        try (Scanner sc = new Scanner(aFile)) {
            while (sc.hasNextLine()) {

                String s = sc.nextLine(); //Add line separator
                this.printWriter.println(s);
            }
            printWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        printWriter.flush();
    }

}
