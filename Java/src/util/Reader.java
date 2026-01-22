package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.Scanner;

public class Reader<T> {

	T[] data;
	File file;
	Class<T> type;

	@SuppressWarnings("unchecked")
	public Reader(String filePath, Class<T> type) {
		this.file = new File(filePath);
		this.type = type;
		this.data = (T[]) new Object[1000]; // assuming max 100 lines
	}

	public T[] readData() {
		Scanner scanner;
		try {
			scanner = new Scanner(file);
			int lineNumber = 0;
			while (scanner.hasNextLine()) {
				lineNumber++;
				String record = scanner.nextLine();
				try {
					this.data[lineNumber] = this.type.getConstructor(String.class).newInstance(record);
				} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
						| InvocationTargetException | NoSuchMethodException | SecurityException e) {
					e.printStackTrace();
				}

			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this.data;
	}
}
