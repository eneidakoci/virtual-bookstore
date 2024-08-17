INSERT INTO Book (title, author, isbn, price, description, publisher, published_date, category)
VALUES
    ('The Great Gatsby', 'F. Scott Fitzgerald', '9780743273565', 10.99, 'A classic novel of the Jazz Age.', 'Scribner', '1925-04-10', 'Fiction'),
    ('1984', 'George Orwell', '9780451524935', 9.99, 'Dystopian novel set in a totalitarian society.', 'Harcourt', '1949-06-08', 'Science Fiction'),
    ('To Kill a Mockingbird', 'Harper Lee', '9780061120084', 12.99, 'Novel about racial injustice in the Deep South.', 'J.B. Lippincott & Co.', '1960-07-11', 'Fiction'),
    ('Moby Dick', 'Herman Melville', '9781503280786', 11.99, 'Epic tale of a sea captain’s obsession.', 'CreateSpace', '1851-10-18', 'Adventure'),
    ('Pride and Prejudice', 'Jane Austen', '9781503290563', 8.99, 'Romantic novel about manners and marriage.', 'CreateSpace', '1813-01-28', 'Romance'),
    ('The Catcher in the Rye', 'J.D. Salinger', '9780316769488', 10.99, 'Story of a teenager’s experiences in New York City.', 'Little, Brown and Company', '1951-07-16', 'Fiction'),
    ('Brave New World', 'Aldous Huxley', '9780060850524', 9.99, 'Dystopian novel exploring a futuristic society.', 'Harper Perennial Modern Classics', '1932-08-31', 'Science Fiction'),
    ('The Hobbit', 'J.R.R. Tolkien', '9780547928227', 13.99, 'Fantasy novel about the adventures of Bilbo Baggins.', 'Houghton Mifflin Harcourt', '1937-09-21', 'Fantasy'),
    ('Catch-22', 'Joseph Heller', '9781451626650', 11.99, 'Satirical novel about the absurdities of war.', 'Simon & Schuster', '1961-11-10', 'War Fiction'),
    ('The Lord of the Rings', 'J.R.R. Tolkien', '9780544003415', 19.99, 'Epic fantasy about the struggle to destroy a powerful ring.', 'Houghton Mifflin Harcourt', '1954-07-29', 'Fantasy');

INSERT INTO User (username, password, email, role, enabled, address)
VALUES
    ('johndoe', 'encrypted_password1', 'johndoe@example.com', 'ROLE_USER', TRUE, '123 Sample Street, Sample City, Sample State, 12345, Sample Country'),
    ('janedoe', 'encrypted_password2', 'janedoe@example.com', 'ROLE_USER', TRUE, '456 Another Road, Another City, Another State, 67890, Another Country'),
    ('admin', 'encrypted_password3', 'admin@example.com', 'ROLE_ADMIN', TRUE, '789 Admin Ave, Admin City, Admin State, 11223, Admin Country'),
    ('bobsmith', 'encrypted_password4', 'bobsmith@example.com', 'ROLE_USER', TRUE, '101 Main St, Main City, Main State, 45678, Main Country'),
    ('alicejones', 'encrypted_password5', 'alicejones@example.com', 'ROLE_USER', TRUE, '202 Elm St, Elm City, Elm State, 34567, Elm Country'),
    ('charlesbrown', 'encrypted_password6', 'charlesbrown@example.com', 'ROLE_USER', TRUE, '303 Oak St, Oak City, Oak State, 23456, Oak Country'),
    ('davidgreen', 'encrypted_password7', 'davidgreen@example.com', 'ROLE_USER', TRUE, '404 Pine St, Pine City, Pine State, 12345, Pine Country'),
    ('emilywhite', 'encrypted_password8', 'emilywhite@example.com', 'ROLE_USER', TRUE, '505 Maple St, Maple City, Maple State, 67890, Maple Country'),
    ('frankblack', 'encrypted_password9', 'frankblack@example.com', 'ROLE_USER', TRUE, '606 Birch St, Birch City, Birch State, 34567, Birch Country'),
    ('gracegray', 'encrypted_password10', 'gracegray@example.com', 'ROLE_USER', TRUE, '707 Cedar St, Cedar City, Cedar State, 45678, Cedar Country');

INSERT INTO ShoppingCart (user_id)
VALUES
    (1), (2), (3), (4), (5), (6), (7), (8), (9), (10);

INSERT INTO CartItem (cart_id, book_id, book_name, quantity)
VALUES
    (1, 1, 'The Great Gatsby', 1),
    (1, 2, '1984', 2),
    (2, 3, 'To Kill a Mockingbird', 1),
    (2, 4, 'Moby Dick', 3),
    (3, 5, 'Pride and Prejudice', 1),
    (3, 6, 'The Catcher in the Rye', 2),
    (4, 7, 'Brave New World', 1),
    (4, 8, 'The Hobbit', 2),
    (5, 9, 'Catch-22', 1),
    (5, 10, 'The Lord of the Rings', 1);

INSERT INTO Order (user_id, total, status)
VALUES
    (1, 20.98, 'PENDING'),
    (2, 27.98, 'SHIPPED'),
    (3, 12.99, 'DELIVERED'),
    (4, 37.97, 'PENDING'),
    (5, 31.98, 'CANCELED'),
    (6, 21.99, 'PENDING'),
    (7, 24.98, 'SHIPPED'),
    (8, 27.98, 'DELIVERED'),
    (9, 19.99, 'PENDING'),
    (10, 29.99, 'SHIPPED');

INSERT INTO OrderItem (order_id, book_id, quantity, price)
VALUES
    (1, 1, 1, 10.99),
    (1, 2, 2, 9.99),
    (2, 3, 1, 12.99),
    (2, 4, 3, 11.99),
    (3, 5, 1, 8.99),
    (3, 6, 2, 10.99),
    (4, 7, 1, 9.99),
    (4, 8, 2, 13.99),
    (5, 9, 1, 11.99),
    (5, 10, 1, 19.99);

INSERT INTO Category (name) VALUES ('Fiction'),('Non-Fiction'), ('Science Fiction'),('Fantasy')
('Biography'),('Historical'),('Romance'),'Thriller'),'Self-Help'),('Cookbook');


