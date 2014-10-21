package ch.lukasmartinelli.redditclone.dl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Timer;
import java.util.TimerTask;

public class DataManager {
	private static DataContainer data;

	public static DataContainer getData() {
		return data;
	}
	public static void setData(DataContainer d) {
		data = d;
	}

	public static void deserializeX() throws ClassNotFoundException, IOException {
		File dataFile = getDataFile();
		System.out.println("Initialize dataManager with "
				+ dataFile.getAbsolutePath());
		if (!dataFile.exists()) {
			DataManager.data = DataContainer.getNew();
		} else {
			deserialize();
			if(DataManager.data == null) {
				DataManager.data = DataContainer.getNew();
			}
		}
	}


	private static File getDataFile() throws UnsupportedEncodingException {
		File tmpDir = new File(System.getProperty("java.io.tmpdir"));
		File dataFile = new File(tmpDir, "container.ser");
		return dataFile;
	}

	public static void serializeX() throws IOException {
		try (FileOutputStream fileOut = new FileOutputStream(getDataFile())) {
			try (ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
				out.writeObject(DataManager.data);
			}
		}
	}

	private static void deserialize() throws ClassNotFoundException, IOException {
			try (FileInputStream fileIn = new FileInputStream(getDataFile())) {
				try (ObjectInputStream in = new ObjectInputStream(fileIn)) {
					DataManager.data = (DataContainer) in.readObject();
				}
			}
		
	}
}
