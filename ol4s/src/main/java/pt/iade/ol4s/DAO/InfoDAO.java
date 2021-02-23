package pt.iade.ol4s.DAO;



import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.lang.*;
import java.io.*;


    public class InfoDAO {


        public static Info infoSearch(String infoType, String infoKeyword) {

            Connection con = DBConnector.getConnector().getConnection();
            try {

                PreparedStatement preparedStatement = con.prepareStatement("select * from infosearch where ?=?");

                preparedStatement.setString(1, infoType);
                preparedStatement.setString(2, infoKeyword);
                ResultSet resultSet = preparedStatement.executeQuery();
                resultSet.next();


                Info info = new Info(
                    resultSet.getString("info_name"),
                    resultSet.getString("info_description"),
                    resultSet.getString("info_scientificName"),
                    resultSet.getString("info_latitude"),
                    resultSet.getString("info_longitude"),
                    resultSet.getString ("infoactivity_name"),
                    resultSet.getString("infospecifics_name"),

                    return info;

            } catch (Exception e) {
                System.out.println("Currently there is no information that matches your search, if you'd like, please fill an Information Ticket");
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

        public static Info closestInfo (String currentLatitude, Sring currentLongitude, int radius ) {

            Connection con = DBConnector.getConnector().getConnection();
            try {

                PreparedStatement preparedStatement = con.prepareStatement("select * from infosearch ");
                ResultSet resultSet = preparedStatement.executeQuery();
                resultSet.next();


                Info info = new Info(
                    resultSet.getString("info_name"),
                    resultSet.getString("info_description"),
                    resultSet.getString("info_scientificName"),
                    resultSet.getDouble("info_latitude"),
                    resultSet.getDouble("info_longitude"),
                    resultSet.getString ("infoactivity_name"),
                    resultSet.getString("infospecifics_name"));


            } catch (Exception e) {
                System.out.println("Currently there is no information that matches your search, if you'd like, please fill an Information Ticket");
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

            
            private static double DistanceCalculation(double currentLatitude, double currentLongitude, double info_latitude, double info_longitude) {   //https://www.geodatasource.com/developers/java
                if ((currentLatitude == info_latitude) && (currentLongitude == info_longitude)) {
                    return 0;
                }
                else {
                    double theta = currentLongitude - info_longitude;
                    double dist = Math.sin(Math.toRadians(currentLatitude)) * Math.sin(Math.toRadians(info_latitude)) + Math.cos(Math.toRadians(currentLatitude)) * Math.cos(Math.toRadians(info_latitude)) * Math.cos(Math.toRadians(theta));
                    dist = Math.acos(dist);
                    dist = Math.toDegrees(dist);
                    dist = dist * 60 * 1.1515 * 1.609344;
                 }
                    return (dist);
                }
        



        }


    }

