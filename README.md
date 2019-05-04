Что внутри?

Этот проэкт содержит автоматизированный тест на Java для поиска в гугле по ключевому слову, а так же он проверяет
 результаты на релевантность запросу на первых двух страницах.

 Проэкт содержит три страници (класса)
SearchTest - непосредственно сами тесты вместе с ключевым словом для поиска и параметрами проверками результатов.
GooglePage - страница с методами поиска нужных элементов и проверки их отображения на странице.
SearchResultPage - страница с методами подсчета и анализа результатов поиска.

Чтобы запустить тесты необходимо установить следующие компоненты:

1. Скачать и установить "Java SE Development Kit 8u201"
URL https://download.oracle.com/otn-pub/java/jdk/8u201-b09/42970487e3af4f5aa5bca3f542482c60/jdk-8u201-windows-x64.exe
2. Скачать и установить "IntelliJ IDEA" бесплатную версию
URL https://www.jetbrains.com/idea/download/download-thanks.html?platform=windows&code=IIC
3. Зайти в репозитории maven "Selenium Java » 3.141.59"
URL https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java/3.141.59
и прописать в файле проэкта "pom.xml" следующие строки:
    <dependencies>
                <dependency>
                    <groupId>org.seleniumhq.selenium</groupId>
                    <artifactId>selenium-java</artifactId>
                    <version>3.141.59</version>
                </dependency>
                <dependency>
                    <groupId>org.testng</groupId>
                    <artifactId>testng</artifactId>
                    <version>6.14.3</version>
                    <scope>test</scope>
                </dependency>
    </dependencies>
4. Скачать и установить "ChromeDriver"
URL https://chromedriver.storage.googleapis.com/2.46/chromedriver_win32.zip
файл из архива скопировать в директорию C:\Windows\System32\

Для запуска необходимо нажать кнопку Run Test на странице SearchTest.