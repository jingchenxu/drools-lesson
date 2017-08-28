package droolscours;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class TestSerial {
	// 可能会抛出IO异常
	public static void main(String[] args) throws IOException {
		// 在同一个包下类可以直接使用
		Person person = new Person(1234, "xu", null);
		System.out.println("Person Serial" + person);
		FileOutputStream fos = new FileOutputStream("Person.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(person);
		oos.flush();
		oos.close();
		System.out.println("=================over----------");
	}
}
