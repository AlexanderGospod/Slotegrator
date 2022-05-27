package api.user_data;

public class SuccessfulGetUserData {
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
