package time;

public class Time {
    // Menggunakan static agar nilai bisa diakses langsung atau dibagikan
    static int currentTime; 

    public static void countdown() throws InterruptedException {
        int seconds = 10;
        while (seconds >= 0) {
            System.out.println("Time remaining: " + seconds + " seconds");
            Thread.sleep(1000); 
            seconds--;
        }
        currentTime = seconds; // Mengubah nilai akhir setelah hitung mundur selesai (-1)
        System.out.println("Time's up!");
    }

    // Ditambahkan 'static' agar bisa dipanggil tanpa membuat objek baru
    public static int getCurrentTime() {
        return currentTime;
    }
}
