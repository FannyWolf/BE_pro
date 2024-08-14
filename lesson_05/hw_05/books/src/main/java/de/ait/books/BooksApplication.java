package de.ait.books;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
Выберете любую сущность, например Book.
Создайте приложение, используя https://start.spring.io/  Подключите зависимость Spring Web
По примеру написанному на занятие, создайте слои приложения, и реализуйте:
1) получение всех (книг) при get запросе на /books
2) добавление книги по запросу post
 */


@SpringBootApplication
public class BooksApplication {

	public static void main(String[] args) {
		SpringApplication.run(BooksApplication.class, args);
	}

}
