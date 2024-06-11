package pl.wit.lab6;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

public class CounterMultiThread implements Runnable {
	// Mapa globalna przechowuje nr katalogu i aktualną liczbę plików wewnątrz
	public static Map<Integer, Integer> mapFolders = new HashMap<>();
	// Numer folderu
	protected int folderNo;
	// Folder główny od którego startuje program
	private String mainFolder;

	public CounterMultiThread(String mainFolder, int folderNo) {
		this.folderNo = folderNo;
		this.mainFolder = mainFolder;
	}

	@Override
	public void run() {
		String fileName;
		synchronized (this) {
			fileName = getNextFileName(folderNo);
		}
		File folder = new File(mainFolder + File.separator + folderNo);
		if (!folder.exists()) {
			folder.mkdirs();
		}
		File file = new File(folder, fileName);
		try {
			file.createNewFile();
			System.out.println("Created file: " + file.getPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private synchronized String getNextFileName(int folderNo) {
		int fileNumber = mapFolders.getOrDefault(folderNo, 0) + 1;
		mapFolders.put(folderNo, fileNumber);
		return fileNumber + ".txt";
	}
}