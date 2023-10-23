package n3ex01;

public class MainEx01 {

	// Attrib.
		private int value;
		private int[] values;
		
		// Constr.
		public MainEx01(int value) {
			this.value = value;
		}
		public MainEx01(int[] values) {
			this.values = values;
		}
		
		// Getters
		public int getValue() {
			return this.value;
		}
		public int[] getValues() {
			return this.values;
		}
		
		// Setters
		public void setValue(int value) {
			this.value = value;
		}
		public void setValues(int[] values) {
			this.values = values;
		}
}
