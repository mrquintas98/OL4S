package pt.iade.ol4s.MODEL;



import java.util.ArrayList;

public class Info {

    private int id;
    private String name;
    private String description;
    private String scientificName;
    private String latitude;
    private String longitude;
    ArrayList<String> infospecifics = new ArrayList<String>() ;
    private String infoActivity;


    public Info(int id, String name, String description, String scientificName, String latitude, String longitude, ArrayList<String> infoSpecifics, String infoActivity) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.scientificName = scientificName;
        this.latitude = latitude;
        this.longitude = longitude;
        this.infoSpecifics = infoSpecif ics;
        this.infoActivity = infoActivity;
    }







	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getScientificName() {
		return this.scientificName;
	}

	public void setScientificName(String scientificName) {
		this.scientificName = scientificName;
	}

	public String getLatitude() {
		return this.latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return this.longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getInfoSpecifics() {
		return this.infoSpecifics;
	}

	public void setInfoSpecifics(String infoSpecifics) {
		this.infoSpecifics = infoSpecifics;
	}

	public String getInfoActivity() {
		return this.infoActivity;
	}

	public void setInfoActivity(String infoActivity) {
		this.infoActivity = infoActivity;
	}




        
   







}


    



	







    







