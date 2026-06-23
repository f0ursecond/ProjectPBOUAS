# ProjectPBOUAS
Alasan Pet dan Food dijadikan abstract adalah:

   1. Mencegah Instansiasi Objek Umum: Kita tidak ingin ada objek "Pet" atau "Food" yang tidak spesifik. Seekor hewan peliharaan haruslah spesies tertentu (Kucing, Anjing), dan makanan haruslah
      jenis tertentu (Kering, Basah).
   2. Template & Konsistensi (Contract): Memastikan semua subclass memiliki perilaku wajib yang sama (seperti makeSound() untuk Pet atau getHungerReduction() untuk Food) melalui abstract
      methods.
   3. Reusability (Pewarisan Kode): Mengurangi redundansi dengan menempatkan atribut umum (seperti name, hunger, health) dan logika dasar (seperti showStatus()) di satu tempat agar bisa
      digunakan oleh semua subclass.
   4. Polimorfisme: Memungkinkan sistem mengelola berbagai jenis hewan dan makanan menggunakan tipe referensi induk yang sama dalam satu koleksi (misalnya List<Pet>).