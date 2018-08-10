package dao.repo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.jda.model.User;

public class RepoImplementation implements Repo{
	
	private Connection connect = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

	public void save(User user) throws Exception{
		try{
			 Class.forName("com.mysql.cj.jdbc.Driver");
          // Setup the connection with the DB
          connect = DriverManager
                  .getConnection("jdbc:mysql://" + System.getenv("DBHOST") + "/db1000206?user=" + System.getenv("DBUSER") + "&password= " + System.getenv("DBPASSWORD"));
          preparedStatement = connect.prepareStatement("insert into db1000206.LoginInfo values(?,?,?,?)");
      
          String name = user.getName();
          String number = user.getNumber();
          String username = user.getUname();
          String password = user.getPwd();
          preparedStatement.setString(1, name);
          preparedStatement.setString(2, number);
          preparedStatement.setString(3, username);
          preparedStatement.setString(4, password);
          preparedStatement.addBatch();
          preparedStatement.executeBatch();
		}
		catch(Exception e){
			throw e;
		}
		finally{
			close();
		}
	}
	
	public boolean check(String name, String password) throws Exception{
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
         // Setup the connection with the DB
         connect = DriverManager
                 .getConnection("jdbc:mysql://" + System.getenv("DBHOST") + "/db1000206?user=" + System.getenv("DBUSER") + "&password= " + System.getenv("DBPASSWORD"));
         preparedStatement = connect.prepareStatement("select * from db1000206.LoginInfo");
         
         resultSet = preparedStatement.executeQuery("select * from LoginInfo WHERE USERNAME = '" + name + "';");
         if(resultSet.next()){
         	if(resultSet.getString("PASSWORD").equals(password))
            	return true;
            else 
            	return false; 		
         }
		}
		catch(Exception e){
			throw e;
		}
		finally{
			close();
		}
		return false;
	}
	
	public void close() {
      try {
          if (resultSet != null) {
              resultSet.close();
          }

          if (connect != null) {
              connect.close();
          }
      } catch (Exception e) {

      }
  }

	@Override
	public void save() {
		// TODO Auto-generated method stub
		
	}
}
