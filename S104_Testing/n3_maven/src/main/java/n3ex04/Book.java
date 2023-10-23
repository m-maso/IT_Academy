package n3ex04;

public class Book {

	// Attrib
		private String title;
		private String subject;
		
		// Constr
		public Book(String title, String subject) {
			this.title = title;
			this.subject = subject;
		}
		
		// Getters
		public String getTitle() {
			return this.title;
		}
		public String getSubject() {
			return this.subject;
		}
		
		// Setters
		public void setTitle(String title) {
			this.title = title;
		}
		public void setSubject(String subject) {
			this.subject = subject;
		}
		
		// Own Method
		@Override
		public String toString() {
			return "Book -> Title: " + this.title + ", Subject: " + this.subject;
		}
}
