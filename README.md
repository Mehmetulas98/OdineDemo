# OdineDemo

Babamın sağlık sorunu yüzünde geçici bir bilgisayar üzerinde geliştirmeler yaptım. O yüzden postgres ile aynı anda spring projesinin ayağa kaldıramadım sanıyorum ki bilgisayardaki SSL ayarları yüzünden. Postman Collections bilgileri mail gönderdim. Proje ayağa kaldırılırken tablo yapıları postgres tarafında otomatik olarak oluşturuluyor.

Temel db yapısında Freelancer, Job ve Comment tabloları bulunmakta. Freelancer içerisinde design tools, software languages ve specialties bilgileri için ayrıca tablolar bulunmakta ve foreing key mantığı ile Freelancer tablosua bağlıdırlar. Freelancer controller tarafında ekleme yaparken 3  dakikalık bir asenkron kullanım mevcuttur.
