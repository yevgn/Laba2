package ru.antonov.laba2

import ru.antonov.laba2.entity.Book

// Ленивая инициализация
lateinit var MAIN: MainActivity

//  Начальный список книг
val bookList : MutableList<Book> = mutableListOf(
    Book( "Братья Карамазовы", "Федор Достоевский", 1950, "Роман"),
    Book( "Портрет Дориана Грея", "Оскар Уайльд", 1950, "Роман"),
    Book( "48 законов власти", "Роберт Грин", 1950, "Роман"),
    Book( "Атлант Расправил плечи", "Айн Рэнд", 1950, "Роман"),
    Book( "О дивный новый мир", "Олдос Хаксли", 1950, "Роман"),
    Book( "Пролетая над гнездом кукушки", "Кен Кизи", 1950, "Роман"),
    Book( "Над пропастью во ржи", "Джэром Сэлинджер", 1950, "Роман"),
    Book("Великий Гэтсби", "Фрэнсис Скотт Фицджеральд", 1950, "Роман"),
        Book( "Война и мир", "Лев Толстой", 1950, "Роман"),
    Book("Повести Белкина", "Александр Пушкин", 1950, "Роман"),
    Book( "Преступление и наказание", "Федор Достоевский", 1950, "Роман"),
    Book( "1984", "Джордж Оруэлл", 1950, "Роман"),
    Book( "Мы", "Евгений Замятин", 1950, "Роман"),
    Book( "Так говорил Заратустра", "Фридрих Ницше", 1950, "Роман"),
    Book( "Государь", "Никколо Макиавелли", 1950, "Роман"),
    Book( "Обломов", "Иван Гончаров", 1950, "Роман"),
    Book( "Моби Дик", "Герман Мелвилл", 1950, "Роман"),
    Book( "Овод", "Этель Лилиан Войнич", 1950, "Роман"),
    Book( "Граф Монте-Кристо. Том 1", "Александр Дюма", 1950, "Роман"),
    Book( "Граф Монте-Кристо. Том 2", "Александр Дюма", 1950, "Роман")
)

