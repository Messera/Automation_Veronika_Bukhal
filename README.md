1.1 Команда для просмотра доступных обновлений библиотек:
  
- mvn versions:display-dependency-updates
  [INFO] No dependencies in Dependencies have newer versions.

1.2. Команда для автоматического обновления всех версий: 
- mvn versions:use-latest-versions
  [INFO] Major version changes allowed


2. Команда для запуска тестов через testng.xml файл:
- mvn clean test -DsuiteXmlFile=Lecture10
  [INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 10.217 s - in TestSuite

3. ?
4. ?