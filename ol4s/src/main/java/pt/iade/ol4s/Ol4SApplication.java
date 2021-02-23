package pt.iade.ol4s;

import pt.iade.ol4s.DAO.DBConnector;
import pt.iade.ol4s.DAO.UserDAO;
import pt.iade.ol4s.DAO.TicketDAO;
import pt.iade.ol4s.DAO.InfoDAO;
import pt.iade.ol4s.MODEL.TicketModel;
import pt.iade.ol4s.MODEL.UserModel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Ol4SApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(Ol4SApplication.class, args);
		}


	@Override 
	public void run (String... args) throws Exception {
		Scanner scan = new Scanner(System.in);
		User user = new User();
		System.out.println("Welcome to the Online Library for Sustainability.\n");
		do{
			System.out.println("Please enter your email: ");
			String email = scan.next();
			System.out.println("Please enter your password: ");
			String password = scan.next();
			user = confirmUser(email, password);
		} while (user == null);
		
		if(user.usertype_type.equals('adventurer')){

			System.out.println("Please choose a number from the following: \n \t 1-Search \n \t 2-Information Ticket \n \t 0-Quit \n")
			int choice = scan_choice.next();

			while(choice !=0){
    			switch(choice)
    			{
        			case 1: 
            			searching();
    	        		break;
    	    		case 2:
            			ticketing();
            			break;
    			}
			}

			System.out.println("Logged Out!");
			System.exit(0);

			












		} else {
			System.out.println("Please select one of the following: \n \t 1-Pending Tickets \n \t 2- Approved Tickets \n \t 3-Denied Tickets 1n 1t 0-Quit \n")
			int choice=scan_choice.next();

			switch(choice){
				case 1: 
					confirmTicket('','pending');
					break;
				case 2:
					confirmTicket('','approved');
					break;
				case 3:
					confirmTicket('','denied');
					break;
			}
			System.out.println("Logged Out!");
			System.exit(0);

		}

		public void searching(){
			System.out.println("What would you like to search? \n \t 3-Activity \n \t 4-Specifics \n ");
			int search_choice = scan_choice.next();

			switch(search_choice){
				   case 3:
					System.out.println("Which activity would you like to search? \n \t 1- Fishing \n \t 2-Farming \n \t 3-Hunting \n \t 4-Camping \n \t 5-Shopping \n");
					int actChoice = scan_choice.next();
					if (actChoice==1){
						infoSearch('infoactivity_name','fishing');
					}else if (actChoise==2){
						infoSearch('infoactivity_name','farming');
					}else if (actChoice==3){
						infoSearch('infoactivity_name','hunting');
					}else if (actChoice==4){
						infoSearch('infoactivity_name','camping');
					}else{ 
						infoSearch('infoactivity_name','shopping');
						} 
					break;
				case 4:
					System.out.println("Which specifics would you like to search?\n \t 1-Animal \n \t 2-Bird \n \t 3-Fish \n \t 4-Store \n \t 5-Open Field \n \t 6-Enclosure \n \t 7-Private Land \n \t 8-Public Area");
					int speChoice = scan_choice.next();
					if(speChoice==1){
						infoSearch('infospecifics_name','animal');
					}else if (speChoice==2){
						infoSearch('infospecifics_name','bird');
					}else if (speChoice==3){
						infoSearch('infospecifics_name','fish');
					}else if (speChoice==4){
						infoSearch('infospecifics_name','store');
					}else if (speChoice==5){
						infoSearch('infospecifics_name','open field');
					}else if (speChoice==6){
						infoSearch('infospecifics_name','enclosure');
					}else if (speChoice==7){
						infoSearch('infospecifics_name','private land');
					}else {
						infoSearch('infospecifics_name','public area');
						System.out.println
						}
					break;
			}
		}

		public void ticketing(){
			TicketModel.user_email = UserModel.user_email;
			TicketModel.userType = UserModel.usertype_type;
			TicketModel.ticketstatus_status = 'pending';
			System.out.println("Please input the following information: \n \t Information name:  ");
			TicketModel.ticket_name = scan_choice.next();
			System.out.println("\n \t Scientific name(if none enter --):  ");
			TicketModel.ticket_scientificName = scan_choice.next();
			if(TicketModel.ticket_scientificName.equals(--)){
				TicketModel.ticket_scientificName = null;
			}else {
				TicketModel.ticket_scientificName.equals(TicketModel.ticket_scientificName);
			}
			System.out.println("\n \t Description of the information:  ");
			TicketModel.ticket_description = scan_choice.next();
			System.out.println("\n \t Latitude of the information(format nn.nnnnn):  ");
			TicketModel.ticket_latitude = scan_choice.next();
			System.out.println("\n \t Longitude of the information(format nn.nnnnn):  ");
			TicketModel.ticket_longitude = scan_choice.next();
			System.out.println("\n \t Choose one of the following:\n \t \t 1- Fishing \n \t \t 2-Farming \n \t \t 3-Hunting \n \t \t 4-Camping \n \t \t 5-Shopping \n \t");
			int ticChoiceSpe = scan_choice.next();
			switch(ticChoiceSpe){
				case 1:
					TicketModel.infoactivity_name = 'fishing';
					break;
				case 2:
					TicketModel.infoactivity_name = 'farming';
					break;
				case 3:
					TicketModel.infoactivity_name = 'hunting';
					break;
				case 4:
					TicketModel.infoactivity_name = 'camping';
					break;
				case 5:
					TicketModel.infoactivity_name = 'shopping';
					break;
			}
			System.out.println("\n \t Choose one of the following:\n \t \t 1-Animal \n \t \t 2-Bird \n \t \t 3-Fish \n \t \t 4-Store \n \t \t 5-Open Field \n \t \t 6-Enclosure \n \t \t 7-Private Land \n \t \t 8-Public Area");
			int ticChoiceAct
			switch(ticChoiceAct){
				case 1:
					TicketModel.infospecifics_name = 'animal';
					break;
				case 2:
					TicketModel.infospecifics_name = 'bird';
					break;;
				case 3:
					TicketModel.infospecifics_name = 'fish';
					break;;
				case 4:
					TicketModel.infospecifics_name = 'store';
					break;
				case 5:
					TicketModel.infospecifics_name = 'open field';
					break;
				case 6:
					TicketModel.infospecifics_name = 'enclosure';
					break;
				case 7:
					TicketModel.infospecifics_name = 'private land';
					break;
				case 8:
					TicketModel.infospecifics_name = 'public area';
					break;
			}






		}








}

	





