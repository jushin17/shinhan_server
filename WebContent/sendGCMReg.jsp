<%@page import="java.net.URLEncoder"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/json; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import = "java.sql.*" %> 
<%
 	String key1 = request.getParameter("KEY");
 	String reg1 = request.getParameter("REG");
    System.out.println("*********************************************************");
    System.out.println("REG ȹ��");
    System.out.println("KEY : ");
    System.out.println("REG : ");
    System.out.println("*********************************************************");
    
    Map rtnMap = new HashMap();
    
    rtnMap.put("DATA", URLEncoder.encode("��ϵǾ����ϴ�.", "UTF-8"));
    rtnMap.put("DATA1", "END1");
    out.print(rtnMap.toString());
 
    
    Connection conn = null; //�ʱ�ȭ
    try{
    String url = "jdbc:mysql://localhost:3306/listdb";      // URL, "jdbc:mysql://localhost:3306/(mySql���� ���� DB��)" << �Է� �̶� 3306�� mysql�⺻ ��Ʈ
    String id = "root";         // SQL ����� �̸�
    String pw = "roqkf2";     // SQL ����� �н�����
    Class.forName("com.mysql.jdbc.Driver");              // DB�� �����ϱ� ���� DriverManager�� ����Ѵ�.
    conn=DriverManager.getConnection(url,id,pw);    // DriverManager ��ü�κ��� Connection ��ü�� ���´�.
    
    Statement stat = conn.createStatement();
    
    String query = "INSERT INTO test3(device,code)  VALUES('"+key1+"','"+reg1+"')";
    stat.executeUpdate(query);
    
    stat.close();
    conn.close();

    }catch(Exception e){     // ���� ó��
    e.printStackTrace();
    }
    
%>
