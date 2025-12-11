<div align="center">
  <a href="README.md">
    <img src="https://img.shields.io/badge/Documentation-English-blue?style=for-the-badge&logo=us&logoColor=white" alt="Read in English">
  </a>
</div>

<br>
<div align="center">
Dert insanı yer imiş,

Yine gönlüm hoş değil.
</div>

<div align="center">
  <a href="https://mintercoder.net">
    <img src="https://images.mintercoder.net/mintercoder-main/nightops_minter.png" alt="NightOps Drop Logo" width="150" height="150" />
  </a>

  <h1>NightOps Drop</h1>
  
  <p>
    <strong>Yeni Nesil Payload Dağıtım & Red Team Operasyon Platformu</strong>
  </p>

  <p>
    <a href="https://www.java.com">
      <img src="https://img.shields.io/badge/Java-21%2B-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white" alt="Java 21+">
    </a>
    <a href="https://spring.io/projects/spring-boot">
      <img src="https://img.shields.io/badge/Spring%20Boot-4.0-6DB33F?style=for-the-badge&logo=springboot&logoColor=white" alt="Spring Boot 4.0">
    </a>
    <a href="https://www.docker.com/">
      <img src="https://img.shields.io/badge/Docker-Ready-2496ED?style=for-the-badge&logo=docker&logoColor=white" alt="Docker">
    </a>
    <a href="https://mintercoder.gumroad.com/l/nightops-drop">
      <img src="https://img.shields.io/badge/Kurs-Mevcut-FF424D?style=for-the-badge&logo=patreon&logoColor=white" alt="Patreon">
    </a>
  </p>

  <h3>
    <a href="http://nightopsdrop.mintercoder.net/">Canlı Demo</a> •
    <a href="https://mintercoder.gumroad.com/l/nightops-drop">Eğitimi Satın Al</a> •
    <a href="#-mimari">Mimari</a>
  </h3>
</div>

---

## ⚡ NightOps Drop Nedir?

**NightOps Drop**, tamamen **Java 21** ve **Spring Boot 4.0** ile geliştirilmiş; güvenli, gizli ve gelişmiş bir payload dağıtım sistemidir.

Geleneksel dosya sunucularının (Python `http.server` veya Apache gibi) aksine, NightOps Drop **Red Team Operasyonları** için özel olarak mühendislik edilmiştir. Temel odak noktası **OpSec (Operasyonel Güvenlik)**, tespit edilmekten kaçınma (evasion) ve Mavi Takım (Blue Team) aktivitelerinin detaylı takibidir.

Bu depo, projenin **Topluluk Sürümü (Community Edition)** içeriğini barındırır. Tam kaynak koduna erişmek ve bu aracı sıfırdan nasıl geliştireceğinizi öğrenmek için [Eğitim Serimize](https://mintercoder.gumroad.com/l/nightops-drop) göz atın.

---

## 🎮 Canlı Demo

NightOps Drop'un gücünü, henüz kurulum yapmadan önce deneyimleyin.

| **Erişim Noktası** | **Detaylar** |
| :--- | :--- |
| 🌐 **URL** | **[nightopsdrop.mintercoder.net](http://nightopsdrop.mintercoder.net)** |
| 👤 **Kullanıcı Adı** | `nightops` |
| 🔑 **Şifre** | `drop123` |

> *Not: Demo ortamı periyodik olarak sıfırlanır. Lütfen hassas verilerinizi yüklemeyiniz.*

---

## 🚀 Özellikler: Community vs. Professional

Bu proje kapsamlı bir siber güvenlik eğitiminin parçasıdır. Aşağıda, açık kaynaklı demo sürümü ile tam eğitim sürümü arasındaki farkları görebilirsiniz.

| Özellik | Community / Demo | **Professional Course Edition** |
| :--- | :---: | :---: |
| **Teknoloji Yığını** | Java 21 + Spring Boot 4.0 | Java 21 + Spring Boot 4.0 |
| **Güvenli Dosya Barındırma** | ✅ | ✅ |
| **Özel Link (Alias) Tanımlama** | ✅ | ✅ |
| **Docker Desteği** | ✅ | ✅ |
| **Admin Paneli** | ✅ | ✅ |
| **Gelişmiş IP Loglama** | ❌ | ✅ **(Proxy/VPN Tespiti)** |
| **MIME-Type Spoofing** | ❌ | ✅ **(Firewall Atlatma)** |
| **Şifre Korumalı Dosyalar**| ❌ | ✅ **(Anti-Scanner / Sandbox)** |
| **Tek Kullanımlık URL (Burn)** | ✅ | ✅ **(Kendini İmha Eden Linkler)** |
| **TTL (Time-To-Live)** | ✅ | ✅ **(Zaman Ayarlı Linkler)** |

---

## 🎓 Eğitimi Al: Kaynak Kodu & Eğitim

Java ile **Malware Geliştirme** ve **Red Team Araçları** yazma konusunda uzmanlaşmak mı istiyorsunuz?
Bu kursta, NightOps Drop'u sıfırdan inşa ediyor; **Network Interceptor'ları**, **Header Manipülasyonu** ve **Güvenli Mimari** gibi ileri seviye konuları işliyoruz.

### 🌍 Dil Desteği (Language Support)

| İçerik Türü | Dil | Not |
| :--- | :--- | :--- |
| **Seslendirme / Anlatım** | 🇹🇷 Türkçe | Anadilde detaylı anlatım. |
| **Altyazı** | 🇬🇧 İngilizce | Global standartlarda İngilizce altyazı. |
| **Kaynak Kod** | 🇬🇧 İngilizce | Kod yorumları ve değişkenler global standarttadır. |

### 🌟 Neler Öğreneceksiniz?
* **Çekirdek Mantık:** Spring Boot ile C2 operasyonlarına hazır bir dosya sunucusu geliştirmek.
* **OpSec:** Güvenlik duvarlarını ve filtreleri atlatmak için **MIME-Type Spoofing** (Örn: `.exe` dosyasını ağda `.pdf` gibi göstermek).
* **Defansif Kodlama:** Payloadlara şifre koruması ve **TTL (Time-To-Live)** ekleyerek analizcileri engelleme.
* **Dağıtım:** Java uygulamalarını Dockerize ederek hızlı operasyonlara hazırlama.

### 🛒 Nasıl Satın Alınır?

**Tam Kaynak Koduna**, **Video Eğitimlere** ve **Özel Discord** kanalına anında erişmek için aşağıdaki bağlantıları kullanabilirsiniz:

<div align="center">

| **Platform** | **Link** | **İçerik** |
| :--- | :--- | :--- |
| 🌍 **Resmi Site** | **[mintercoder.net](https://mintercoder.net)** | Kurs + Kod + Ömür Boyu Erişim |
| 🧡 **Gumroad** | **[Gumroad'dan al](https://mintercoder.gumroad.com/l/nightops-drop)** | Kurs + Kod + Destek |

<a href="https://mintercoder.gumroad.com/l/nightops-drop">
  <img src="https://img.shields.io/badge/Tam_Erişim_Sağla-Hemen_Al-FF424D?style=for-the-badge&logo=gumroad&logoColor=white" alt="Gumroad’dan Satın Al">
</a>


</div>

---

## 🎥 NightOps Drop — Demo GIF

<div align="center">
  <img src="https://images.mintercoder.net/mintercoder-main/nightops_drop_gif.gif" alt="NightOps Drop Demo" width="800">
  <br>
  <em>NightOps Drop’un çalışma akışı — gerçek zamanlı önizleme</em>
</div>


## 🛠️ Teknoloji Yığını

* **Dil:** Java 21+ (Modern Özellikler)
* **Framework:** Spring Boot 4.0 (Performans & Güvenlik)
* **Veritabanı:** MySQL (Gömülü & Taşınabilir)
* **Frontend:** Thymeleaf + Custom CSS + Tailwind
* **Konteyner:** Docker & Docker Compose

## 📝 Yapılacaklar & Yol Haritası (Roadmap)

- [ ] **Spring AI Entegrasyonu** (Yakında)

---

## ⚠️ Yasal Uyarı

> **NightOps Drop**, yalnızca eğitim amaçlı ve yetkilendirilmiş güvenlik testleri (Pentest/Red Team) için geliştirilmiştir.
> Bu aracın, karşılıklı rıza olmadan hedef sistemlere saldırmak amacıyla kullanılması yasa dışıdır. Yürürlükteki tüm yerel, eyalet ve federal yasalara uymak son kullanıcının sorumluluğundadır. Geliştiriciler, bu programın kötüye kullanımından veya neden olduğu herhangi bir zarardan sorumlu tutulamaz.

---

<div align="center">
  <sub>Geliştirici: <a href="https://mintercoder.net">MinterCoder</a> | NightOps Security</sub>
</div>
