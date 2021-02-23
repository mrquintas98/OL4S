package pt.iade.ol4s.MODEL;


import java.sql.Date;

public class User {

    private int id;
    private String name;
    private java.sql.Date birth;
    private String gender;
    private String email;
    private String password;´
    private String salt;
    private String type;


    public User(int id, String name, java.sql.Date birth, String gender, String email,
    String password, String salt, String type) {
        this.id = id;
        this.name = name;
        this.birth = birth;
        this.gender = gender;
        this.email = email;
        this.password = password;
        this.salt = salt;
        this.type = type;
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

	public java.sql.Date getBirth() {
		return this.birth;
	}

	public void setBirth(java.sql.Date birth) {
		this.birth = birth;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

    public String getSalt() {
		return this.salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}







    







