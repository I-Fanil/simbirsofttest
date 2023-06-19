**Тестовое задание на вакансию
Разработчик в тестировании**

__________________________________________________________________

При выполнении работы необходимо использовать следующие
технологии:
1) Selenium GRID (тесты запускать через GRID обязательно)
2) Использовать паттерн проектирования автотестов Page Object
3) Реализовать формирование отчетов о пройденных тестах через Allure

__________________________________________________________________

   В задании необходимо:
1) Использовать Python/Java, подключить библиотеку Selenium Webdriver;
2) С помощью Selenium открыть браузер, открыть страницу страницу
   https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login;
3) Авторизоваться пользователем «Harry Potter»;
4) Вычислить N-е число Фибоначчи, где N - это текущий день месяца + 1.
   Пример: сегодня 08.02.2023, 9-е чисто Фибоначчи равно 21;
5) Выполнить пополнение счета (Deposit) на сумму равную вычисленному в
   п.4 числу;
6) Выполнить списание со счета (Withdrawl) на сумму равную вычисленному
   в п.4 числу;
7) Выполнить проверку баланса - должен быть равен нулю;
8) Открыть страницу транзакций и проверить наличие обеих транзакций;
9) Сформировать файл формата csv, в который выгрузить данные о
   проведенных транзакциях;
   Файл должен содержать строки следующего формата
   <Дата-времяТранзакции Сумма ТипТранзакции>, где
   Формат Дата-времяТранзакции - "ДД Месяц ГГГГ ЧЧ:ММ:СС"
   Формат Сумма - число
   Формат ТипТранзакции - значение из списка [Credit, Debit]
10) Оформить сформированный файл как вложение к отчету allure. 

__________________________________________________________________

Для запуска тестов через Selenium GRID необходимо выполнить следующие шаги (описано для запуска на одной машине, для браузера Chrome):
1) Загрузите и распакуйте JAR-файлы Selenium Standalone server (например, selenium-server-standalone-3.14.0.jar).
2) Откройте командную строку или терминал и перейдите в каталог, в котором сохранен jar-файл Selenium Standalone Server. Запустите приведенную команду:

   java -jar selenium-server-standalone-3.14.0.jar -role hub

   Эта команда по умолчанию запускает центральный сервер (hub) Selenium Grid на порту 4444. Вы также можете проверить то же самое, перейдя по адресу http://localhost:4444/grid/console.
3) Откройте новое окно командной строки или терминала и запустите узлы кластера, указав расположение файлов драйвера браузера и выбрав порт (например, 5556), на котором узел будет зарегистрирован:

   java -Dwebdriver.chrome.driver="C:\chromedriver.exe" -jar selenium-server-standalone-3.14.0.jar -role webdriver -hub http://localhost:4444/grid/register -port 5556

4) Следующим шагом выполните автоматизированные тесты.