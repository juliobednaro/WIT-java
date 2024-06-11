package pl.wit.lab6;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CounterMultiThreadTest {

    @Test
    public void testFileCreationInFolders() {
        // Ustalony katalog główny na dysku
        String mainFolder = "testMainFolder";
        // Tworzenie folderu głównego
        File mainDir = new File(mainFolder);
        if (!mainDir.exists()) {
            mainDir.mkdirs();
        }

        // Tworzenie egzekutora z pulą wątków na 10 sztuk
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        // Uruchamianie 100 wątków
        IntStream.range(0, 100).forEach(i -> {
            int folderNo = ThreadLocalRandom.current().nextInt(0, 10);
            executorService.execute(new CounterMultiThread(mainFolder, folderNo));
        });

        // Zamknięcie egzekutora po zakończeniu zadania
        executorService.shutdown();
        while (!executorService.isTerminated()) {
            // Czekaj na zakończenie wszystkich wątków
        }

        // Sprawdzenie poprawności wykonania poprzez policzenie plików w katalogach
        for (int i = 0; i < 10; i++) {
            File folder = new File(mainFolder + File.separator + i);
            if (folder.exists()) {
                int fileCount = folder.listFiles().length;
                System.out.println("Folder " + i + " contains " + fileCount + " files.");
                assertEquals(CounterMultiThread.mapFolders.get(i).intValue(), fileCount);
            } else {
                System.out.println("Folder " + i + " does not exist.");
                assertEquals(0, CounterMultiThread.mapFolders.getOrDefault(i, 0).intValue());
            }
        }

        // Usuwanie folderów i plików testowych po zakończeniu testu
        deleteDirectory(mainDir);
    }

    private void deleteDirectory(File directoryToBeDeleted) {
        File[] allContents = directoryToBeDeleted.listFiles();
        if (allContents != null) {
            for (File file : allContents) {
                deleteDirectory(file);
            }
        }
        directoryToBeDeleted.delete();
    }
}
