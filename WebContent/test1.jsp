<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
<%@ page import = "java.sql.*" %>     <!-- JSP���� JDBC�� ��ü�� ����ϱ� ���� java.sql ��Ű���� import �Ѵ� -->
<%
Connection conn = null; //�ʱ�ȭ
try{
String url = "jdbc:mysql://localhost:3306/listdb";      // URL, "jdbc:mysql://localhost:3306/(mySql���� ���� DB��)" << �Է� �̶� 3306�� mysql�⺻ ��Ʈ
String id = "root";         // SQL ����� �̸�
String pw = "roqkf2";     // SQL ����� �н�����
Class.forName("com.mysql.jdbc.Driver");              // DB�� �����ϱ� ���� DriverManager�� ����Ѵ�.
conn=DriverManager.getConnection(url,id,pw);    // DriverManager ��ü�κ��� Connection ��ü�� ���´�.
out.println("�����");      // Ŀ�ؼ��� ����� ����Ǹ� ����ȴ�.

Statement stat = conn.createStatement();
String query = "INSERT INTO test1(device,code)  VALUES('device2','qewrqwer5555')";
//INSERT into member(id,name,pwd,email) VALUES ('id','name','pwd','email') ������
stat.executeUpdate(query);
stat.close();
conn.close();

}catch(Exception e){     // ���� ó��
e.printStackTrace();
}
%>