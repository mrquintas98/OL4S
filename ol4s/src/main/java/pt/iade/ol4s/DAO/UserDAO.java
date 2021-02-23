package pt.iade.ol4s.DAO;



import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


    public class UserDAO {


        public static User confirmUser(String email, String password) {

            Connection con = DBConnector.getConnector().getConnection();
            try {

                PreparedStatement preparedStatement = con.prepareStatement("select * from basicuserinfo where user_email = ?");

                preparedStatement.setString(1, email);
                ResultSet resultSet = preparedStatement.executeQuery();
                resultSet.next();


                User user = new User(
                    resultSet.getString("user_name"),
                    resultSet.getDate("user_birth"),
                    resultSet.getString("user_pic"),
                    resultSet.getString("usergender_type"),
                    resultSet.getString("usertype_type"),
                    resultSet.getString("user_email"),
                    resultSet.getString("userpasswords_string"),
                    resultSet.getString("userpasswords_salt"));     

                String encryptedPassword = getHash(password,user.userpasswords_salt);

                if (encryptedPassword.equals(user.userpasswords_string)){
                    System.out.println("Sucessfully logged in.");
                    return user;
                } else {
                    System.out.println("Incorrect password. Please verify and try again.")
                    return null;
                }

            SessionManager.setId(resultSet.getInt("user_id"));


            } catch (Exception e) {
                System.out.println("Please verify your email as it appears it might be incorrect.");
            return null;
                } 
                    finally {
                    try {
                        con.close();
                        } catch (Exception e) {
                            System.out.println("Connection not closed, please try again.");
                    }
                }       


    




        public String getHash(String passwordToHash, String salt){     //https://stackoverflow.com/questions/33085493/how-to-hash-a-password-with-sha-512-in-java
            String generatedPassword = null;
            try {
                MessageDigest md = MessageDigest.getInstance("SHA-512");
                md.update(salt.getBytes(StandardCharsets.UTF_8));
                byte[] bytes = md.digest(passwordToHash.getBytes(StandardCharsets.UTF_8));
                StringBuilder sb = new StringBuilder();
                for(int i=0; i< bytes.length ;i++){
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword; 
        

    }

