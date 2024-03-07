
http://localhost:8080/
-------------------------------------------------------------

                                                                           AUTH CONTROLLER

register: http://localhost:8080/auth/signup



--------------------------------------------
login:  http://localhost:8080/auth/signin

                                                                           USER CONTROLLER

--------------------------------------------
😇️lấy thông tin tất cả user
get all users: 
http://localhost:8080/api/users/all

authorization : token
                Beaker  eyJhbGciOiJIUzM4NCJ9.eyJpYXQiOjE3MDc5MjE0NjAsImV4cCI6MTcwODAwNzg2MCwiZW1haWwiOiJtaW9AZ21haWwuY29tIn0.Vd1Vh4zgjPOkuPJqnZHMwEMl_sYCI-Nl0b-ZqEcaIGHJhyINTZpYhMD08rYnybto

--------------------------------------------
😀️lấy thông tin người dùng đang đăng nhập

get profile: http://localhost:8080/api/users/profile  

😄️sửa thông tin người dùng

put profile: http://localhost:8080/api/users/profile  

-----------------------------------------------
                                                                           USER PRODUCT CONTROLLER
😜️lấy thông tin sản phẩm theo brand  
http://localhost:8080/api/products/brand/{brand}

😝️lấy thông tin sản phẩm theo category
http://localhost:8080/api/products/category/Áo%20bò%20nam

😇️lấy thông tin sản phẩm theo id
http://localhost:8080/api/products/id/1                                                                       

😚️tìm kiếm sản phầm theo từ khóa
http://localhost:8080/api/products/search?q=áo                                                                          
-----------------------------------------------
                                                                           ADMIN PRODUCT CONTROLLER 
😉️thêm 1 sản phẩm
http://localhost:8080/api/admin/products/


🙃️thêm nhiều sản phầm
http://localhost:8080/api/admin/products/creates

---------------------------------------------------
🙃️xóa sản phầm 
http://localhost:8080/api/admin/products/1/delete

vấn đề : không xóa được trong csdl, chỉ đánh dấu là sản phẩm ngừng bán
---------------------------------------------------
🤩️update sản phẩm
http://localhost:8080/api/admin/products/1/update

vấn đề: chưa update được trường sizes
----------------------------------------------------

                                                                           REVIEW CONTROLLER 
😇️lấy thông tin review theo id sản phẩm
http://localhost:8080/api/reviews/product/53

😇️create review theo id sản phẩm
http://localhost:8080/api/reviews/create
{
  "productId": 53,
  "review": "Giá sản phẩm này rất tốt!",
  "star": 4
}

---------------------------------------------------

                                                                           CART CONTROLLER 
🥰️lấy thông tin giỏ hàng của người dùng đã đăng nhập 
http://localhost:8080/api/cart/      
               
😉️thêm sản phẩm vào giỏ hàng của người dùng (PUT)
http://localhost:8080/api/cart/add                                                  

😚️xóa sạch mọi sản phẩm trong giỏ  hàng
http://localhost:8080/api/cart/clear

---------------------------------------------------
                                                                           CART ITEM CONTROLLER
                                                                           
🤩️xóa 1 sản phẩm khỏi giỏ hàng theo id của sản phẩm trong giỏ hàng
http://localhost:8080/api/cart_items/4

☺️update 1 sản phẩm trong giỏ hàng 

http://localhost:8080/api/cart_items/6

----------------------------------------------------
                                                                           ORDER CONTROLLER

☺️lấy thông tin order theo id
http://localhost:8080/api/orders/10

🥰️lấy thông tin order đã được xác nhận
http://localhost:8080/api/orders/confirmed

🤔️lấy thông tin order đã được vận chuyển
http://localhost:8080/api/orders/shipped

😉️lấy thông tin order đã được giao
http://localhost:8080/api/orders/delivered

😗️lấy thông tin order bị hoàn lại
http://localhost:8080/api/orders/cancelled

😋️lấy thông tin order đã giao dịch thành công 
http://localhost:8080/api/orders/success

😘️add địa chỉ giao hàng vào order
http://localhost:8080/api/orders/

----------------------------------------------------
                                                                           ADMIN ORDER CONTROLLER
                                                                                                                                                      
http://localhost:8080/api/admin/orders/9/confirmed 

ship
deliver      
cancel
success  
delete 
update-payment-status 

-----------------------------------------------------                                                                                                                                           
                                                                           PAYMENT CONTROLLER 
                                                                           
create payment section                                                                                                                               
http://localhost:8080/api/payments/19
/payments/{orderId}

123456789
mio@gmail.com


----------------------------------------------------
                                                                           ADMIN ORDER CONTROLLER
                                                                                                                                                      
                                                                                                                                                      
                                                                           






