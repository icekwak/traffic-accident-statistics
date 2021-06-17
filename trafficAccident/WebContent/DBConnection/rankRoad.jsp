<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.util.*" %>
<%@ page import="road.*" %>

<jsp:useBean id="road" class="road.rankRoadCtrl"/>
<%
	ArrayList<rankRoadBean> alist = road.getrankRoadList();
	int count = alist.size();
	String json = "[";
	
	for(int i=0; i<count; i++){
		rankRoadBean data = alist.get(i);
	
	    json += "{\"rankId\":\"";
	    json += data.getRankId();
	    json += "\"}";
	    if(i != count - 1)
	    	json += ",";
	}
    json += "]";
    
    out.print(json);
%>