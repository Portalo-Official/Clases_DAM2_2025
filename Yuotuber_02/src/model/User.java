package model;

public class User {
	    private Long id;
	    private String creditCard;
	    private String name;
	    private String email;
	    private String phone;
	    private NotificationPreference notificationPreference;
	    
		public User(Long id, String name, String email, String phone, NotificationPreference notificationPreference) {
			super();
			this.id = id;
			this.name = name;
			this.email = email;
			this.phone = phone;
			this.notificationPreference = notificationPreference;
		}
		
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		public NotificationPreference getNotificationPreference() {
			return notificationPreference;
		}
		public void setNotificationPreference(NotificationPreference notificationPreference) {
			this.notificationPreference = notificationPreference;
		}

}
