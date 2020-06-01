CREATE TABLE product (
	id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    listPrice INT NOT NULL
);

CREATE TABLE provider (
	id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(127) NOT NULL
);

CREATE TABLE employee (
	id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(127) NOT NULL,
    address VARCHAR(255) NOT NULL
);

INSERT INTO product (name, listPrice) VALUES ("Mac Air", 1200), ("XPS 13 7390", 1500);
INSERT INTO provider (name) VALUES ("Apple"), ("Dell");
INSERT INTO employee (name, address) VALUES ("BinhDH", "hoacailand"), ("TuQT", "Nam Dinh"), ("QuangNC", "banhdauxanh"), ("QuynhTN", "Ha Nam");