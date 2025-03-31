CREATE TABLE lunch_menu (
                            id INT PRIMARY KEY AUTO_INCREMENT,
                            name VARCHAR(100),
                            category VARCHAR(50),
                            description TEXT
);

INSERT INTO lunch_menu (name, category, description) VALUES
                                                         ('김치찌개', '한식', '매콤한 김치가 들어간 전통 한식 찌개'),
                                                         ('초밥', '일식', '신선한 생선을 올린 일본식 초밥'),
                                                         ('스파게티', '양식', '토마토 소스로 맛을 낸 스파게티');

# DROP TABLE lunch_menu;