package pt.iade.ol4s.DAO;



import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


    public class TicketDAO {


        public static Ticket confirmTicket(String email, String status) {

            Connection con = DBConnector.getConnector().getConnection();
            try {

                PreparedStatement preparedStatement = con.prepareStatement("select * from ticketinfo where user_email = ? OR ticketstatus_status = ?");

                preparedStatement.setString(1, email);
                preparedStatement.setString(2, status);
                ResultSet resultSet = preparedStatement.executeQuery();
                resultSet.next();


                Ticket ticket = new Ticket(
                    resultSet.getString("ticket_name"),
                    resultSet.getString("ticket_description"),
                    resultSet.getString("ticket_scientificName"),
                    resultSet.getString("ticket_latitude"),
                    resultSet.getString("ticket_longitude"),
                    resultSet.getString ("ticketstatus_status"),
                    resultSet.getString("user_email"),
                    resultSet.getString("usertype_type"),
                    resultSet.getString("infospecifics_name"),
                    resultSet.getString("infoactivity_name")); 

                    return ticket;

            } catch (Exception e) {
                System.out.println("There is no ticket that corresponds with the input information.");
            return null;
                } 
                    finally {
                    try {
                        con.close();
                        } catch (Exception e) {
                            System.out.println("Connection not closed, please try again.");
                    }
                }       


    



 
        

    }

