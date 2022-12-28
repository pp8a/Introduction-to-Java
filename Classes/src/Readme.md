Скачать файл с заданиями: [Practice (tasks) (4).pdf](https://github.com/pp8a/Introduction-to-Java/files/10314747/Practice.tasks.4.pdf)
# 4. Programming with classes
Класс [Classes](https://github.com/pp8a/Introduction-to-Java/blob/main/Classes/src/Classes.java) для запуска меню и выбора задач описанных ниже. Путем выбора номера задачи. 

Все главные методы для выполнения задачи находятся в классе [Simple](https://github.com/pp8a/Introduction-to-Java/blob/main/Classes/src/Simple.java): ```void taskOne()```, ```void taskTwo()``` и так далее до ```void taskTen()```

Простейшие классы и объекты.
1. ```void taskOne()``` Создайте класс [Test1](https://github.com/pp8a/Introduction-to-Java/blob/main/Classes/src/Test1.java) с двумя переменными. Добавьте метод вывода на экран и методы изменения этих переменных. Добавьте метод, который находит сумму значений этих переменных, и метод, который находит наибольшее значение из этих двух переменных.
2. ```void taskTwo()``` Создйте класс [Test2](https://github.com/pp8a/Introduction-to-Java/blob/main/Classes/src/Test2.java) двумя переменными. Добавьте конструктор с входными параметрами. Добавьте конструктор, инициализирующий члены класса по умолчанию. Добавьте set- и get- методы для полей экземпляра класса.
3. ```void taskThree()``` Создайте класс с именем [Student](https://github.com/pp8a/Introduction-to-Java/blob/main/Classes/src/Student.java), содержащий поля: фамилия и инициалы, номер группы, успеваемость (массив из пяти элементов). Создайте массив из десяти элементов такого типа. Добавьте возможность вывода фамилий и номеров групп студентов, имеющих оценки, равные только 9 или 10.
4. ```void taskFour()``` Создайте класс [Train](https://github.com/pp8a/Introduction-to-Java/blob/main/Classes/src/Train.java), содержащий поля: название пункта назначения, номер поезда, время отправления.
Создайте данные в массив из пяти элементов типа Train, добавьте возможность сортировки элементов массива по номерам поездов. Добавьте возможность вывода информации о поезде, номер которого введен пользователем.
Добавьте возможность сортировки массив по пункту назначения, причем поезда с одинаковыми пунктами назначения должны быть упорядочены по времени отправления.
5. ```void taskFive()``` Опишите класс [DecimalCounter](https://github.com/pp8a/Introduction-to-Java/blob/main/Classes/src/DecimalCounter.java), реализующий десятичный счетчик, который может увеличивать или уменьшать свое значение на единицу в заданном диапазоне. Предусмотрите инициализацию счетчика значениями по умолчанию и
произвольными значениями. Счетчик имеет методы увеличения и уменьшения состояния, и метод позволяющее получить его текущее состояние. Написать код, демонстрирующий все возможности класса.
6. ```void taskSix()``` Составьте описание класса [MyTime](https://github.com/pp8a/Introduction-to-Java/blob/main/Classes/src/MyTime.java) для представления времени. Предусмотрте возможности установки времени и изменения его отдельных полей (час, минута, секунда) с проверкой допустимости вводимых значений. В случае недопустимых значений полей поле устанавливается в значение 0. Создать методы изменения времени на заданное количество часов, минут и секунд.
    * Используется: [TimeEnum](https://github.com/pp8a/Introduction-to-Java/blob/main/Classes/src/TimeEnum.java).
7. ```void taskSeven()``` Описать класс [Triangle](https://github.com/pp8a/Introduction-to-Java/blob/main/Classes/src/Triangle.java), представляющий треугольник. Предусмотреть методы для создания объектов, вычисления площади, периметра и точки пересечения медиан.
    * Используется: [Point](https://github.com/pp8a/Introduction-to-Java/blob/main/Classes/src/Point.java), [Calculation](https://github.com/pp8a/Introduction-to-Java/blob/main/Classes/src/Calculation.java).
8. ```void taskEight()``` Создать класс [Customer](https://github.com/pp8a/Introduction-to-Java/blob/main/Classes/src/Customer.java), спецификация которого приведена ниже. Определить конструкторы, set- и get- методы и метод toString(). Создать второй класс, агрегирующий массив типа Customer, с подходящими конструкторами
и методами. Задать критерии выбора данных и вывести эти данные на консоль.
Класс [Customer](https://github.com/pp8a/Introduction-to-Java/blob/main/Classes/src/Customer.java): id, фамилия, имя, отчество, адрес, номер кредитной карточки, номер банковского счета.
Найти и вывести:
    * список покупателей в алфавитном порядке;
    * список покупателей, у которых номер кредитной карточки находится в заданном интервале.
    
    * Используется: [CustomerData](https://github.com/pp8a/Introduction-to-Java/blob/main/Classes/src/CustomerData.java)
9. ```void taskNine()``` Создать класс [Book](https://github.com/pp8a/Introduction-to-Java/blob/main/Classes/src/Book.java), спецификация которого приведена ниже. Определить конструкторы, set- и get- методы и метод toString(). Создать второй класс, агрегирующий массив типа Book, с подходящими конструкторами и
методами. Задать критерии выбора данных и вывести эти данные на консоль.
[Book](https://github.com/pp8a/Introduction-to-Java/blob/main/Classes/src/Book.java): id, название, автор(ы), издательство, год издания, количество страниц, цена, тип переплета.
Найти и вывести:
    * список книг заданного автора;
    * список книг, выпущенных заданным издательством;
    * список книг, выпущенных после заданного года.
    
    * Используется: [BookData](https://github.com/pp8a/Introduction-to-Java/blob/main/Classes/src/BookData.java), [BookType](https://github.com/pp8a/Introduction-to-Java/blob/main/Classes/src/BookType.java).
10. ```void taskTen()``` Создать класс [Airline](https://github.com/pp8a/Introduction-to-Java/blob/main/Classes/src/Airline.java), спецификация которого приведена ниже. Определить конструкторы, set- и get- методы и метод toString(). Создать второй класс, агрегирующий массив типа Airline, с подходящими конструкторами и
методами. Задать критерии выбора данных и вывести эти данные на консоль.
[Airline](https://github.com/pp8a/Introduction-to-Java/blob/main/Classes/src/Airline.java): пункт назначения, номер рейса, тип самолета, время вылета, дни недели.
Найти и вывести:
    * список рейсов для заданного пункта назначения;
    * список рейсов для заданного дня недели;
    * список рейсов для заданного дня недели, время вылета для которых больше заданного.
    
    * Используется: [AirlineData](https://github.com/pp8a/Introduction-to-Java/blob/main/Classes/src/AirlineData.java), [AircraftType](https://github.com/pp8a/Introduction-to-Java/blob/main/Classes/src/AircraftType.java).
# [Агрегация и композиция](https://github.com/pp8a/Introduction-to-Java/tree/main/Classes/src/AggregationComposition)
1. [Package Text](https://github.com/pp8a/Introduction-to-Java/tree/main/Classes/src/AggregationComposition/Text). Создать объект класса [Текст](https://github.com/pp8a/Introduction-to-Java/blob/main/Classes/src/AggregationComposition/Text/Text.java), используя классы [Предложение](https://github.com/pp8a/Introduction-to-Java/blob/main/Classes/src/AggregationComposition/Text/Sentence.java), [Слово](https://github.com/pp8a/Introduction-to-Java/blob/main/Classes/src/AggregationComposition/Text/Word.java). Методы: дополнить текст, вывести на консоль текст, заголовок текста.
    * [Run main](https://github.com/pp8a/Introduction-to-Java/blob/main/Classes/src/AggregationComposition/Text/main.java).
2. [Package Car](https://github.com/pp8a/Introduction-to-Java/tree/main/Classes/src/AggregationComposition/Car). Создать объект класса [Автомобиль](https://github.com/pp8a/Introduction-to-Java/blob/main/Classes/src/AggregationComposition/Car/Car.java), используя классы [Колесо](https://github.com/pp8a/Introduction-to-Java/blob/main/Classes/src/AggregationComposition/Car/Wheel.java), [Двигатель](https://github.com/pp8a/Introduction-to-Java/blob/main/Classes/src/AggregationComposition/Car/Engine.java). Методы: ехать, заправляться, менять колесо, вывести на консоль марку автомобиля.
    * [Run main](https://github.com/pp8a/Introduction-to-Java/blob/main/Classes/src/AggregationComposition/Car/main.java).
3. [Package State](https://github.com/pp8a/Introduction-to-Java/tree/main/Classes/src/AggregationComposition/State). Создать объект класса [Государство](https://github.com/pp8a/Introduction-to-Java/blob/main/Classes/src/AggregationComposition/State/State.java), используя классы [Область](https://github.com/pp8a/Introduction-to-Java/blob/main/Classes/src/AggregationComposition/State/Region.java), [Район](https://github.com/pp8a/Introduction-to-Java/blob/main/Classes/src/AggregationComposition/State/District.java), [Город](https://github.com/pp8a/Introduction-to-Java/blob/main/Classes/src/AggregationComposition/State/City.java). Методы: вывести на консоль столицу, количество областей, площадь, областные центры.
    * [Run main](https://github.com/pp8a/Introduction-to-Java/blob/main/Classes/src/AggregationComposition/State/main.java).
4. [Package Bank](https://github.com/pp8a/Introduction-to-Java/tree/main/Classes/src/AggregationComposition/Bank). [Счета](https://github.com/pp8a/Introduction-to-Java/blob/main/Classes/src/AggregationComposition/Bank/Account.java). [Клиент](https://github.com/pp8a/Introduction-to-Java/blob/main/Classes/src/AggregationComposition/Bank/Customer.java) может иметь несколько счетов в [банке](https://github.com/pp8a/Introduction-to-Java/blob/main/Classes/src/AggregationComposition/Bank/Bank.java). Учитывать возможность блокировки/разблокировки
счета. Реализовать поиск и сортировку счетов. Вычисление общей суммы по счетам. Вычисление суммы по всем счетам, имеющим положительный и отрицательный балансы отдельно.
    * [Run main](https://github.com/pp8a/Introduction-to-Java/blob/main/Classes/src/AggregationComposition/Bank/main.java).
5. [Package Tourist](https://github.com/pp8a/Introduction-to-Java/tree/main/Classes/src/AggregationComposition/Tourist). [Туристические](https://github.com/pp8a/Introduction-to-Java/blob/main/Classes/src/AggregationComposition/Tourist/Tourist.java) путевки. Сформировать набор предложений клиенту по выбору туристической [путевки](https://github.com/pp8a/Introduction-to-Java/blob/main/Classes/src/AggregationComposition/Tourist/Voucher.java) различного типа (отдых, экскурсии, лечение, шопинг, круиз и т. д.) для оптимального выбора. Учитывать возможность выбора транспорта, питания и числа дней. Реализовать выбор и сортировку путевок.
    * [Run main](https://github.com/pp8a/Introduction-to-Java/blob/main/Classes/src/AggregationComposition/Tourist/main.java).
