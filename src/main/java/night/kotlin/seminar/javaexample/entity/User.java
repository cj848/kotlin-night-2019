package night.kotlin.seminar.javaexample.entity;

public class User {
	private Long id;
	private String name;
	private String email;

	public User(Long id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public static UserBuilder builder() {
		return new UserBuilder();
	}

	public static class UserBuilder {
		private Long id;
		private String name;
		private String email;

		public UserBuilder setId(Long id) {
			this.id = id;
			return this;
		}

		public UserBuilder setName(String name) {
			this.name = name;
			return this;
		}

		public UserBuilder setEmail(String email) {
			this.email = email;
			return this;
		}

		public User build() {
			return new User(id, name, email);
		}
	}
}
