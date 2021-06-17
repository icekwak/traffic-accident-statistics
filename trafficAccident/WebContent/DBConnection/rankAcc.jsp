<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.util.*" %>
<%@ page import="accident.*" %>

<jsp:useBean id="accident" class="accident.rankAccCtrl"/>
<%
	ArrayList<rankAccBean> alist = accident.getrankAccList();
	int count = alist.size();
	String json = "[";
	
	for(int i=0; i<count; i++){
		rankAccBean data = alist.get(i);
	
	    json += "{\"rankId\":\"";
	    json += data.getRankId();
	    json += "\"}";
	    if(i != count - 1)
	    	json += ",";
	}
    json += "]";
    
    out.print(json);
%>