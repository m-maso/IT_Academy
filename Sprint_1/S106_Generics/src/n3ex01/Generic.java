package n3ex01;

public class Generic {

	public static <T extends Phone> void genPhone(T arg) {
		arg.call();
		//arg.takePhoto(); -> Can't call to method takePhoto()
	}
	
	public static <T extends Smartphone> void genSmartphone(T arg) {
		arg.call();
		arg.takePhoto();
	}
}
