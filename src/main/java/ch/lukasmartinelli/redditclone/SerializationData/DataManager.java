package ch.lukasmartinelli.redditclone.SerializationData;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Timer;
import java.util.TimerTask;

public class DataManager {
	public DataContainer data;
	//public String outFile = "C://temp//dataContainer.ser";
	public String outFile = "C://temp//dataContainer.ser";
	private Timer t = new Timer();
	TimerTask tt;
	public DataManager() {
		try{
			java.io.File f = new java.io.File(outFile);
			System.out.println("Initialize dataManager with " + f.getAbsolutePath());
			if(!f.exists()) {
				//No DataContainer exists. Create example one.
				data = DataContainer.getNew();
			} else {
				this.deserialize();
			}
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		tt = new java.util.TimerTask() {
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
		//Serialize all 5s
		t.scheduleAtFixedRate(tt,1000,5000);
		
	}
	private void serialize() throws IOException {
        FileOutputStream fileOut =
        new FileOutputStream(outFile);
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(data);
        out.close();
        fileOut.close();
	}
	private void deserialize() throws ClassNotFoundException, IOException {
        FileInputStream fileIn = new FileInputStream(outFile);
        ObjectInputStream in = new ObjectInputStream(fileIn);
        data = (DataContainer) in.readObject();
        in.close();
        fileIn.close();
	}
	public DataContainer getData() {
		return data;
	}
}
