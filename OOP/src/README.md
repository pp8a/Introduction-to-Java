Скачать файл заданий: [Practice (tasks) (5).pdf](https://github.com/pp8a/Introduction-to-Java/files/10300529/Practice.tasks.5.pdf)

# 5. Basics of OOP

## Задача 1. [MyFile](https://github.com/pp8a/Introduction-to-Java/tree/main/OOP/src/MyFile).
Создать объект класса [Текстовый файл](https://github.com/pp8a/Introduction-to-Java/blob/main/OOP/src/MyFile/MyText.java), используя классы [Файл](https://github.com/pp8a/Introduction-to-Java/blob/main/OOP/src/MyFile/MyFile.java), [Директория](https://github.com/pp8a/Introduction-to-Java/blob/main/OOP/src/MyFile/MyDirectory.java). Методы: создать, переименовать, вывести на консоль содержимое, дополнить, удалить.    
    * [Run main](https://github.com/pp8a/Introduction-to-Java/blob/main/OOP/src/MyFile/main.java).    
## Задача 2. [Payment](https://github.com/pp8a/Introduction-to-Java/tree/main/OOP/src/Payment).
Создать класс Payment с внутренним классом ([Bank](https://github.com/pp8a/Introduction-to-Java/blob/main/OOP/src/Payment/Bank.java), [Provider](https://github.com/pp8a/Introduction-to-Java/blob/main/OOP/src/Payment/Provider.java)), с помощью объектов которого можно сформировать покупку из нескольких товаров.
    * [Run main](https://github.com/pp8a/Introduction-to-Java/blob/main/OOP/src/Payment/main.java).    
## Задача 3. [Calendar](https://github.com/pp8a/Introduction-to-Java/tree/main/OOP/src/Calendar).
Создать класс [Календарь](https://github.com/pp8a/Introduction-to-Java/blob/main/OOP/src/Calendar/Calendar.java) с внутренним классом, с помощью объектов которого можно хранить информацию о выходных и праздничных днях.
    * [Run main](https://github.com/pp8a/Introduction-to-Java/blob/main/OOP/src/Calendar/main.java).
## Задача 4. [Treasures](https://github.com/pp8a/Introduction-to-Java/tree/main/OOP/src/Treasures).
Создать консольное приложение, удовлетворяющее следующим требованиям: 
    
    * Приложение должно быть объектно-, а не процедурно-ориентированным. 
    
    * Каждый класс должен иметь отражающее смысл название и информативный состав. 

    * Наследование должно применяться только тогда, когда это имеет смысл. 

    * При кодировании должны быть использованы соглашения об оформлении кода java code convention. 

    * Классы должны быть грамотно разложены по пакетам. 

    * Консольное меню должно быть минимальным. 

    * Для хранения данных можно использовать [файлы](https://github.com/pp8a/Introduction-to-Java/blob/main/OOP/src/Treasures/treasures.txt).

Дракон и его [сокровища](https://github.com/pp8a/Introduction-to-Java/blob/main/OOP/src/Treasures/Treasures.java). Создать программу, позволяющую обрабатывать сведения о 100 сокровищах в [пещере дракона](https://github.com/pp8a/Introduction-to-Java/blob/main/OOP/src/Treasures/Cave.java). Реализовать возможность просмотра сокровищ, выбора самого дорогого по стоимости сокровища и выбора сокровищ на заданную сумму.
    * [Run main](https://github.com/pp8a/Introduction-to-Java/blob/main/OOP/src/Treasures/main.java).
## Задача 5. [composition](https://github.com/pp8a/Introduction-to-Java/tree/main/OOP/src/composition)

Создать консольное приложение, удовлетворяющее следующим требованиям: 

    * Корректно спроектируйте и реализуйте предметную область задачи. 

    * Для создания объектов из иерархии классов продумайте возможность использования порождающих шаблонов проектирования.

    * Реализуйте проверку данных, вводимых пользователем, но не на стороне клиента.

    * Для проверки корректности переданных данных можно применить регулярные выражения.

    * Меню выбора действия пользователем можно не реализовывать, используйте заглушку.

    * Особое условие: переопределите, где необходимо, методы toString(), equals() и hashCode().

Вариант A. Цветочная композиция. Реализовать приложение, позволяющее создавать цветочные композиции (объект, представляющий собой цветочную композицию). Составляющими цветочной композиции являются цветы и упаковка.

Вариант B. Подарки. Реализовать приложение, позволяющее создавать подарки (объект, представляющий собой подарок). Составляющими целого подарка являются сладости и упаковка.
