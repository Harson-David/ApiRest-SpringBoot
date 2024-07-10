-- Inserts DB store


-- customer

INSERT INTO customer (id_customer, name, address, email, phone_number)
VALUES 
    (1, 'John Doe', '123 Main St, Springfield', 'john.doe@example.com', '555-1234'),
    (2, 'Jane Smith', '456 Elm St, Rivertown', 'jane.smith@example.com', '555-5678'),
    (3, 'Michael Johnson', '789 Oak St, Lakeside', 'michael.j@example.com', '555-9876'),
    (4, 'Emily Davis', '101 Pine St, Mountainview', 'emily.davis@example.com', '555-4321'),
    (5, 'Sarah Wilson', '202 Cedar St, Parkville', 'sarah.wilson@example.com', '555-8765');





-- pizza

INSERT INTO pizza (id_pizza, name, description, price, vegeterian, vegan, available)
VALUES 
    (1, 'Margherita', 'Classic margherita pizza', 10.50, true, false, true),
    (2, 'Pepperoni', 'Spicy pepperoni pizza', 12.00, false, false, true),
    (3, 'Hawaiian', 'Pineapple and ham pizza', 11.50, false, false, true),
    (4, 'Vegetarian', 'Mixed vegetables pizza', 11.00, true, true, true),
    (5, 'BBQ Chicken', 'BBQ chicken and onion pizza', 13.50, false, false, true);


-- pizza_order

INSERT INTO pizza_order (id_order, id_customer, date, total, method, aditional_notes)
VALUES 
    (1, 1, '2023-05-10 12:30:00', 25.00, 'E', 'Extra cheese please!'),
    (2, 2, '2023-05-11 18:45:00', 23.00, 'C', 'Gluten-free crust'),
    (3, 3, '2023-05-12 20:00:00', 30.00, 'C', 'No onions on any pizza'),
    (4, 4, '2023-05-13 19:15:00', 28.50, 'C', 'Extra spicy'),
    (5, 5, '2023-05-14 17:30:00', 26.00, 'E', 'None');
    
    
-- item_order

INSERT INTO item_order (id_item, id_order, id_pizza, pizza ,quantity, price)
VALUES 
    (1, 1, 1, 2, 2, 21.00),
    (2, 1, 3, 4, 1, 4.00),
    (3, 2, 2, 3, 1, 12.00),
    (4, 3, 4, 1, 3, 33.00),
    (5, 4, 5, 5, 1, 13.50);

