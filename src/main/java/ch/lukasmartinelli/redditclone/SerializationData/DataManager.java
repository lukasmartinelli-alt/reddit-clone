package ch.lukasmartinelli.redditclone.SerializationData;

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
	public DataContainer data;
	private Timer timer = new Timer();
	private TimerTask timerTask;

	public DataManager() throws ClassNotFoundException, IOException {
		File dataFile = getDataFile();
		System.out.println("Initialize dataManager with "
				+ dataFile.getAbsolutePath());
		if (!dataFile.exists()) {
			data = DataContainer.getNew();
		} else {
			this.deserialize();
		}
		serializePeriodically();
	}

	private void serializePeriodically() {
		timerTask = new java.util.TimerTask() {
			@Override
			public void run() {
				try {
					DataManager.this.serialize();
					System.out.println("Serialize dataContainer");
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
			}
		};
		timer.scheduleAtFixedRate(timerTask, 1000, 5000);
	}

	public DataContainer getData() {
		return data;
	}

	private File getDataFile() throws UnsupportedEncodingException {
		File tmpDir = new File(System.getProperty("java.io.tmpdir"));
		File dataFile = new File(tmpDir, "container.ser");
		return dataFile;
	}

	private void serialize() throws IOException {
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
