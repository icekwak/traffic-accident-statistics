<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.util.*" %>
<%@ page import="road.*" %>

<jsp:useBean id="road" class="road.roadCtrl"/>
<%
	ArrayList<roadBean> alist = road.getRoadList();
	int count = alist.size();
	String json = "[";
	
	for(int i=0; i<count; i++){
		roadBean data = alist.get(i);
	
	    json += "{\"id\":\"";
	    json += data.getId();
	    json += "\",";
	    json += "\"accident\":\"";
	    json += data.getAccident();
	    json += "\",";
	    json += "\"death\":\"";
	    json += data.getDeath();
	    json += "\",";
	    json += "\"injured\":\"";
	    json += data.getInjured();
	    json += "\"}";
	    if(i != count - 1)
	    	json += ",";
	}
    json += "]";
    
    out.print(json);
%>
        