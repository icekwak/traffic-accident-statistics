<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.util.*" %>
<%@ page import="region.*" %>

<jsp:useBean id="region" class="region.rankSiCtrl"/>
<%
	ArrayList<rankSiBean> alist = region.getrankSiList();
	int count = alist.size();
	String json = "[";
	
	for(int i=0; i<count; i++){
		rankSiBean data = alist.get(i);
	
	    json += "{\"rankId\":\"";
	    json += data.getRankId();
	    json += "\"}";
	    if(i != count - 1)
	    	json += ",";
	}
    json += "]";
    
    out.print(json);
%>