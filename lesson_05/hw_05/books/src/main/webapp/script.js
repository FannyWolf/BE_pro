document.addEventListener("DOMContentLoaded", function() {
    const fetchButton = document.getElementById('fetch-button');
    const addBookButton = document.getElementById('add-book-button');

    fetchButton.addEventListener('click', fetchBooks);
    addBookButton.addEventListener('click', addBook);
});

function fetchBooks() {
    fetch('http://localhost:8080/books')
        .then(response => response.json())
        .then(books => {
            const booksContainer = document.getElementById('books-container');
            booksContainer.innerHTML = ''; // Очистка предыдущего списка книг
            books.forEach(book => {
                const bookDiv = document.createElement('div');
                bookDiv.classList.add('book');
                bookDiv.innerHTML = `
                    <h3>${book.id}. ${book.title}</h3>
                    <p>Author: ${book.author}</p>
                `;
                booksContainer.appendChild(bookDiv);
            });
        })
        .catch(error => console.error('Error fetching books:', error));
}

function addBook() {
    const titleInput = document.getElementById('title-input');
    const authorInput = document.getElementById('author-input');

    const title = titleInput.value.trim();
    const author = authorInput.value.trim();

    if (title === '' || author === '') {
        alert('Please enter both title and author.');
        return;
    }

    const newBook = {
        title: title,
        author: author
    };

    fetch('http://localhost:8080/books', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(newBook)
    })
        .then(response => {
            if (!response.ok) {
                return response.text().then(text => {
                    throw new Error(`Failed to add book: ${response.status} - ${text}`);
                });
            }
            titleInput.value = '';
            authorInput.value = '';
            fetchBooks(); // Обновление списка книг после добавления
        })
        .catch(error => console.error('Error adding book:', error));
}
