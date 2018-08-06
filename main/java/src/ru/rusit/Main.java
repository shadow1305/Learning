/*
 * Тема: типы значений, условия, циклы.
 *
 * Типы значений подразделяются на примитивные и ссылочные.
 * Примитивные хранятся непосредственно в памяти, хранят в себе исключительно значение, с ними можно безпрепятственно пользоваться арифметическими операциями (сложение,
 * вычитание, умножение, деление, вычисление остатка от деления (7 % 2 вернет результат 1), сравнение, побитовые операции (сейчас почти не используются), инкремент (увеличение
 * на единицу, например, i++), декремент (уменьшение на единицу, например, i--). Каждая переменная такого типа изменяется независимо от других. Примитивных типов всего 7 (в
 * порядке возрастания макимального значения):
 * Целые:
 * byte - целое битовой длины (используется для работы с потоками данных)
 * short - короткое целое (почти не используется)
 * int - целое (самый частоиспользуемый тип, так как охватывает подавляющее большинство операций)
 * long - длинное целое
 *
 * Вещественные:
 * float
 * double - двойной точности
 *
 * Символы:
 * char
 *
 * Так же есть логический тип, учающий исключительно в сравнениях:
 * boolean (true/false)
 *
 * Да, и над символьными переменными тоже можно производить арифметические операции. Для вычислений будет браться код символа по кодировке (по умолчанию, UTF-8).
 * Одно и то же значение можно присваивать переменным разного типа. Присвоение значения любому более емкому типу проходит безболезненно, однако, например, в результате присвоения
 * вещественной переменной целому типу будет полностью отсечено дробная часть безо всяких округлений.
 *
 * Ссылочные типы значений.
 * Переменные такого типа хранят информацию о ссылке на объект в памяти. Над такими объектами нельзя производить арифметические операции (за исключением объектов, указанных ниже).
 * Однако, переменные такого типа могут содержать в себе методы обработки данных, содержащихся в них. Их мы можем вызывать по необходимости. Наиболее часто используемые:
 * String - строка (можно только складывать, операция называется "конкатенация". При складывании строк всегда создается новый объект, что часто - недешевое удовольствие. Как это
 *          обойти, расскажу позже).
 * Integer - целое
 * Long - длинное целое
 * Float - вещественное
 * Double - вещественное двойной точности
 *
 * Boolean - аналог boolean, который может быть неопределен.
 *
 * Все ссылочные переменные могут иметь состояние null. Это состояние говорит, что по ссылке, которую хранит переменная, нет объекта. Любой вызов метода такой переменной вызовет
 * ошибку. Есть еще малоиспользуемый тип Void - он подразумевает, что значения нет в принципе (места использования - тема будущих заданий).
 *
 * Крайне важно помнить, что изменение значения ссылочной переменной (кроме числовых, логической и строковой) повлияет на другие переменные, ссылающиеся на тот же объект.
 * Например, у нас есть такой объект:
 * class Person {
 *
 *  String name;
 *
 * }
 *
 * И есть такая конструкция:
 * Person sourcePerson = new Person();
 * Person first = sourcePerson;
 * Person second = sourcePerson;
 *
 * Если мы присвоим переменной name у любого из объектов значение, все остальные объекты вернут то же самое значение.
 * sourcePerson.name = "Вася";
 * String name = first.name; // Значение будет "Вася".
 *
 * Для изменения типа переменной можно (но не рекомендуется) использовать явное приведение. Выглядит оно следующим образом:
 * Integer intNumber = 1;
 * Double doubleNumber = (Integer) intNumber;
 *
 * Если типы переменных не совместимы, получим ошибку приведения.
 * Но бывают случаи, когда, например, нам пришла строка с числом, но нужно сделать с этим числом какое-либо арифметическое действие. Для реализации подобных действий у некоторых
 * объектов (например, объектов всех числовых классов и класса даты - Date) существует метод parse(String). Этот метод берет аргумент и пытается вытащить из него число. Если не
 * получается, получим ошибку.
 *
 * Есть такой тип данных, как массив. Технически и логически это набор значений, объединенных одним именем. Доступ к каждому значению идет по индексу. Работа с массивами идет
 * следующим образом:
 *
 * Number[] numbers = new Numbers[10]; // объявление массива объектов класса Number длиной в 10 элементов. Длина обязательна.
 * Number number = numbers[0]; // получение первого элемента массива (индексация всех без исключения структур данных идет с нуля)
 * Number secondNumber = numbers[10]; // получим ошибку - индекс вне границ массива. В объявленном массиве 10 элементов, индексация начинается с нуля, соответственно, у
 * последнего элемента индекс будет равен 9.
 * Number thirdNumber = numbers[-1]; // получим ошибку аналогичную описанной выше.
 *
 * Массивы бывают одномерные, как выше, и многомерные. Например:
 * Number[][] numbers = new Number[n]; numbers[0] = new Number[m]; - двумерный массив, где количество элементов на каждом измерениии может отличаться.
 * Number[,] numbers = new Number[n, m]; - двумерный массив, где количество элементов на каждом измерении не отличается.
 *
 * Многомерные массивы в прикладном программировании используются нечасто, так как с ними неудобно работать. Но знать, что они есть, надо.
 *
 * Условия:
 * условная конструкция выглядит следующим образом:
 *
 * if (condition) {
 * } else {
 * }
 *
 * condition - выражение сравнения или метод, обязательно возвращающий boolean.
 * В первый скобках указываются действия при прохождении условия, в противном случае else, который может отсутствовать, если действия не нужны. Несколько условных конструкций
 * можно комбинировать. Например:
 *
 * if (condition1) {
 * } else if (condition2) {
 * } else {
 *      if (condition3) {
 *      }
 * }
 *
 * Циклы:
 * есть несколько видов. Располагаю по убыванию частоты использования:
 * перебор, счетчик, предусловие, постусловие.
 * Перебор оставим на потом.
 * Счетчик:
 *
 * for (счетчик, условие, инкремент) {
 * }
 *
 * счетчик - переменная, считающая шаги
 * условие - условие выполнение цикла. Цикл повторяется пока условие истинно
 * инкремент - приращение счетчика каждый шаг
 *
 * Реальный пример:
 *
 * for (int i = 0; i < 10; i++) {
 * }
 *
 * i - счетчик, отсчет начинается с нуля
 * выполняем цикл пока i меньше 10
 * каждый шаг увеличивает i на единицу.
 *
 * Предусловие:
 *
 * while(условие) {
 * }
 *
 * Выполняется пока верно условие. Сначала проверка, потом выполнение.
 *
 * Постусловие:
 *
 * do {
 * } while(условие);
 *
 * Выполняется пока условие неверно. Сначала выполнение, потом проверка.
 *
 * Задание:
 * Дополнить метод excersize. Метод принимает массив строк, на выходе ожидается упорядоченный по возрастанию массив чисел.
 */

package ru.rusit;

public class Main {
    
    public static void main(String... args) {
        excersize(args);
    }
    
    public static Double[] excersize(String[] args) {
    }
}
