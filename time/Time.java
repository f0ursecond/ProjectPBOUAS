package time;

import java.util.Timer;
import java.util.TimerTask;
import pet.Pet;
import pet.Dog;
import pet.Cat;
import pet.Bird;

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
    public static void startAutoTimePass(Pet pet) {
        startAutoTimePass(pet, 0);
    }

    public static void startAutoTimePass(Pet pet, int startTime) {
        int intervalSec = 5;
        int totalDurationSec = 80;
        if (pet instanceof Dog) {
            totalDurationSec = 120;
            intervalSec = 10;
        } else if (pet instanceof Cat) {
            totalDurationSec = 140;
            intervalSec = 15;
        } else if (pet instanceof Bird) {
            totalDurationSec = 85;
            intervalSec = 20;
        }

        stopAutoTimePass();
        currentTime = startTime; // Mulai dari detik ke-startTime
        totalLimit = totalDurationSec;
        final int finalIntervalSec = intervalSec;
        activeTimer = new Timer(true);

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                if (currentTime < totalLimit) {
                    currentTime++; // Bertambah setiap detik (Tick)

                    // Terjadi timePasses setiap kelipatan interval
                    if (currentTime % finalIntervalSec == 0) {
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
