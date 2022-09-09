use codegym;
call getallproducts();
call addProducts(2,'pro-999','map',60,10,'good','uncheck');
call editproducts('pro-999','maps',50,12,'bad','check');
call getallproducts();
call deleteproducts('pro-999');