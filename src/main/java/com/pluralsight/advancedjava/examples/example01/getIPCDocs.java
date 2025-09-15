package main.java.com.pluralsight.advancedjava.examples.example01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Properties;
import java.util.TimeZone;
import java.util.function.Function;
import java.util.stream.Collectors;

public class getIPCDocs {

    private ArrayList<ContentList> getIpcDocs(TemplateResponse indPosttemplateResponse) throws Exception {
        Connection conn = null;
        PreparedStatement stmt = null;
        ArrayList<ContentList> ipcDocs = new ArrayList<>();
        try {
            StringBuffer sb = new StringBuffer();
            sb.append("SELECT d1." + ipcObjectIdCol + ",d1." + ipcObjectClassIdCol + ",d1." + ipcVersionSeriesIdCol + ",d1." + ipcAcapStatusCol + ",d1." + ipcScanUserIdCol + ",d1.");
            sb.append(ipcApplNumCol + ",d1." + ipcCaptDateCol + ",d1.+" + ipcCaptGuidCol + ",d1." + ipcCreDateCol + ",d1." + ipcSpotDealCol + ",d1.");
            sb.append(ipcDocTypeCol + ",d1." + ipcBatchIDCol + ",d1." + ipcCommentsCol);
            sb.append(", datediff(dd, d1." + ipcCreDateCol + ", getutcdate()) as " + ipcNumCreateDatesCol + ",c." + ipcSymbolicNameCol);
            sb.append(" from " + docVersionTable + " d1 with(no lock) ");
            sb.append(" INNER JOIN " + classDefinitionTable + " c ON d1.object_class_id = c.object_id");
            sb.append(" where d1." + ipcObjectClassIdCol + ", getutcdate()) < 48");
            sb.append(" order by d1." + ipcApplNumCol);

            SQLServerDataSource ds = new SQLServerDataSource();
            ds.setURL(docDBServerUrl);
            ds.setUser(docDbUserId);
            ds.setPassword(docDbPassword);

            conn = ds.getConnection();
            APP_LOG.info("IPC get-docs sql: " + sb.toString());
            stmt = conn.prepareStatement(sb.toString());
            ResultSet rs = stmt.executeQuery();
            Calendar cal = Calendar.getInstance();
            if (!"UTC".equalsIgnoreCase(cal.getTimeZone().getID())) {
                cal.setTimeZone(TimeZone.getTimeZone("UTC"));
            }

            ArrayList<TemplateProperty> indirectTemplateProperties = indPosttemplateResponse.getTemplate().getProperties();
            Map<String, TemplateProperty> templatePropertyMap = indirectTemplateProperties.stream().collect(Collectors.toMap(k -> k.getName(), Function.identity()));

            while (rs.next()) {
                ContentList content = new ContentList();
                ArrayList<Properties> ipcDocProperties = new ArrayList<>();

                if (rs.getString(ipcObjectIdCol) != null) {
                    StringBuffer contentBuffer = new StringBuffer();
                    contentBuffer.append("{");
                    contentBuffer.append(rs.getString(ipcObjectIdCol));
                    contentBuffer.append("}");
                    content.setContentId(contentBuffer.toString());
                }
                if (rs.getString(ipcObjectClassIdCol) != null) {
                    StringBuffer templateBuffer = new StringBuffer();
                    templateBuffer.append("{");
                    templateBuffer.append(rs.getString(ipcObjectClassIdCol));
                    templateBuffer.append("}");
                    content.setTemplateId(templateBuffer.toString());
                }
                if (rs.getString(ipcVersionSeriesIdCol) != null) {
                    content.setVersionSeriesId(rs.getString(ipcVersionSeriesIdCol));
                }
                if (rs.getString(ipcAcapStatusCol) != null) {
                    ipcDocProperties.add(setProperty(rs.getString(ipcAcapStatusCol), templatePropertyMap.get("ACAP Status")));
                }
                if (rs.getString(ipcApplNumCol) != null) {
                    ipcDocProperties.add(setProperty(rs.getString(ipcApplNumCol), templatePropertyMap.get("Application Number")));
                }
                if (rs.getString(ipcScanUserIdCol) != null) {
                    ipcDocProperties.add(setProperty(rs.getString(ipcScanUserIdCol), templatePropertyMap.get("Scan User ID")));
                }
                Timestamp capTs = rs.getTimestamp(ipcCaptDateCol, cal);
                if (capTs != null) {
                    ipcDocProperties.add(setProperty(String.valueOf(capTs.getTime()), templatePropertyMap.get("Capture Date")));
                }
                if (rs.getString(ipcCaptGuidCol) != null) {
                    ipcDocProperties.add(setProperty(rs.getString(ipcCaptGuidCol), templatePropertyMap.get("Capture GUID")));
                }
                if (rs.getString(ipcDocTypeCol) != null) {
                    ipcDocProperties.add(setProperty(rs.getString(ipcDocTypeCol), templatePropertyMap.get("Document Type")));
                }
                if (rs.getString(ipcSpotDealCol) != null) {
                    ipcDocProperties.add(setProperty(rs.getString(ipcSpotDealCol), templatePropertyMap.get("Spot Deal")));
                }
                if (rs.getString(ipcBatchIDCol) != null) {
                    ipcDocProperties.add(setProperty(rs.getString(ipcBatchIDCol), templatePropertyMap.get("Batch ID")));
                }
                if (rs.getString(ipcCommentsCol) != null) {
                    ipcDocProperties.add(setProperty(rs.getString(ipcCommentsCol), templatePropertyMap.get("Comments")));
                }
                if (rs.getString(ipcApplNumCol) != null) {
                    ipcDocProperties.add(setProperty(rs.getString(ipcApplNumCol), templatePropertyMap.get("Application Number")));
                }
                Timestamp dateCre = rs.getTimestamp(ipcCreDateCol, cal);
                if (dateCre != null) {
                    ipcDocProperties.add(setProperty(String.valueOf(dateCre.getTime()), templatePropertyMap.get("Date Created")));
                }
                if (rs.getString(ipcNumCreateDatesCol) != null) {
                    content.setNumOfCreateDays(rs.getInt(ipcNumCreateDatesCol));
                }
                if (rs.getString(ipcSymbolicNameCol) != null) {
                    content.setClassName(rs.getString(ipcSymbolicNameCol));
                }
                content.setProperties(ipcDocProperties);
                ipcDocs.add(content);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (stmt != null) { stmt.close(); }
        if (conn != null) { conn.close(); }
    }
    return ipcDocs;
    }
}
