CREATE TABLE Book (
                      book_id INT AUTO_INCREMENT PRIMARY KEY,
                      title VARCHAR(255) NOT NULL,
                      author VARCHAR(255) NOT NULL,
                      isbn VARCHAR(20) UNIQUE NOT NULL,
                      price DECIMAL(10, 2) NOT NULL,
                      description TEXT,
                      publisher VARCHAR(255),
                      published_date DATE,
                      category_id INT,
                      FOREIGN KEY (category_id) REFERENCES Category(category_id)
);

CREATE TABLE User (
                      user_id INT AUTO_INCREMENT PRIMARY KEY,
                      username VARCHAR(50) UNIQUE NOT NULL,
                      password VARCHAR(255) NOT NULL,
                      email VARCHAR(100) UNIQUE NOT NULL,
                      role VARCHAR(50) NOT NULL,
                      enabled BOOLEAN DEFAULT TRUE,
                      address VARCHAR(255)
);

CREATE TABLE ShoppingCart (
                              cart_id INT AUTO_INCREMENT PRIMARY KEY,
                              user_id INT NOT NULL,
                              created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                              FOREIGN KEY (user_id) REFERENCES User(user_id)
);

CREATE TABLE CartItem (
                          cart_item_id INT AUTO_INCREMENT PRIMARY KEY,
                          cart_id INT NOT NULL,
                          book_id INT NOT NULL,
                          book_name VARCHAR(255),
                          quantity INT NOT NULL,
                          FOREIGN KEY (cart_id) REFERENCES ShoppingCart(cart_id),
                          FOREIGN KEY (book_id) REFERENCES Book(book_id)
);

CREATE TABLE `Order` (
                         order_id INT AUTO_INCREMENT PRIMARY KEY,
                         user_id INT NOT NULL,
                         order_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                         total DECIMAL(10, 2) NOT NULL,
                         status VARCHAR(50) DEFAULT 'PENDING',
                         FOREIGN KEY (user_id) REFERENCES User(user_id)
);

CREATE TABLE OrderItem (
                           order_item_id INT AUTO_INCREMENT PRIMARY KEY,
                           order_id INT NOT NULL,
                           book_id INT NOT NULL,
                           quantity INT NOT NULL,
                           price DECIMAL(10, 2) NOT NULL,
                           FOREIGN KEY (order_id) REFERENCES `Order`(order_id),
                           FOREIGN KEY (book_id) REFERENCES Book(book_id)
);
CREATE TABLE Category (
                          category_id INT AUTO_INCREMENT PRIMARY KEY,
                          name VARCHAR(100) NOT NULL UNIQUE
);
