INSERT INTO events (event_name, event_date, venue, venue_address) VALUES ('Anacondaz. Премьера Альбома','2022-11-12 19:00:00','Glavclub','г.Москва ул.Ордженекидзе д.11');
INSERT INTO events (event_name, event_date, venue, venue_address) VALUES ('Summer Sound 2022','2022-07-28 20:00:00','Пространство "Флакон"','г.Москва ул. Большая Новодмияровская д.36');

INSERT INTO orders (order_id,client_name, client_address, client_phone, tickets_count, sum) VALUES (1,'Антон','г.Москва ул. Покровская д.12 кв.330','+7(925)327-45-20',2,13000);
INSERT INTO orders (order_id,client_name, client_address, client_phone, tickets_count, sum) VALUES (2,'Дарья','г.Москва ул. Красноярская д.5 кв.70','',1,5000);
INSERT INTO orders (order_id,client_name, client_address, client_phone, tickets_count, sum) VALUES (3,'Леонид','г.Москва ул. Кольцовская д.15 кв.33','',2,4000);
INSERT INTO orders (order_id,client_name, client_address, client_phone, tickets_count, sum) VALUES (4,'Светлана','г.Москва ул. Ленина д.15','+7(905)133-25-40',1,3500);


INSERT INTO tickets (number, sum, order_id,event_id) VALUES (random()  *  1000 + 1,3500,4,1);
INSERT INTO tickets (number, sum, order_id,event_id) VALUES (random()  *  1000 + 1,5000,2,2);
INSERT INTO tickets (number, sum, order_id,event_id) VALUES (random()  *  1000 + 1,6500,1,2);
INSERT INTO tickets (number, sum, order_id,event_id) VALUES (random()  *  1000 + 1,2000,3,1);
INSERT INTO tickets (number, sum, order_id,event_id) VALUES (random()  *  1000 + 1,6500,1,2);
INSERT INTO tickets (number, sum, order_id,event_id) VALUES (random()  *  1000 + 1,2000,3,1);
