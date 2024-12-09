# Police Ticket Management System

พัฒนาแอพพริเคชั่นด้วยภาษา Java และเก็บข้อมูลใน phpMyAdmin
## Features

- **ระบบสมัครสมาชิก**: 
  - เก็บข้อมูล Email, Password, ชื่อ-นามสกุล, เพช ลงฐานข้อมูล
- **ระบบล็อคอิน**:
  - ตรวจสอบ Email, Password ที่เก็บในฐานข้อมูล ว่าตรวงกับที่ Input มาไหม ถ้าตรงก็เข้าสู่ระบบใช้งานถ้าไม่ตรงจะไม่สามารถเข้าสู่ระบบได้
- **Ticket Status Management**:
  - ติดตามสถานะของใบสั่งจราจร สามารถดูได้ว่ามีใบสั่งทั้งหมดเท่าไหร่และจ่ายไปแล้วหรือยัง
- **License Violation**:
  - ระบบเขียนมบสั่งโดยตำรวจสามารถใส่ข้อมูลผู้กระทำผิดพร้อมที่อยู่ได้และจะติดตามสถานะการชำระเงิน

## Technologies Used

- **FontEnd**: 
  - Java (Net-Beans)
- **Database**: 
  - phpMyAdmin
  
## ตัวอย่างหน้าแอพพริเคชั่น
### หน้าล็อคอิน
![Login Page](/assets/login.png)

### หน้าสมัครสมาชิก
![Register Page](/assets/register.png)

### หน้าหลัก
![Munu Page](/assets/menu.png)

### หน้าเขียนใบสั่ง
![violation Page](/assets/payticket.png)

### หน้าติดตามผู้ที่ยังไม่ได้ชำระค่าใบสั่ง
![violation Page](/assets/unpaid.png)