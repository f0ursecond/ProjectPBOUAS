package time;

import java.util.Timer;
import java.util.TimerTask;
import pet.Pet;

public class Time {
    static int currentTime; 
    private static int totalLimit; // Untuk menyimpan batas akhir

    /**
     * Memulai timer otomatis (Detak Jantung Game).
     * @param pet Objek pet yang dipantau
     * @param totalDurationSec Kapan game/timer berakhir
     * @param intervalSec Setiap berapa detik timePasses dipanggil
     */
    public static void startAutoTimePass(Pet pet, int totalDurationSec, int intervalSec) {
        currentTime = 0; // Mulai dari detik ke-0
        totalLimit = totalDurationSec;
        Timer timer = new Timer(true);
        
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                if (currentTime < totalLimit) {
                    currentTime++; // Bertambah setiap detik (Tick)
                    
                    // Terjadi timePasses setiap kelipatan interval
                    if (currentTime % intervalSec == 0) {
                        pet.timePasses();
                         System.out.println("\n[Sistem] Detik ke-" + currentTime + ": Waktu berlalu...");
                    }
                } else {
                    timer.cancel();
                     System.out.println("\n[Sistem] Timer otomatis selesai (Mencapai batas " + totalLimit + " detik).");
                }
            }
        };

        // Jalankan task setiap 1 detik
        timer.scheduleAtFixedRate(task, 1000, 1000);
    }

    public static int getCurrentTime() {
        return currentTime;
    }
}
