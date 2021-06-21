SELECT distinct maker FROM pc JOIN product ON pc.model = product.model WHERE pc.speed >= 2.1 AND maker IN (SELECT maker FROM laptop JOIN product ON laptop.model = product.model WHERE laptop.speed >= 2.1);