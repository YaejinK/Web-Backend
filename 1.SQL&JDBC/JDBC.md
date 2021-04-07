JDBC란?
========
## JDBC(Java Database Connectivity)
- 자바 프로그램 내에서 SQL문을 실행하기 위한 자바 API
- 자바를 이용한 데이터베이스 접속과 SQL문장의 실행, 실행결과로 얻어진 데이터의 핸들링을 제공하는 방법과 절차에 관한 규약
- SQL과 프로그래밍 언어의 통합 접근 중 한 형태
- Java는 표준 인터페이스인 JDBC API를 제공

### JDBC를 이용한 프로그래밍 방법
1. import java.sql.*;
2. 드라이버를 로드 한다.
3. Connection 객체를 생성한다. //DB 접속
4. Statement 객체를 생성 및 질의 수행 //query문 생성, 실행
5. SQL문에 결과물이 있다면 ResultSet 객체를 생성한다. //query문에 따라 다름
6. 모든 객체를 닫는다.  //접속 끊기


### JDBC 클래스의 생성 관계
![2_11_1_JDBC_](https://user-images.githubusercontent.com/71435571/113821763-81f41b00-97b7-11eb-9ce2-dc5cfe5c32ff.png)

##### import
    import java.sql.*;
##### 드라이버 로드
    Class.forName( "com.mysql.jdbc.Driver" );
##### Connection 얻기
    String dburl  = "jdbc:mysql://localhost/dbName";
    Connection con =  DriverManager.getConnection ( dburl, ID, PWD );

'''java
public static Connection getConnection() throws Exception{
	String url = "jdbc:oracle:thin:@117.16.46.111:1521:xe";
	String user = "smu";
	String password = "smu";
	Connection conn = null;
	Class.forName("oracle.jdbc.driver.OracleDriver");
	conn = DriverManager.getConnection(url, user, password);
	return conn;
}
'''
##### Statement 생성
    Statement stmt = con.createStatement();
##### 질의 수행
    ResultSet rs = stmt.executeQuery("select no from user" );

    참고
    stmt.execute(“query”);             //any SQL
    stmt.executeQuery(“query”);     //SELECT
    stmt.executeUpdate(“query”);   //INSERT, UPDATE, DELETE
##### ResultSet으로 결과 받기
    ResultSet rs =  stmt.executeQuery( "select no from user" );
    while ( rs.next() )
          System.out.println( rs.getInt( "no") );
##### close
    rs.close();
    stmt.close();
    con.close();
