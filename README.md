## Kiểm thử chức năng cho website Spotify
### Yêu cầu môi trường: Window 10
### Cài đặt môi trường
        Apache Maven 3.8.6: [Maven download](https://maven.apache.org/docs/3.8.6/release-notes.html)
        Java jdk 11.0.21 : [Java download](https://www.oracle.com/java/technologies/javase/11-0-21-relnotes.html)
        Eclipse IDE for Java Developers: [Eclipse](https://www.eclipse.org/downloads/packages/release/europa/winter/eclipse-ide-java-developers)

### Các bước chạy chương trình
   **Bước 1**: Cấu hình Test case muốn chạy trong file testng.xml
       Chạy Test case Sign_in: comment lại 2 Test case search và Add_playlist
       Chạy Test case Search: comment lại 2 Test case Sign_in và Add_playlist
        Chạy Test case Add_playlist: comment lại 2 Test case Sign_in và Search
   **Bước 2**: Chạy câu lệnh *mvn clean test* trong cửa sổ terminal của dự án
   **Bước 3**: Sau khi chạy và build thành công, để xem báo cáo . Gõ câu lệnh *allure-2.25.0\bin\allure serve target\allure-results* trong cửa sổ terminal.
  
  
    
