# Утилита фильтрации содержимого файлов.

Программа была написана с использованием Java версии 20, Maven версии 4.0.0.

В проекте используется библиотека commons-cli
- [Apache Commons CLI](https://commons.apache.org/proper/commons-cli/) - 1.4

## Как запустить

Команда `mvn clean package` очистит предыдущие сборки и создаст исполняемый JAR-файл. Предварительно в корневой папке проекта должны быть созданны файлы для ввода.

После успешной сборки вы можете запустить утилиту с помощью команды в командной строке.

<b>Пример: </b>

`java -jar util.jar -s -a -p sample- in1.txt in2.txt`

## Перечень команд
-s: Включает вывод краткой статистики.

-a: Включает режим добавления в существующие файлы.

-p sample-: Устанавливает префикс имен выходных файлов.

-f: Включатет вывод полной статистики.

-o output: Устанавливает директорию для вывода 

in1.txt in2.txt: Пример списка входных файлов для обработки.



## Условия для написания программы:

При запуске утилиты в командной строке подается несколько файлов, содержащих в перемешку целые числа, строки и вещественные числа. В качестве разделителяиспользуется перевод строки. Строки из файлов читаются по очереди в соответствии с их перечислением в командной строке.

Задача утилиты записать разные типы данных в разные файлы. Целые числа в одинвыходной файл, вещественные в другой, строки в третий. По умолчанию файлы с результатами располагаются в текущей папке с именами integers.txt, floats.txt, strings.txt. Дополнительно с помощью опции -o нужно уметь задавать путь для результатов. Опция -p задает префикс имен выходных файлов. Например -o /some/path -p result_ задают вывод в
файлы /some/path/result_integers.txt, /some/path/result_strings.txt и тд.

По умолчанию файлы результатов перезаписываются. С помощью опции -a можно задать режим добавления в существующие файлы. 

Файлы с результатами должны создаваться по мере необходимости. Если какого-то типа
данных во входящих файлах нет, то и создавать исходящий файл, который будет заведомо
пустым, не нужно.

В процессе фильтрации данных необходимо собирать статистику по каждому типу данных. Статистика должна поддерживаться двух видов: краткая и полная. Выбор статистики производится опциями -s и -f соответственно. Краткая статистика содержит только количество элементов записанных в исходящие файлы. Полная статистика для чисел дополнительно содержит минимальное и максимальное значения, сумма и среднее. Полная статистика для строк, помимо их количества, содержит также размер самой короткой строки и самой длинной.

Статистику по каждому типу отфильтрованных данных утилита должна вывести в консоль.

Все возможные виды ошибок должны быть обработаны. Программа не должна «падать». Если после ошибки продолжить выполнение невозможно, программа должна сообщить об этом пользователю с указанием причины неудачи. Частичная обработка при наличии ошибок более предпочтительна чем останов программы. Код программы должен быть «чистым».

___________________________________________________________________________________
