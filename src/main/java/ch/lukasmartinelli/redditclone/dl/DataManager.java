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
	private DataContainer data;

	public DataContainer getData() {
		return data;
	}
	public void setData(DataContainer d) {
		data = d;
	}

	public void deserializeX() throws ClassNotFoundException, IOException {
		File dataFile = getDataFile();
		System.out.println("Initialize dataManager with "
				+ dataFile.getAbsolutePath());
		if (!dataFile.exists()) {
			data = DataContainer.getNew();
		} else {
			deserialize();
			if(data == null) {
				data = DataContainer.getNew();
			}
		}
	}


	private static File getDataFile() throws UnsupportedEncodingException {
		File tmpDir = new File(System.getProperty("java.io.tmpdir"));
		File dataFile = new File(tmpDir, "container.ser");
		return dataFile;
	}

	public void serializeX() throws IOException {
		try (FileOutputStream fileOut = new FileOutputStream(getDataFile())) {
			try (ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
				out.writeObject(data);
			}
		}
	}

	private void deserialize() throws ClassNotFoundException, IOException {
			try (FileInputStream fileIn = new FileInputStream(getDataFile())) {
				try (ObjectInputStream in = new ObjectInputStream(fileIn)) {
					data = (DataContainer) in.readObject();
				}
			}
		
	}
}
