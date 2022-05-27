package api.registration;

public class SuccessfulRegistrationGamer {
    private Integer id;
    private Integer country_id;
    private Integer timezone_id;
    private String username;
    private String email;
    private String name;
    private String surname;
    private String gender;
    private Integer phone_number;
    private String birthdate;
    private Boolean bonuses_allowed;
    private  Boolean is_verified;

    public SuccessfulRegistrationGamer(Integer id, Integer country_id, Integer timezone_id, String username, String email, String name, String surname
                                        , String gender, Integer phone_number, String birthdate, Boolean bonuses_allowed, Boolean is_verified) {
        this.id = id;
        this.country_id = country_id;
        this.timezone_id = timezone_id;
        this.username = username;
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.phone_number = phone_number;
        this.birthdate = birthdate;
        this.bonuses_allowed = bonuses_allowed;
        this.is_verified = is_verified;
    }

    public Integer getId() {
        return id;
    }

    public Integer getCountry_id() {
        return country_id;
    }

    public Integer getTimezone_id() {
        return timezone_id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getGender() {
        return gender;
    }

    public Integer getPhone_number() {
        return phone_number;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public Boolean getBonuses_allowed() {
        return bonuses_allowed;
    }

    public Boolean getIs_verified() {
        return is_verified;
    }
}
