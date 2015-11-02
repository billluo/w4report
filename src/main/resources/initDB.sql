CREATE TABLE w4CycleDtlRpt (
  counted_date		VARCHAR(30),
  warehouse   		INTEGER,
  location_name		VARCHAR(30),
  sku_id            BIGINT,
  style				VARCHAR(30),
  expected_qty		INTEGER,
  actual_qty			INTEGER,
  variance_qty		INTEGER,
  PRIMARY KEY(counted_date,warehouse,location_name,sku_id),
);

--CREATE TABLE w4CycleDtlRpt (
--  counted_date		VARCHAR(30));
