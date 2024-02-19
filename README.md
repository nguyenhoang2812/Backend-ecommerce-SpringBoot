
https://github.com/tranthuyvy/Ecommerce_website_backend.git

                                                                           HOME CONTROLLER

http://localhost:8080/
-------------------------------------------------------------

                                                                           AUTH CONTROLLER

register: http://localhost:8080/auth/signup

{
  "firstName": "John",
  "lastName": "Doe",
  "email": "john.doe@example.com",
  "password": "password123",
  "mobile": "123456789",
  "points": 0,
  "user_rank": "BRONZE"
}



--------------------------------------------
login:  http://localhost:8080/auth/signin

{
  "email"   :"mio@gmail.com",
  "password":"password123"
}

gen token: eyJhbGciOiJIUzM4NCJ9.eyJpYXQiOjE3MDc5MjE0NjAsImV4cCI6MTcwODAwNzg2MCwiZW1haWwiOiJtaW9AZ21haWwuY29tIn0.Vd1Vh4zgjPOkuPJqnZHMwEMl_sYCI-Nl0b-ZqEcaIGHJhyINTZpYhMD08rYnybto 


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

{
  "firstName": "John",
  "lastName": "Doe",
  "email": "john.doe@example.com",
  "mobile": "123456789",
  "points": 400
}
rank dựa vào số point

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

{
  "id":4,
  "title": "Áo khoác nam",
  "description": "Áo khoác nam màu xanh đậm, kiểu dáng thời trang",
  "price": 300000,
  "discountedPrice": 270000,
  "discountPersent": 10,
  "quantity": 30,
  "brand": "Adidas",
  "color": "Navy Blue",
  "sizes": ["M", "L", "XL"],
  "imageUrl": "https://example.com/ao-khoac-nam.jpg",
  "topLavelCategory": "Danh mục cấp 1",
  "secondLavelCategory": "Danh mục cấp 2.2",
  "thirdLavelCategory": "Danh mục cấp 3.3"
}

🙃️thêm nhiều sản phầm
http://localhost:8080/api/admin/products/creates

[
  {
    "title": "Áo len nam",
    "description": "Áo len nam màu xám, kiểu dáng thời trang",
    "price": 500000,
    "discountedPrice": 400000,
    "discountPersent": 20,
    "quantity": 30,
    "brand": "H&M",
    "color": "Grey",
    "sizes": ["S", "M", "L"],
    "imageUrl": "https://example.com/ao-len-nam.jpg",
    "topLavelCategory": "Thời trang nam",
    "secondLavelCategory": "Áo len",
    "thirdLavelCategory": "Áo len dài tay"
  },
  {
    "title": "Váy dài nữ",
    "description": "Váy dài nữ màu đen, kiểu dáng thanh lịch",
    "price": 700000,
    "discountedPrice": 600000,
    "discountPersent": 14,
    "quantity": 20,
    "brand": "Zara",
    "color": "Black",
    "sizes": ["XS", "S", "M"],
    "imageUrl": "https://example.com/vay-dai-nu.jpg",
    "topLavelCategory": "Thời trang nữ",
    "secondLavelCategory": "Váy",
    "thirdLavelCategory": "Váy dài"
  }
]




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

{
  "productId": 54,
  "size": "M",
  "quantity": 3
}

😚️xóa sạch mọi sản phẩm trong giỏ  hàng
http://localhost:8080/api/cart/clear

---------------------------------------------------
                                                                           CART ITEM CONTROLLER
                                                                           
🤩️xóa 1 sản phẩm khỏi giỏ hàng theo id của sản phẩm trong giỏ hàng
http://localhost:8080/api/cart_items/4

☺️update 1 sản phẩm trong giỏ hàng 

http://localhost:8080/api/cart_items/6
{
  "cart": {
    "id": 1
  },
  "product": {
    "id": 54
  },
  "size": "M",
  "quantity": 5,
  "price": 500000,
  "discountedPrice": 400000,
  "userId": 1
}
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

😘️add sản phẩm vào order
http://localhost:8080/api/orders/
{
  "user": {
    "id": 1
  },
  "shippingAddress": {
    "street": "456 Elm St",
    "city": "City",
    "state": "State",
    "country": "Country",
    "zipcode": "12345"
  },
  "orderItems": [
    {
      "product": {
        "id": 2    
        },
      "quantity":1
    }
  ]
}



----------------------------------------------------
                                                                           ADMIN ORDER CONTROLLER
                                                                                                                                                      
                                                                                                                                                      
                                                                           






