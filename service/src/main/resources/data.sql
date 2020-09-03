

CREATE TABLE IF NOT EXISTS public.tb_address (
  id INT AUTO_INCREMENT PRIMARY KEY,
  cep VARCHAR(10) NOT NULL,
  address VARCHAR(250) NOT NULL,
  n_number VARCHAR(10) NULL,
  complement VARCHAR(255) NULL,
  burgh VARCHAR(255) NULL,
  city VARCHAR(255) NOT NULL,
  uf VARCHAR(2) NOT NULL
);

CREATE TABLE IF NOT EXISTS public.tb_client (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  id_address INT
);


CREATE TABLE IF NOT EXISTS public.tb_email (
  id INT AUTO_INCREMENT PRIMARY KEY,
  email VARCHAR(255) NOT NULL,
  id_client INT NOT NULL
);


CREATE TABLE IF NOT EXISTS public.tb_phone (
  id INT AUTO_INCREMENT PRIMARY KEY,
  type VARCHAR(25) NOT NULL,
  n_number VARCHAR(25) NOT NULL,
  id_client INT NOT NULL
);

