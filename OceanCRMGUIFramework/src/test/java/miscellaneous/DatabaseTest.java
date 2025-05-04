package miscellaneous;


import java.sql.ResultSet;
import java.sql.SQLException;

import com.ocean.crm.generic.databaseutility.DatabaseUtility;

public class DatabaseTest {

	public static void main(String[] args) throws SQLException {
		DatabaseUtility du=new DatabaseUtility();
		du.getDbconnection();
		du.executeNonselectQuery("create table stud_70612(name varchar(20) not null, address varchar(50) not null);");
		du.executeNonselectQuery("insert into stud_70612 values('Krishna','Bengaluru'),('Ram','Hydrabad')");
		ResultSet rs = du.executeSelectQuery("select * from stud_706;");
		while(rs.next()) {
			System.out.println(rs.getString(1)+" "+rs.getString(2));
		}
		du.closeDbconnection();
	}

}
