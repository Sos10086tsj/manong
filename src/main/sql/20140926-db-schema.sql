ALTER table info_tougao add column accept_date DATETIME;
ALTER table info_tougao add column accept_user VARCHAR(45);
ALTER table info_tougao add column published boolean DEFAULT false;