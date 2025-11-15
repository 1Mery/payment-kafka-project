# 🚀 Payment Kafka Project   
Bu proje, Kafka öğrenmek isteyen biri olarak yaptığım demo bir çalışma.  

 Payment-Service → ödeme isteğini karşılıyor ve Kafka'ya event gönderiyor  
 Notification-Service → Kafka'dan gelen event’i tüketiyor ve bildirim/log üretiyor  

Tamamı Spring Boot + Kafka + Cloud Stream ile yapılmış temiz bir mini mikroservis projesi.


# 🎯 Amaç  
- Topic nasıl çalışıyor?
- Producer ne gönderiyor?
- Consumer ne alıyor?
- Servisler Kafka üzerinden nasıl iletişim kuruyor?



# ⚙️ Proje Mimarisi

**Payment-Service**  
✔ Ödeme simülasyonu yapar (random SUCCESS / FAIL)  
✔ Event’i Kafka’ya gönderir (`payment-events` topic)

**Notification-Service**  
✔ Kafka’dan mesajı dinler  
✔ Duruma göre mail/log simülasyonu yapar  
✔ SUCCESS → “Mail gönderildi”  
✔ FAIL → “Ödeme başarısız”  


<img width="852" height="645" alt="image" src="https://github.com/user-attachments/assets/f57e1870-bbd3-4c42-af01-3ff4c1cd53b6" />

Bu istek atıldığında Payment-Service Kafka’ya bir event gönderiyor ve Notification-Service event'i yakalayıp logluyor.

