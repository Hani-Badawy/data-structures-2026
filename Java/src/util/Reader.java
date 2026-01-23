package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

/**
 * @author Hani Mohammed (Hani Badawy)
 * @description A generic file reader that reads data from a file and creates
 *              objects of type T. Generic type T must have a constructor that
 *              takes a single String argument. This reader is data type
 *              agnostic and can be used to read any type of data as long as the
 *              type T meets the constructor requirement.
 * @param <T>
 */

public class Reader<T> {

	private T[] data;
	private File file;
	private final Class<T> type;

	@SuppressWarnings("unchecked")
	public Reader(String filePath, Class<T> type) {
		this.file = new File(filePath);
		this.type = type;
		// Assuming max 100 lines.
		// Note: This is not dynamic and should be improved for production code.
		// Also note that Java does not allow direct generic array creation.So, we use
		// Object array and cast it.
		this.data = (T[]) new Object[1000];
	}

	/**
	 * Reads data from the file and creates objects of type T using reflection.
	 * Assumes that type T has a constructor that takes a single String argument.
	 * Populates the data array with the created objects.
	 */
	public void readData() {
		Scanner scanner;
		try {
			scanner = new Scanner(file);
			int lineNumber = -1;
			while (scanner.hasNextLine()) {
				lineNumber++;
				String record = scanner.nextLine();
				try {
					this.data[lineNumber] = type.getConstructor(String.class).newInstance(record);
				} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
						| InvocationTargetException | NoSuchMethodException | SecurityException e) {
					e.printStackTrace();
				}

			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public T[] getData() {
		return data;
	}

	public T getItem(int index) {
		return data[index];
	}
}
