package time;

import java.util.Timer;
import java.util.TimerTask;
import pet.Pet;

public class Time {

    static int currentTime;
    private static int totalLimit; // Untuk menyimpan batas akhir
    private static Timer activeTimer;

    /**
     * Memulai timer otomatis (Detak Jantung Game).
     * @param pet Objek pet yang dipantau
     * @param totalDurationSec Kapan game/timer berakhir
     * @param intervalSec Setiap berapa detik timePasses dipanggil
     */
    public static void startAutoTimePass(
        Pet pet,
        int totalDurationSec,
        int intervalSec
    ) {
        startAutoTimePass(pet, totalDurationSec, intervalSec, 0);
    }

    public static void startAutoTimePass(
        Pet pet,
        int totalDurationSec,
        int intervalSec,
        int startTime
    ) {
        stopAutoTimePass();
        currentTime = startTime; // Mulai dari detik ke-startTime
        totalLimit = totalDurationSec;
        activeTimer = new Timer(true);

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                if (currentTime < totalLimit) {
                    currentTime++; // Bertambah setiap detik (Tick)

                    // Terjadi timePasses setiap kelipatan interval
                    if (currentTime % intervalSec == 0) {
                        pet.timePasses();
                        System.out.println(
                            "\n[Sistem] Detik ke-" +
                                currentTime +
                                ": Waktu berlalu..."
                        );
                    }
                } else {
                    stopAutoTimePass();
                    System.out.println(
                        "\n[Sistem] Timer otomatis selesai (Mencapai batas " +
                            totalLimit +
                            " detik)."
                    );
                }
            }
        };

        // Jalankan task setiap 1 detik
        activeTimer.scheduleAtFixedRate(task, 1000, 1000);
    }

    public static void stopAutoTimePass() {
        if (activeTimer != null) {
            activeTimer.cancel();
            activeTimer = null;
        }
    }

    public static int getCurrentTime() {
        return currentTime;
    }
}
