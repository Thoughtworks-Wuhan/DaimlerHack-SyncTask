DROP TABLE IF EXISTS CAR;

CREATE TABLE CAR (
  id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
  brand VARCHAR(200) NOT NULL,
  ROAD_HAUL  DECIMAL(3,1) NOT NULL,
  USED_MONTHS INT NOT NULL,
  NEW_CAR_PRICE DECIMAL(5,2) NOT NULL,
  SELL_PRICE DECIMAL(5,2) NOT NULL,
  GEARBOX_TYPE VARCHAR(10),
  INDEX CAR_BRAND( brand(200) )
);
